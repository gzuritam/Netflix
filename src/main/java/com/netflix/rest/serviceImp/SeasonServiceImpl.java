package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.SeasonRepository;
import com.netflix.rest.service.SeasonServiceI;

@Service
@Qualifier("SeasonServiceImpl")
public class SeasonServiceImpl implements SeasonServiceI {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("SeasonRepository")
	private SeasonRepository seasonRepository;
	
	@Override
	public List<SeasonDto> listSeasonsByTvShow(TvShow tvShow) {
		return seasonRepository.findByTvShow(tvShow)
				.stream()
				.map(season -> modelMapper.map(season, SeasonDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public SeasonDto findSeasonByNumberAndTvShow(int seasonNumber, TvShow tvShow) {
		return modelMapper.map(seasonRepository.findByNumberAndTvShow(seasonNumber,tvShow), SeasonDto.class);
	}
	
	

}

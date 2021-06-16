package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.SeasonRepository;
import com.netflix.rest.service.SeasonServiceI;

/**
 * The Class SeasonServiceImpl.
 */
@Service
@Qualifier("SeasonServiceImpl")
public class SeasonServiceImpl implements SeasonServiceI {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/** The season repository. */
	@Autowired
	@Qualifier("SeasonRepository")
	private SeasonRepository seasonRepository;
	
	/**
	 * List seasons by tv show.
	 * @param tvShow the tv show
	 * @return the list
	 */
	@Override
	public List<SeasonDto> listSeasonsByTvShow(TvShow tvShow) {
		return seasonRepository.findByTvShow(tvShow)
				.stream()
				.map(season -> modelMapper.map(season, SeasonDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * Find season by number and tv show.
	 * @param seasonNumber the season number
	 * @param tvShow the tv show
	 * @return the season dto
	 */
	@Override
	public SeasonDto findSeasonByNumberAndTvShow(int seasonNumber, TvShow tvShow) {
		Season season = seasonRepository.findByNumberAndTvShow(seasonNumber,tvShow);
		return season != null ? modelMapper.map(season, SeasonDto.class) : null;
	}
	
	

}

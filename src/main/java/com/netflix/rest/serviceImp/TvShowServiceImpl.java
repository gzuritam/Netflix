package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.TvShowServiceI;

@Service
@Qualifier("TvShowServiceImpl")
public class TvShowServiceImpl implements TvShowServiceI {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	@Qualifier("TvShowRepository")
	private TvShowRepository tvShowRepository;

	@Override
	public TvShowDto findTvShowById(TvShow tvShow) {
		return modelMapper.map(tvShow, TvShowDto.class);
	}

	@Override
	public List<TvShowDto> listTvShowByCategory(Category category) {
		return tvShowRepository.findByCategory(category)
				.stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowDto.class))
				.collect(Collectors.toList());
	}

}

package com.netflix.rest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Season;
import com.netflix.rest.repository.SeasonRepository;
import com.netflix.rest.service.SeasonServiceI;
import com.netflix.rest.utility.constants.ExceptionConstants;

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
	public List<SeasonDto> listSeasonsByTvShow(Long tvShowId) throws NetflixException {
		
		List<Season> seasons = seasonRepository.findByTvShowId(tvShowId); 
		
		if(seasons.isEmpty())
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON);
		
		return seasons.stream().map(season -> modelMapper.map(season, SeasonDto.class)).collect(Collectors.toList());
	}

	/**
	 * Find season by number and tv show.
	 * @param seasonNumber the season number
	 * @param tvShow       the tv show
	 * @return the season dto
	 */
	@Override
	public SeasonDto findSeasonByNumberAndTvShow(Long tvShowId, int seasonNumber) throws NetflixException {
		return modelMapper.map(seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON)), SeasonDto.class);
	}

}

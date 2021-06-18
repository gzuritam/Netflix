package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.TvShow;

/**
 * The Interface SeasonServiceI.
 */
public interface SeasonServiceI {
	
	/**
	 * List seasons by tv show.
	 * @param tvShow the tv show
	 * @return the list
	 */
	List<SeasonDto> listSeasonsByTvShow(Long tvShow) throws NetflixException;
	
	/**
	 * Find season by number and tv show.
	 * @param seasonNumber the season number
	 * @param tvShow the tv show
	 * @return the season dto
	 */
	SeasonDto findSeasonByNumberAndTvShow(Long tvShowId, int seasonNumber) throws NetflixException;

}

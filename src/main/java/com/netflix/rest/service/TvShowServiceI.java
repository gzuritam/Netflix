package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;

/**
 * The Interface TvShowServiceI.
 */
public interface TvShowServiceI {	
	
	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	TvShowDto findTvShowById(Long tvShowId);
	
	/**
	 * List tv show by category.
	 * @param category the category
	 * @return the list
	 */
	List<TvShowDto> listTvShowByCategory(Category category);
	
	/**
	 * Find by id.
	 * @param tvShowId the tv show id
	 * @return the tv show
	 */
	TvShow findById(Long tvShowId);
	
	/**
	 * Update tv show.
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	TvShow updateTvShow(TvShow tvShow);
	
	/**
	 * Delete by id.
	 * @param id the id
	 */
	void deleteById(Long id);
	
}

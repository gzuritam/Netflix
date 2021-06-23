package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.exception.NetflixException;

/**
 * The Interface TvShowServiceI.
 */
public interface TvShowServiceI {	
	
	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	TvShowDto findTvShowById(Long tvShowId) throws NetflixException;
	
	/**
	 * List tv show by category.
	 * @param category the category
	 * @return the list
	 */
	List<TvShowDto> listTvShowByCategory(Long categoryId) throws NetflixException;
	
	
	TvShowDto updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException;
	
	/**
	 * Adds the categories to tv show.
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv show dto
	 * @throws NetflixException the netflix exception
	 */
	TvShowDto addCategoriesToTvShow(@PathVariable Long tvShowId, @RequestParam Set<Long> listCategories) throws NetflixException;
	
	/**
	 * Delete by id.
	 * @param id the id
	 */
	void deleteById(Long id) throws NetflixException;
	
}

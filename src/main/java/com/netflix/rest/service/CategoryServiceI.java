package com.netflix.rest.service;

import java.util.List;
import java.util.Set;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Category;

/**
 * The Interface CategoryServiceI.
 */
public interface CategoryServiceI {
	
	/**
	 * List all categories.
	 * @return the list
	 */
	List<CategoryDto> listAllCategories() throws NetflixException;
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the category dto
	 */
	CategoryDto findById(Long id) throws NetflixException;
	
	/**
	 * List categories by ids.
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 */
	Set<Category> listCategoriesByIds(Set<Long> listCategoriesIds) throws NetflixException;
}

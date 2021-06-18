package com.netflix.rest.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Category;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.utility.constants.ExceptionConstants;

/**
 * The Class CategoryServiceImpl.
 */
@Service
@Qualifier("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryServiceI {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/** The category repository. */
	@Autowired
	@Qualifier("CategoryRepository")
	private CategoryRepository categoryRepository;
	
	/**
	 * Find by id.
	 * @param id the id	
	 * @return the category dto
	 */
	@Override
	public CategoryDto findById(Long id) throws NetflixException {
		return modelMapper.map(
				categoryRepository.findById(id)
					.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY)),
				CategoryDto.class);
	}
	
	/**
	 * List all categories.
	 * @return the list
	 */
	@Override
	public List<CategoryDto> listAllCategories() throws NetflixException {
		return this.categoryRepository.findAll()
				.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * List categories by ids.
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 */
	@Override
	public Set<Category> listCategoriesByIds(Set<Long> listCategoriesIds) throws NetflixException {
		return new HashSet<>(categoryRepository.findAllById(listCategoriesIds));
	}

	
}

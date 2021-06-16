package com.netflix.rest.serviceImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.service.CategoryServiceI;

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
	public CategoryDto findById(Long id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return category != null ? modelMapper.map(category, CategoryDto.class) : null;
	}
	
	/**
	 * List all categories.
	 * @return the list
	 */
	@Override
	public List<CategoryDto> listAllCategories() {
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
	public Set<Category> listCategoriesByIds(Set<Long> listCategoriesIds) {
		return new HashSet<>(categoryRepository.findAllById(listCategoriesIds));
	}

	
}

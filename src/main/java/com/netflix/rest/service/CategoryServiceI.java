package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.model.Category;

public interface CategoryServiceI {
	List<CategoryDto> listAllCategories();
	CategoryDto findById(Long id);
}

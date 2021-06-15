package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.service.CategoryServiceI;

@RestController
public class CategoryController {
	
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;
	
	
	@GetMapping("/categories/{categoryId}")
	public CategoryDto findById(@PathVariable Long categoryId) {
		return categoryService.findById(categoryId);
	}
	
	@GetMapping("/categories")
	public List<CategoryDto> listAllCategory() {
		return categoryService.listAllCategories();
	}
	
}

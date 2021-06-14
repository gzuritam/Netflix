package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.Category;
import com.netflix.rest.service.CategoryServiceI;

@RestController
public class CategoryController {
	
	@Autowired
	@Qualifier("CategoryServiceImpl")
	public CategoryServiceI categoryService;
	
	@GetMapping("/categories")
	public List<Category> listAllCategory() {
		return categoryService.listAllCategories();
	}

}

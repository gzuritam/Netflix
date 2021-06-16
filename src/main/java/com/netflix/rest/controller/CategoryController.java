package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.service.CategoryServiceI;

@RestController
public class CategoryController {
	
	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;
	
	/**
	 * Find by id.
	 * @param categoryId the category id
	 * @return the response entity
	 */
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<Object> findById(@PathVariable Long categoryId) {
		ResponseEntity<Object> response = null;
		CategoryDto dto = categoryService.findById(categoryId);
		if(dto != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(dto);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha encontrado la categoría solicitada.");
		}
		return response;
	}
	
	/**
	 * List all category.
	 * @return the list
	 */
	@GetMapping("/categories")
	public List<CategoryDto> listAllCategory() {
		return categoryService.listAllCategories();
	}
	
}

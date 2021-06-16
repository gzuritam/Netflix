/*
 * @author sinsajoTeam
 * @version 1.0
 */
package com.netflix.rest.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utility.ConstantResponse;

/**
 * The Class TvShowController.
 */
@RestController
public class TvShowController {
	
	/** The tv show service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")
	private TvShowServiceI tvShowService;
	
	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;
	
	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	@GetMapping("/tvShows/{tvShowId}")
	public TvShowDto findTvShowById(@PathVariable Long tvShowId) {
		return tvShowService.findTvShowById(tvShowId);
	}
	
	/**
	 * List tv show by category id.
	 * @param categoryId the category id
	 * @return the list
	 */
	@GetMapping("/tvShows")
	public List<TvShowDto> listTvShowByCategoryId(@RequestParam Long categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return tvShowService.listTvShowByCategory(category);
	}
	
	/**
	 * Adds the categories to tv show.
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the response entity
	 */
	@PostMapping("/tvShows/addCategories/{tvShowId}/")
	public ResponseEntity<String> addCategoriesToTvShow(@PathVariable Long tvShowId, @RequestParam Set<Long> listCategories) {
		ResponseEntity<String> response = null;
		Set<Category> categories = categoryService.listCategoriesByIds(listCategories);
		TvShow tvShow = tvShowService.findById(tvShowId);
		if(categories.size() > 0 && tvShow != null) {
			tvShow.getCategory().addAll(categories);
			tvShowService.updateTvShow(tvShow);
			
			StringBuilder builderStr = new StringBuilder();
			builderStr.append("Se ha insertado las nuevas categorías ");
			builderStr.append(categories.stream().map(cat -> cat.getId().toString()).collect(Collectors.joining(",")));
			builderStr.append(" correctamente.");
			
			response = ResponseEntity.status(HttpStatus.OK).body(builderStr.toString());
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantResponse.ERROR_ADDCATEGORIES_TO_TVSHOW);
		}

		return response; 
	}
	
	/**
	 * Update tv show name.
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the response entity
	 */
	@PostMapping("/tvShows/{tvShowId}/updateName/{tvShowName}/")
	public ResponseEntity<String> updateTvShowName(@PathVariable Long tvShowId, @PathVariable String tvShowName) {
		ResponseEntity<String> response = null;
		TvShow tvShow = tvShowService.findById(tvShowId);

		if(tvShow != null) {
			tvShow.setName(tvShowName);
			tvShowService.updateTvShow(tvShow);
			response = ResponseEntity.status(HttpStatus.OK).body(ConstantResponse.OK_UPDATE_TVSHOW_BY_NAME);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantResponse.ERROR_TVSHOW_NOT_EXIST_BY_ID);
		}
		
		return response;
	}
	
	
	/**
	 * Delete tv show by id.
	 * @param tvShowId the tv show id
	 * @return the response entity
	 */
	@PostMapping("/tvShows/deleteBy/{tvShowId}")
	public ResponseEntity<String> deleteTvShowById(@PathVariable Long tvShowId) {
		ResponseEntity<String> response = null;

		if(tvShowService.findById(tvShowId) != null) {
			tvShowService.deleteById(tvShowId);
			response = ResponseEntity.status(HttpStatus.OK).body(ConstantResponse.OK_DELETE_TVSHOW);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantResponse.ERROR_TVSHOW_NOT_EXIST_BY_ID);
		}
		 
		 return response;
	}
	

}

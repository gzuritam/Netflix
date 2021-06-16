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

// TODO: Auto-generated Javadoc
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
		Set<Category> categories = categoryService.listCategoriesByIds(listCategories);
		TvShow tvShow = tvShowService.findById(tvShowId);
		tvShow.getCategory().addAll(categories);
		tvShowService.updateTvShow(tvShow);
		return ResponseEntity.status(HttpStatus.OK)
							 .body("Se ha insertado las nuevas categorías " + categories.stream().map(cat -> cat.getId().toString()).collect(Collectors.joining(",")) + " correctamente");
	}
	
	/**
	 * Update tv show name.
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the response entity
	 */
	@PostMapping("/tvShows/{tvShowId}/updateName/{tvShowName}/")
	public ResponseEntity<String> updateTvShowName(@PathVariable Long tvShowId, @PathVariable String tvShowName) {
		TvShow tvShow = tvShowService.findById(tvShowId);
		tvShow.setName(tvShowName);
		tvShowService.updateTvShow(tvShow);
		return ResponseEntity.status(HttpStatus.OK)
				 .body("Se ha actualizado el nombre correctamente.");
	}
	
	
	/**
	 * Delete tv show by id.
	 * @param tvShowId the tv show id
	 * @return the response entity
	 */
	@PostMapping("/tvShows/deleteBy/{tvShowId}")
	public ResponseEntity<String> deleteTvShowById(@PathVariable Long tvShowId) {
		tvShowService.deleteById(tvShowId);
		return ResponseEntity.status(HttpStatus.OK)
				 .body("Se ha eliminado correctamente.");
	}
	

}

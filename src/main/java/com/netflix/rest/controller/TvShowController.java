package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.TvShowServiceI;

@RestController
public class TvShowController {
	
	@Autowired
	@Qualifier("TvShowServiceImpl")
	private TvShowServiceI tvShowService;
	
	@GetMapping("/tvShows/{tvShowId}")
	public TvShowDto findTvShowById(@PathVariable Long tvShowId) {
		TvShow tvShow = new TvShow();
		tvShow.setId(tvShowId);
		return tvShowService.findTvShowById(tvShow);
	}
	
	@GetMapping("/tvShows")
	public List<TvShowDto> listTvShowByCategoryId(@RequestParam Long categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return tvShowService.listTvShowByCategory(category);
	}

}

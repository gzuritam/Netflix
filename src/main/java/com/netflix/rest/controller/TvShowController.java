package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.TvShowServiceI;

@RestController
public class TvShowController {
	
	@Autowired
	@Qualifier("TvShowServiceImpl")
	public TvShowServiceI tvShowService;
	
	@GetMapping("/listTvShow/{categoryId}")
	public List<TvShow> listTvShowByCategoryId(@PathVariable Long categoryId) {
		return tvShowService.listTvShowByCategory(categoryId);
	}

}

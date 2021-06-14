package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;

public interface TvShowServiceI {
	
	List<TvShow> listTvShowByCategory(Long category);
	
}

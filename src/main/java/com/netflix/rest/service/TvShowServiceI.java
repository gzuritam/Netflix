package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;

public interface TvShowServiceI {	
	
	TvShowDto findTvShowById(TvShow tvShow);
	List<TvShowDto> listTvShowByCategory(Category category);
	
}

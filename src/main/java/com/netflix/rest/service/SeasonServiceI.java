package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.model.TvShow;

public interface SeasonServiceI {
	
	List<SeasonDto> listSeasonsByTvShow(TvShow tvShow);
	SeasonDto findSeasonByNumberAndTvShow(int seasonNumber, TvShow tvShow);

}

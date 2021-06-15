package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;

public interface ChapterServiceI {

	List<ChapterDto> listByTvShowAndSeasonNumber(long tvShowId, int seasonNumber);
	ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber);
	
}

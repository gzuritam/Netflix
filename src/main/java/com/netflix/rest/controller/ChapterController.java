package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.ChapterServiceI;

@RestController
public class ChapterController {

	@Autowired
	@Qualifier("ChapterServiceImpl")
	private ChapterServiceI chapterService;

	@GetMapping("/tvShow/{tvShowId}/seasons/{seasonNumber}/chapters")
	public List<ChapterDto> listByTvShowAndSeasonNumber(@PathVariable Long tvShowId, @PathVariable int seasonNumber) {
		return chapterService.listByTvShowAndSeasonNumber(tvShowId, seasonNumber);
	}

	@GetMapping("/tvShow/{tvShowId}/seasons/{seasonNumber}/chapters/{chapterNumber}")
	public ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(@PathVariable Long tvShowId,
			@PathVariable int seasonNumber, @PathVariable int chapterNumber) {
		return chapterService.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber, chapterNumber);
	}

}

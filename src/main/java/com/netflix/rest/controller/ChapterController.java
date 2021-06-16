package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.utility.ConstantResponse;

/**
 * The Class ChapterController.
 */
@RestController
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChapterServiceImpl")
	private ChapterServiceI chapterService;

	/**
	 * List by tv show and season number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@GetMapping("/tvShow/{tvShowId}/seasons/{seasonNumber}/chapters")
	public List<ChapterDto> listByTvShowAndSeasonNumber(@PathVariable Long tvShowId, @PathVariable int seasonNumber) {
		return chapterService.listByTvShowAndSeasonNumber(tvShowId, seasonNumber);
	}

	/**
	 * Gets the chapter by tv show and season number and chapter number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the response entity
	 */
	@GetMapping("/tvShow/{tvShowId}/seasons/{seasonNumber}/chapters/{chapterNumber}")
	public ResponseEntity<Object> getChapterByTvShowAndSeasonNumberAndChapterNumber(@PathVariable Long tvShowId,
			@PathVariable int seasonNumber, @PathVariable int chapterNumber) {
		ResponseEntity<Object> response = null;

		ChapterDto chapter = chapterService.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber, chapterNumber);
		
		if(chapter != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(chapter);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantResponse.RESULT_NOT_FOUND);
		}
		return response;
	}
	
	/**
	 * Update tv show name.
	 * @param chapterId the chapter id
	 * @param chapterName the chapter name
	 * @return the response entity
	 */
	@PostMapping("/chapters/{chapterId}/updateName/{chapterName}/")
	public ResponseEntity<String> updateTvShowName(@PathVariable Long chapterId, @PathVariable String chapterName) {
		ResponseEntity<String> response = null;
		Chapter chapter = chapterService.findById(chapterId);

		if(chapter != null) {
			chapter.setName(chapterName);
			chapterService.updateChapter(chapter);
			response = ResponseEntity.status(HttpStatus.OK).body(ConstantResponse.OK_UPDATE_CHAPTER_BY_NAME);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstantResponse.ERROR_CHAPTER_NOT_EXISTS);
		}
		return response;
	}

}
    
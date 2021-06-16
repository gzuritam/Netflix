package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.Chapter;

/**
 * The Interface ChapterServiceI.
 */
public interface ChapterServiceI {

	/**
	 * List by tv show and season number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	List<ChapterDto> listByTvShowAndSeasonNumber(long tvShowId, int seasonNumber);
	
	/**
	 * Gets the chapter by tv show and season number and chapter number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter by tv show and season number and chapter number
	 */
	ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber);
	
	/**
	 * Update chapter.
	 * @param chapter the chapter
	 * @return the chapter
	 */
	Chapter updateChapter(Chapter chapter);
	
	/**
	 * Find by id.
	 * @param chapterId the chapter id
	 * @return the chapter
	 */
	Chapter findById(Long chapterId);
	
}

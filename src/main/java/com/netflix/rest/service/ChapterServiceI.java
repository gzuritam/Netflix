package com.netflix.rest.service;

import java.util.List;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.model.Chapter;

// TODO: Auto-generated Javadoc
/**
 * The Interface ChapterServiceI.
 */
public interface ChapterServiceI {

	/**
	 * List by tv show and season number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ChapterDto> listByTvShowAndSeasonNumber(Long tvShowId, int seasonNumber) throws NetflixException;
	

	/**
	 * Gets the chapter by tv show and season number and chapter number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter by tv show and season number and chapter number
	 * @throws NetflixException the netflix exception
	 */
	ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(Long tvShowId, int seasonNumber, int chapterNumber) throws NetflixException ;
	

	/**
	 * Update chapter name.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @param chapterName the chapter name
	 * @return the chapter dto
	 * @throws NetflixException the netflix exception
	 */
	ChapterDto updateChapterName(Long tvShowId, int seasonNumber, int chapterNumber, String chapterName) throws NetflixException;
	
	
}

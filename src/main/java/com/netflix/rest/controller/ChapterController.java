package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.utility.constants.CommonConstants;
import com.netflix.rest.utility.constants.RestConstants;

import io.swagger.annotations.ApiOperation;

/**
 * The Class ChapterController.
 */
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION + RestConstants.RESOURCE_CHAPTER)
public class ChapterController {

	/** The chapter service. */
	@Autowired
	@Qualifier("ChapterServiceImpl")
	private ChapterServiceI chapterService;


	/**
	 * List by tv show and season number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listar capítulos", notes = "Devuelve una lista de capítulos según la serie y el número de temporada facilitado.")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<ChapterDto>> listByTvShowAndSeasonNumber(@PathVariable Long tvShowId, @PathVariable int seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.listByTvShowAndSeasonNumber(tvShowId, seasonNumber));
	}

	/**
	 * Gets the chapter by tv show and season number and chapter number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the response entity
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Lista un capítulo", notes = "Devuelve una lista de capítulos según la serie,el número de temporada y el número del capítulo facilitado.")
	@GetMapping(value = RestConstants.RESOURCE_NUMBER, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ChapterDto> getChapterByTvShowAndSeasonNumberAndChapterNumber(@PathVariable Long tvShowId,
			@PathVariable int seasonNumber, @PathVariable(value = "number") int chapterNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber,
						chapterNumber));
	}
	
	
	
	/**
	 * Update tv show name.
	 * @param tvShowId the tv show id
	 * @param chapterId the chapter id
	 * @param seasonNumber the season number
	 * @param chapterName the chapter name
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizar nombre del capítulo", notes = "Devuelve la información del capítulo actualizado")
	@PatchMapping(value = RestConstants.RESOURCE_CHAPTER_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ChapterDto> updateTvShowName(@PathVariable Long tvShowId , @PathVariable int seasonNumber, 
			@PathVariable int chapterNumber, @PathVariable String chapterName) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.updateChapterName(tvShowId, seasonNumber, chapterNumber, chapterName));
	}

}
    
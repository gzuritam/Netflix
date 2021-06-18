/*
 * @author sinsajoTeam
 * @version 1.0
 */
package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.service.SeasonServiceI;
import com.netflix.rest.utility.constants.CommonConstants;
import com.netflix.rest.utility.constants.RestConstants;

import io.swagger.annotations.ApiOperation;

/**
 * The Class SeasonController.
 */
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION + RestConstants.RESOURCE_SEASON)
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonServiceImpl")
	private SeasonServiceI seasonService;
	
	/**
	 * Find season by id and tv show.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return response entity
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Lista una temporada", notes = "Devuelve una temporada filtrando por id de la serie y el número de la temporada.")
	@GetMapping(value = RestConstants.RESOURCE_NUMBER, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<SeasonDto> findSeasonByIdAndTvShow(@PathVariable Long tvShowId, @PathVariable(value = "number") int seasonNumber) 
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.findSeasonByNumberAndTvShow(tvShowId, seasonNumber));
	}
	
	/**
	 * List seasons.
	 * @param tvShowId the tv show id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listar temporadas", notes = "Devuelve una lista de temporadas filtrando por el id de la serie.")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<SeasonDto>> listSeasons(@PathVariable Long tvShowId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				seasonService.listSeasonsByTvShow(tvShowId));
	}
	
}

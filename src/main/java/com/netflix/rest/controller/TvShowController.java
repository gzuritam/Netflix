package com.netflix.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utility.constants.CommonConstants;
import com.netflix.rest.utility.constants.RestConstants;

import io.swagger.annotations.ApiOperation;

/**
 * The Class TvShowController.
 */
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION + RestConstants.RESOURCE_TV_SHOW)
public class TvShowController {
	
	/** The tv show service. */
	@Autowired
	@Qualifier("TvShowServiceImpl")
	private TvShowServiceI tvShowService;
	
	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	@ApiOperation(value = "Lista una serie", notes = "Devuelve información de la serie filtrando por su id.")
	@GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<TvShowDto> findTvShowById(@PathVariable Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.findTvShowById(id));
	}
	
	/**
	 * List tv show by category id.
	 * @param categoryId the category id
	 * @return the list
	 */
	@ApiOperation(value = "Listar series", notes = "Devuelve una lista de series filtrando por el id de una categoría.")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<TvShowDto>> listTvShowByCategoryId(@RequestParam Long categoryId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.listTvShowByCategory(categoryId));
	}
	

	/**
	 * Adds the categories to tv show.
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the netflix response
	 */
	@ApiOperation(value = "Añadir categorías", notes = "Añade nuevas categorías a una serie existente.")
	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_ADD_CATEGORIES, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<TvShowDto> addCategoriesToTvShow(@PathVariable Long tvShowId, @RequestParam Set<Long> listCategories) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.addCategoriesToTvShow(tvShowId, listCategories));
	}
	
	/**
	 * Update tv show name.
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 */
	@ApiOperation(value = "Actualizar nombre", notes = "Actualiza el nombre de la serie existente por id.")
	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<TvShowDto> updateTvShowName(@PathVariable Long tvShowId, @PathVariable String tvShowName) throws NetflixException  {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.updateTvShowName(tvShowId, tvShowName));
	}	
	
	
	/**
	 * Delete tv show by id.
	 * @param tvShowId the tv show id
	 * @return the response entity
	 */
	@ApiOperation(value = "Eliminar serie", notes = "Elimina la serie indicando su id.")
	@DeleteMapping(value = RestConstants.RESOURCE_ID)
	public NetflixResponse<String> deleteTvShowById(@PathVariable Long id) throws NetflixException {
		tvShowService.deleteById(id);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}
	

}

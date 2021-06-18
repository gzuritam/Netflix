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

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.response.NetflixResponse;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.utility.constants.CommonConstants;
import com.netflix.rest.utility.constants.RestConstants;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION + RestConstants.RESOURCE_CATEGORY)
public class CategoryController {
	
	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;
	
	/**
	 * Find by id.
	 * @param categoryId the category id
	 * @return the netflix response
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Devuelve una categoría", notes = "Devuelve la categoría por id introducido por parámetros.",
			nickname = "Búsqueda de la categoría por ID")
	@GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<CategoryDto> findById(@PathVariable Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				categoryService.findById(id));
	}
	
	/**
	 * List all category.
	 * @return the list
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listar categorías", notes = "Lista todas las categorías existentes en el sistema",
			nickname = "listAllCategory")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<CategoryDto>> listAllCategory() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				categoryService.listAllCategories());
	}
	
}

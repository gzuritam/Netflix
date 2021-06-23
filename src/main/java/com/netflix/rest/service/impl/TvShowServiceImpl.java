package com.netflix.rest.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;
import com.netflix.rest.utility.constants.ExceptionConstants;

/**
 * The Class TvShowServiceImpl.
 */
@Service
@Qualifier("TvShowServiceImpl")
public class TvShowServiceImpl implements TvShowServiceI {

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The tv show repository. */
	@Autowired
	@Qualifier("TvShowRepository")
	private TvShowRepository tvShowRepository;
	
	/** The category service. */
	@Autowired
	@Qualifier("CategoryServiceImpl")
	private CategoryServiceI categoryService;

	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	@Override
	public TvShowDto findTvShowById(Long tvShowId) throws NetflixException {
		return modelMapper.map(tvShowRepository
				.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW)), TvShowDto.class);
	}

	/**
	 * List tv show by category.
	 * @param category the category
	 * @return the list
	 * @throws NetflixException 
	 */
	@Override
	public List<TvShowDto> listTvShowByCategory(Long categoryId) throws NetflixException {
		
		List<TvShow> tvShows = tvShowRepository.findByCategoryId(categoryId);
		if(tvShows.isEmpty())
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW);
		
		return tvShows.stream().map(tvShow -> modelMapper.map(tvShow, TvShowDto.class)).collect(Collectors.toList());
	}

	@Override
	public TvShowDto updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException {
		
		TvShow tvShow = tvShowRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		tvShow.setName(tvShowName);
		tvShowRepository.save(tvShow);

		return modelMapper.map(tvShow, TvShowDto.class);
	}

	/**
	 * Delete by id.
	 * @param id the id
	 */
	@Override
	public void deleteById(Long id) throws NetflixException {
		tvShowRepository.deleteById(tvShowRepository.findById(id)
													.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW))
													.getId());
	}

	/**
	 * Adds the categories to tv show.
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv show dto
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowDto addCategoriesToTvShow(Long tvShowId, Set<Long> listCategories) throws NetflixException {
		
		Set<Category> categories = categoryService.listCategoriesByIds(listCategories);
		
		if(categories.isEmpty())
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY);
		
		TvShow tvShow = tvShowRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW));
		
		if(categories.size() > 0) {
			tvShow.getCategory().addAll(categories);
			tvShowRepository.save(tvShow);
		}
		
		return modelMapper.map(tvShow, TvShowDto.class);
	}
}

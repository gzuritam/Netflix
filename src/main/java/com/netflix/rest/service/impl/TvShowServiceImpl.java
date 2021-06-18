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
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.CategoryServiceI;
import com.netflix.rest.service.TvShowServiceI;

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
		return modelMapper.map(tvShowRepository.findById(tvShowId).orElseThrow(), TvShowDto.class);
	}

	/**
	 * List tv show by category.
	 * @param category the category
	 * @return the list
	 */
	@Override
	public List<TvShowDto> listTvShowByCategory(Long categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return tvShowRepository.findByCategory(category)
				.stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TvShowDto updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException {
		
		TvShow tvShow = tvShowRepository.findById(tvShowId).orElseThrow();
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
		tvShowRepository.deleteById(tvShowRepository.findById(id).orElseThrow().getId());
	}

	/**
	 * Adds the categories to tv show.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv show dto
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowDto addCategoriesToTvShow(Long tvShowId, Set<Long> listCategories) throws NetflixException {
		
		Set<Category> categories = categoryService.listCategoriesByIds(listCategories);
		TvShow tvShow = tvShowRepository.findById(tvShowId).orElseThrow();
		
		if(categories.size() > 0) {
			tvShow.getCategory().addAll(categories);
			tvShowRepository.save(tvShow);
		}
		
		return modelMapper.map(tvShow, TvShowDto.class);
	}
}

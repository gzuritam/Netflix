package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.TvShowDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.TvShowRepository;
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

	/**
	 * Find tv show by id.
	 * @param tvShowId the tv show id
	 * @return the tv show dto
	 */
	@Override
	public TvShowDto findTvShowById(Long tvShowId) {
		TvShow tvShow = findById(tvShowId);
		return tvShow != null ? modelMapper.map(tvShow, TvShowDto.class) : null;
	}

	/**
	 * List tv show by category.
	 * @param category the category
	 * @return the list
	 */
	@Override
	public List<TvShowDto> listTvShowByCategory(Category category) {
		return tvShowRepository.findByCategory(category)
				.stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 * @param tvShowId the tv show id
	 * @return the tv show
	 */
	@Override
	public TvShow findById(Long tvShowId) {
		return tvShowRepository.findById(tvShowId).orElse(null);
	}

	/**
	 * Update tv show.
	 * @param tvShow the tv show
	 * @return the tv show
	 */
	@Override
	public TvShow updateTvShow(TvShow tvShow) {
		return tvShowRepository.save(tvShow);
	}

	/**
	 * Delete by id.
	 * @param id the id
	 */
	@Override
	public void deleteById(Long id) {
		tvShowRepository.deleteById(id);
	}
}

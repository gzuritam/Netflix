package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;

/**
 * The Interface SeasonRepository.
 */
@Repository
@Qualifier("SeasonRepository")
public interface SeasonRepository extends JpaRepository<Season, Long> {

	/**
	 * Find by tv show.
	 * @param tvShow the tv show
	 * @return the list
	 */
	List<Season> findByTvShowId(Long tvShowId);
	
	/**
	 * Find by number and tv show.
	 * @param seasonNumber the season number
	 * @param tvShow the tv show
	 * @return the season
	 */
	Season findByTvShowIdAndNumber(Long tvShowId, int seasonNumber);
	
}

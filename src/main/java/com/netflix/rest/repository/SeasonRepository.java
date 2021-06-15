package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;

@Repository
@Qualifier("SeasonRepository")
public interface SeasonRepository extends JpaRepository<Season, Long> {

	List<Season> findByTvShow(TvShow tvShow);
	Season findByNumberAndTvShow(int seasonNumber, TvShow tvShow);
	
}

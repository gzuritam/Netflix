package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Category;
import com.netflix.rest.model.TvShow;

@Repository
@Qualifier("TvShowRepository")
public interface TvShowRepository extends JpaRepository<TvShow, Long> {


	/**
	 * Find by category id.
	 * @param categoryId the category id
	 * @return the list
	 */
	List<TvShow> findByCategoryId(Long categoryId);
	
}

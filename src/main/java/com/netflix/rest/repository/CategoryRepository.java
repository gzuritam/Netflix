package com.netflix.rest.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Category;

/**
 * The Interface CategoryRepository.
 */
@Repository
@Qualifier("CategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}

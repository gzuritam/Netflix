package com.netflix.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflix.rest.model.Chapter;

@Repository
@Qualifier("ChapterRepository")
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
	
	@Query(value = "SELECT c.* FROM CHAPTERS c "
			+ " LEFT JOIN SEASONS s ON c.season_id = s.id "
			+ " LEFT JOIN TV_SHOWS t ON s.tv_show_id = t.id "
			+ " WHERE t.id = ?1 and s.number = ?2 ", nativeQuery = true)
	List<Chapter> listByTvShowAndSeasonNumber(long tvShowId, int seasonNumber);
	
	@Query(value = "SELECT c.* FROM CHAPTERS c "
			+ " LEFT JOIN SEASONS s ON c.season_id = s.id "
			+ " LEFT JOIN TV_SHOWS t ON s.tv_show_id = t.id "
			+ " WHERE t.id = ?1 and s.number = ?2 "
			+ " and c.number = ?3 ", nativeQuery = true)
	Chapter getChapterByTvShowAndSeasonNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber);

}

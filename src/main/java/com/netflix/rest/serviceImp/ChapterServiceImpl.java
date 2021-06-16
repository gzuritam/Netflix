package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.ChapterRepository;
import com.netflix.rest.service.ChapterServiceI;

/**
 * The Class ChapterServiceImpl.
 */
@Service
@Qualifier("ChapterServiceImpl")
public class ChapterServiceImpl implements ChapterServiceI {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The chapter repository. */
	@Autowired
	@Qualifier("ChapterRepository")
	private ChapterRepository chapterRepository;

	/**
	 * List by tv show and season number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<ChapterDto> listByTvShowAndSeasonNumber(long tvShowId, int seasonNumber) {
		
		return chapterRepository.listByTvShowAndSeasonNumber(tvShowId, seasonNumber)
				.stream()
				.map(chapter -> modelMapper.map(chapter, ChapterDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * Gets the chapter by tv show and season number and chapter number.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapter by tv show and season number and chapter number
	 */
	@Override
	public ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber) {
		Chapter chapter = chapterRepository.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber, chapterNumber);
		return chapter != null ? modelMapper.map(chapter, ChapterDto.class) : null;
	}

	/**
	 * Update chapter.
	 * @param chapter the chapter
	 * @return the chapter
	 */
	@Override
	public Chapter updateChapter(Chapter chapter) {
		return chapterRepository.save(chapter);
	}

	/**
	 * Find by id.
	 * @param chapterId the chapter id
	 * @return the chapter
	 */
	@Override
	public Chapter findById(Long chapterId) {
		return chapterRepository.findById(chapterId).orElse(null);
	}
	
	

	
}

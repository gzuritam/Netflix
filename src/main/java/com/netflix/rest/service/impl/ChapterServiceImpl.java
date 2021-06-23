package com.netflix.rest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.exception.NotFoundException;
import com.netflix.rest.model.Chapter;
import com.netflix.rest.repository.ChapterRepository;
import com.netflix.rest.service.ChapterServiceI;
import com.netflix.rest.utility.constants.ExceptionConstants;

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
	public List<ChapterDto> listByTvShowAndSeasonNumber(Long tvShowId, int seasonNumber) throws NetflixException {
		
		List<Chapter> chapters = chapterRepository.findBySeasonTvShowIdAndSeasonNumber(tvShowId, seasonNumber);
		
		if(chapters.isEmpty())
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER);
		
		return chapters
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
	public ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(Long tvShowId, int seasonNumber,
			int chapterNumber) throws NetflixException {
		Chapter chapter = chapterRepository.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber,
				chapterNumber).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		return modelMapper.map(chapter, ChapterDto.class);
	}

	/**
	 * Update chapter.
	 * @param chapter the chapter
	 * @return the chapter
	 */
	@Override
	public ChapterDto updateChapterName(Long tvShowId, int seasonNumber, int chapterNumber, String chapterName)
			throws NetflixException {
		Chapter chapter = chapterRepository.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber,
				chapterNumber).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		chapter.setName(chapterName);
		chapterRepository.save(chapter);
		return modelMapper.map(chapter, ChapterDto.class);
	}
	
}

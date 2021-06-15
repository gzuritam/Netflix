package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.netflix.rest.dto.ChapterDto;
import com.netflix.rest.model.Season;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.ChapterRepository;
import com.netflix.rest.service.ChapterServiceI;

@Service
@Qualifier("ChapterServiceImpl")
public class ChapterServiceImpl implements ChapterServiceI {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	@Qualifier("ChapterRepository")
	private ChapterRepository chapterRepository;

	@Override
	public List<ChapterDto> listByTvShowAndSeasonNumber(long tvShowId, int seasonNumber) {
		
		return chapterRepository.listByTvShowAndSeasonNumber(tvShowId, seasonNumber)
				.stream()
				.map(chapter -> modelMapper.map(chapter, ChapterDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ChapterDto getChapterByTvShowAndSeasonNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber) {
		return modelMapper.map(chapterRepository
				.getChapterByTvShowAndSeasonNumberAndChapterNumber(tvShowId, seasonNumber, chapterNumber), ChapterDto.class);
	}

	
}

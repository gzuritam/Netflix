package com.netflix.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.rest.dto.SeasonDto;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.service.SeasonServiceI;

/**
 * The Class SeasonController.
 */
@RestController
public class SeasonController {

	/** The season service. */
	@Autowired
	@Qualifier("SeasonServiceImpl")
	private SeasonServiceI seasonService;
	
	/**
	 * Find season by id and tv show.
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the season dto
	 */
	@GetMapping("/tvShow/{tvShowId}/seasons/{seasonNumber}")
	public SeasonDto findSeasonByIdAndTvShow(@PathVariable Long tvShowId, @PathVariable int seasonNumber) {
		TvShow tvShow = new TvShow();
		tvShow.setId(tvShowId);
		return seasonService.findSeasonByNumberAndTvShow(seasonNumber, tvShow);
	}
	
	/**
	 * List tv show by category id.
	 * @param tvShowId the tv show id
	 * @return the list
	 */
	@GetMapping("/tvShow/{tvShowId}/seasons)")
	public List<SeasonDto> listTvShowByCategoryId(@PathVariable Long tvShowId) {
		TvShow tvShow = new TvShow();
		tvShow.setId(tvShowId);
		return seasonService.listSeasonsByTvShow(tvShow);
	}
	
}

package com.netflix.rest.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * The Class TvShowDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TvShowDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4339834357820718653L;
	
	
	/** The id. */
	@JsonProperty(value = "id")
	private Long id;
	
	/** The name. */
	@JsonProperty(value = "name")
	private String name;
	
	/** The short description. */
	@JsonProperty(value = "shortDescription")
	private String shortDescription;
	
	/** The long description. */
	@JsonProperty(value = "longDescription")
	private String longDescription;
	
	/** The year. */
	@JsonProperty(value = "year")
	private int year;
	
	/** The recommended age. */
	@JsonProperty(value = "recommendedAge")
	private int recommendedAge;
	
	/** The advertising. */
	@JsonProperty(value = "advertising")
	private String advertising;
	
}

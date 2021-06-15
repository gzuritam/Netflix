package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TvShowDto implements Serializable {
	
	private static final long serialVersionUID = 4339834357820718653L;
	
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "shortDescription")
	private String shortDescription;
	@JsonProperty(value = "longDescription")
	private String longDescription;
	@JsonProperty(value = "year")
	private int year;
	@JsonProperty(value = "recommendedAge")
	private int recommendedAge;
	@JsonProperty(value = "advertising")
	private String advertising;
}

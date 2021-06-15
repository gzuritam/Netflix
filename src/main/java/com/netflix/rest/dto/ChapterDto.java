package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ChapterDto implements Serializable {
	
	private static final long serialVersionUID = 8713995660036959123L;
	
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "number")
	private int number;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "duration")
	private int duration;

}
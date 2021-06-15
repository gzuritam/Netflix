package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SeasonDto implements Serializable {
	
	private static final long serialVersionUID = -7129927002235038124L;
	
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "number")
	private String number;
	@JsonProperty(value = "name")
	private String name;

}

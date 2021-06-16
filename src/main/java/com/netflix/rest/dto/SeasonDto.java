package com.netflix.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SeasonDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SeasonDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7129927002235038124L;
	
	/** The id. */
	@JsonProperty(value = "id")
	private Long id;
	
	/** The number. */
	@JsonProperty(value = "number")
	private String number;
	
	/** The name. */
	@JsonProperty(value = "name")
	private String name;

}

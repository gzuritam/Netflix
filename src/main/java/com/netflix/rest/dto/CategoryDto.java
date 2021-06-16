package com.netflix.rest.dto;

import java.io.Serializable;
import java.util.List;
import org.mapstruct.Mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.rest.model.TvShow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class CategoryDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CategoryDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3516047277811128655L;
	
	/** The id. */
	@JsonProperty(value = "id")
	private Long id;
	
	/** The name. */
	@JsonProperty(value = "name")
	private String name;
	
}

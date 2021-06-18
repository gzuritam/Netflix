package com.netflix.rest.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetflixResponse<T> implements Serializable {

	private String status;
	private String code;
	private String message;
	private T data;

	private static final long serialVersionUID = 7302319210373510173L;
	
	public NetflixResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

}

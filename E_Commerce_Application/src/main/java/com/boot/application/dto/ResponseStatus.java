package com.boot.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseStatus<T> {
	
	private int statusCode;
	private T t;
	public ResponseStatus(int statusCode, T t) {
		super();
		this.statusCode = statusCode;
		this.t = t;
	}
	
	
}

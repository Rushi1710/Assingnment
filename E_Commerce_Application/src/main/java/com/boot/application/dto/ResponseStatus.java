package com.boot.application.dto;

public class ResponseStatus<T> {
	
	private int statusCode;
	private T t;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public ResponseStatus() {
		super();

	}
	public ResponseStatus(int statusCode, T t) {
		super();
		this.statusCode = statusCode;
		this.t = t;
	}
	@Override
	public String toString() {
		return "ResponseStatus [statusCode=" + statusCode + ", t=" + t + "]";
	}
	
	
	
	
	
	
}

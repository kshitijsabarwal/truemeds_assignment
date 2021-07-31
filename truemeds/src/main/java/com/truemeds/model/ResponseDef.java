package com.truemeds.model;

import org.springframework.http.HttpStatus;

public class ResponseDef {

	String message;
	
	HttpStatus statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

}

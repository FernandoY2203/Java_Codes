package br.com.yuji.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private String message;
	private String detail;
	
	public ExceptionResponse(Instant timestamp, String message, String detail) {
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetail() {
		return detail;
	}
}

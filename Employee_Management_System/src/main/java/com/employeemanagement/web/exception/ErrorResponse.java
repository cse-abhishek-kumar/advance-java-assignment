package com.employeemanagement.web.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private LocalDateTime localDateTime;
	private int status;
	private String message;
	private String path;
	public ErrorResponse(LocalDateTime localDateTime, int status, String message, String path) {
		super();
		this.localDateTime = localDateTime;
		this.status = status;
		this.message = message;
		this.path = path;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getPath() {
		return path;
	}
	
}

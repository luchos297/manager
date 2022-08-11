package com.astropay.exceptions;

public class ManagerServiceException extends RuntimeException {

	private static final long serialVersionUID = -8877636034846319912L;

	public ManagerServiceException(String message) {
		super(message);
	}
	
	public ManagerServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}

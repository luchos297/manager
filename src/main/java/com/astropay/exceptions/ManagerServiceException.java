package com.astropay.exceptions;

/**
 * Manejador de Excepción de Manager
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public class ManagerServiceException extends RuntimeException {

	private static final long serialVersionUID = -8877636034846319912L;

	public ManagerServiceException(String message) {
		super(message);
	}
	
	public ManagerServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}

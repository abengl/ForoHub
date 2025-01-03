package com.alessandragodoy.forohub.exception;

/**
 * Exception thrown when an invalid value is encountered.
 */
public class InvalidValueException extends RuntimeException {
	public InvalidValueException(String message) {
		super(message);
	}
}

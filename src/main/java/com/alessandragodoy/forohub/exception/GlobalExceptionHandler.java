package com.alessandragodoy.forohub.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "Duplicated data.");
		errorResponse.put("details", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		var errors = e.getFieldErrors().stream().map(ErrorValidation::new).toList();
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGeneralException(Exception e) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "An unexpected error occurred.");
		errorResponse.put("details", e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	private record ErrorValidation(String field, String error) {
		public ErrorValidation(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}

}

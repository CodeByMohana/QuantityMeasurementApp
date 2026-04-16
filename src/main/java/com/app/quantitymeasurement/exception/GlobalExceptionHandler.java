package com.app.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for all controllers. Converts exceptions into clean
 * JSON responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	// ---------------------------
	// HANDLE ILLEGAL ARGUMENT
	// ---------------------------
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	// ---------------------------
	// HANDLE ARITHMETIC (DIVIDE BY ZERO)
	// ---------------------------
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, Object>> handleArithmetic(ArithmeticException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	// ---------------------------
	// HANDLE UNSUPPORTED OPERATIONS (TEMPERATURE CASE)
	// ---------------------------
	@ExceptionHandler(UnsupportedOperationException.class)
	public ResponseEntity<Map<String, Object>> handleUnsupported(UnsupportedOperationException ex) {

		return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	// ---------------------------
	// HANDLE METHOD ARGUMENT NOT VALID
	// ---------------------------
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(org.springframework.web.bind.MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.findFirst()
				.orElse("Validation failed");
		return buildResponse(HttpStatus.BAD_REQUEST, errorMessage);
	}

	// ---------------------------
	// HANDLE GENERIC EXCEPTION
	// ---------------------------
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {

		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
	}

	// ---------------------------
	// COMMON RESPONSE BUILDER
	// ---------------------------
	private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {

		Map<String, Object> body = new HashMap<>();

		body.put("timestamp", LocalDateTime.now());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", message);

		return new ResponseEntity<>(body, status);
	}
}
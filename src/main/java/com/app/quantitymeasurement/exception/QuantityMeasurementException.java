package com.app.quantitymeasurement.exception;

/**
 * Custom exception for quantity measurement operations.
 */
public class QuantityMeasurementException extends RuntimeException {

	public QuantityMeasurementException(String message) {
		super(message);
	}

	public QuantityMeasurementException(String message, Throwable cause) {
		super(message, cause);
	}
}
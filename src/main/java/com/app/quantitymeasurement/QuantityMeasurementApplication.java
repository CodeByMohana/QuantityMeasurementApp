package com.app.quantitymeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantityMeasurementApplication {

	/**
	 * Main entry point for Spring Boot application.
	 *
	 * Replaces: - Old QuantityMeasurementApp (UC15/UC16) - Manual initialization of
	 * controller/service/repository
	 *
	 * Spring Boot will now: - Auto-configure beans - Handle dependency injection -
	 * Start embedded server (Tomcat)
	 */
	
	
	public static void main(String[] args) {
		SpringApplication.run(QuantityMeasurementApplication.class, args);
	}

}

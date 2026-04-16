package com.app.quantitymeasurement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity representing a quantity measurement operation.
 *
 * This maps directly to the database table using JPA. Lombok removes
 * boilerplate (getters/setters/constructors).
 */
@Entity
@Table(name = "quantity_measurements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityMeasurementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	// Operation: ADD, SUBTRACT, DIVIDE, COMPARE, CONVERT
	@Column(name = "operation_type", nullable = false)
	private String operationType;

	// Measurement category: LENGTH, WEIGHT, VOLUME, TEMPERATURE
	@Column(name = "measurement_type", nullable = false)
	private String measurementType;

	// Operand 1
	@Column(name = "operand1_value")
	private Double operand1Value;

	@Column(name = "operand1_unit")
	private String operand1Unit;

	// Operand 2 (optional for convert/compare)
	@Column(name = "operand2_value")
	private Double operand2Value;

	@Column(name = "operand2_unit")
	private String operand2Unit;

	// Result
	@Column(name = "result_value")
	private Double resultValue;

	@Column(name = "result_unit")
	private String resultUnit;

	// Timestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	/**
	 * Automatically set timestamp before saving.
	 */
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
}
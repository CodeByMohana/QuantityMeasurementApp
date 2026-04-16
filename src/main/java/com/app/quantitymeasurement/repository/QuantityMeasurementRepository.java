package com.app.quantitymeasurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.List;

/**
 * Spring Data JPA Repository
 *
 * Replaces: - JDBC code - ConnectionPool - PreparedStatement - Manual SQL
 * queries
 */
@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {

	// 🔍 Find by operation type (ADD, SUBTRACT, etc.)
	List<QuantityMeasurementEntity> findByOperationType(String operationType);

	// 🔍 Find by measurement type (LENGTH, WEIGHT, etc.)
	List<QuantityMeasurementEntity> findByMeasurementType(String measurementType);

	// 🔍 Combined filter
	List<QuantityMeasurementEntity> findByOperationTypeAndMeasurementType(String operationType, String measurementType);

	// 🔍 Find by User ID
	List<QuantityMeasurementEntity> findByUserId(Long userId);
}
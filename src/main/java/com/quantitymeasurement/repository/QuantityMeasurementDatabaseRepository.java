package com.quantitymeasurement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.quantitymeasurement.util.ConnectionPool;

public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

	private static final String INSERT_SQL = "INSERT INTO quantity_measurements (operation_type, measurement_type, operand1_value, operand1_unit, operand2_value, operand2_unit, result_value, result_unit) VALUES (?,?,?,?,?,?,?,?)";

	@Override
	public void save(QuantityMeasurementEntity entity) {

		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

			ps.setString(1, entity.getOperation());
			ps.setString(2, entity.getMeasurementType());
			ps.setDouble(3, entity.getOperand1Value());
			ps.setString(4, entity.getOperand1Unit());
			ps.setDouble(5, entity.getOperand2Value());
			ps.setString(6, entity.getOperand2Unit());
			ps.setDouble(7, entity.getResultValue());
			ps.setString(8, entity.getResultUnit());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("Failed to save measurement", e);
		}
	}
}
package com.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String operation;
	private String measurementType;

	private double operand1Value;
	private String operand1Unit;

	private Double operand2Value;
	private String operand2Unit;

	private double resultValue;
	private String resultUnit;

	public QuantityMeasurementEntity(String operation, String measurementType, double operand1Value,
			String operand1Unit, Double operand2Value, String operand2Unit, double resultValue, String resultUnit) {

		this.operation = operation;
		this.measurementType = measurementType;
		this.operand1Value = operand1Value;
		this.operand1Unit = operand1Unit;
		this.operand2Value = operand2Value;
		this.operand2Unit = operand2Unit;
		this.resultValue = resultValue;
		this.resultUnit = resultUnit;
	}

	public String getOperation() {
		return operation;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public double getOperand1Value() {
		return operand1Value;
	}

	public String getOperand1Unit() {
		return operand1Unit;
	}

	public Double getOperand2Value() {
		return operand2Value;
	}

	public String getOperand2Unit() {
		return operand2Unit;
	}

	public double getResultValue() {
		return resultValue;
	}

	public String getResultUnit() {
		return resultUnit;
	}
}
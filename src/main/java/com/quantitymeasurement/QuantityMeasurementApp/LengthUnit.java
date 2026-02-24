package com.quantitymeasurement.QuantityMeasurementApp;

public enum LengthUnit implements IMeasurable {
	FEET(1.0), INCHES(1.0 / 12.0), YARDS(3.0), CENTIMETERS(1.0 / 30.48);

	private final double toFeetFactor;

	private LengthUnit(double toFeetFactor) {
		this.toFeetFactor = toFeetFactor;
	}

	// Convert value in this unit → feet (base unit)
	public double convertToBaseUnit(double value) {
		return value * toFeetFactor;
	}

	// Convert value in feet (base unit) → this unit
	public double convertFromBaseUnit(double baseValue) {
		return baseValue / toFeetFactor;
	}

	public double getConversionFactor() {
		return toFeetFactor;
	}

	@Override
	public String getUnitName() {
		return name();
	}
}

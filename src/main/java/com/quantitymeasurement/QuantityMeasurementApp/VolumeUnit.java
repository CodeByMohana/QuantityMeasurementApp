package com.quantitymeasurement.QuantityMeasurementApp;

public enum VolumeUnit implements IMeasurable {
	LITRE(1.0), MILLILITRE(0.001), GALLON(3.78514);

	private final double toLiterFactor;

	private VolumeUnit(double literFactor) {
		this.toLiterFactor = literFactor;
	}

	@Override
	public double getConversionFactor() {
		return toLiterFactor;
	}

	@Override
	public double convertToBaseUnit(double value) {
		return value * toLiterFactor;
	}

	@Override
	public double convertFromBaseUnit(double baseValue) {
		return baseValue / toLiterFactor;
	}

	@Override
	public String getUnitName() {
		return name();
	}

}

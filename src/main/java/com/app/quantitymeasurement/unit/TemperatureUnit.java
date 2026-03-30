package com.app.quantitymeasurement.unit;

public enum TemperatureUnit implements IMeasurable {

	CELSIUS, FAHRENHEIT, KELVIN;

	@Override
	public double convertToBaseUnit(double value) {
		// base = Celsius
		return switch (this) {
		case CELSIUS -> value;
		case FAHRENHEIT -> (value - 32) * 5 / 9;
		case KELVIN -> value - 273.15;
		};
	}

	@Override
	public double convertFromBaseUnit(double baseValue) {
		return switch (this) {
		case CELSIUS -> baseValue;
		case FAHRENHEIT -> (baseValue * 9 / 5) + 32;
		case KELVIN -> baseValue + 273.15;
		};
	}

	@Override
	public String getUnitName() {
		return name();
	}

	@Override
	public void validateOperationSupport(String operation) {
		throw new UnsupportedOperationException("Temperature does not support arithmetic operations like " + operation);
	}
}
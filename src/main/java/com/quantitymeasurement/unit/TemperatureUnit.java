package com.quantitymeasurement.unit;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
	CELSIUS(false), FAHRENHEIT(true);

	private final boolean isFahrenheit;

	private TemperatureUnit(boolean isFarenheit) {
		this.isFahrenheit = isFarenheit;
	}

	final Function<Double, Double> FAHRENHEIT_TO_CELSIUS = (farenheit) -> (farenheit - 32) * 5 / 9;

	final Function<Double, Double> CELSIUS_TO_CELSIUS = (celsius) -> celsius;

	Function<Double, Double> conversionValue;

	private final SupportsArithmetic supportsArithmetic = () -> false;

	@Override
	public double getConversionFactor() {
		return 1.0; // Not used for temperature
	}

	@Override
	public double convertToBaseUnit(double value) {
		return isFahrenheit ? FAHRENHEIT_TO_CELSIUS.apply(value) : CELSIUS_TO_CELSIUS.apply(value);
	}

	@Override
	public double convertFromBaseUnit(double baseValue) {
		if (isFahrenheit) {
			return (baseValue * 9 / 5) + 32;
		}
		return baseValue;
	}

	public double convertTo(double value, TemperatureUnit targetUnit) {
		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}
		double baseValue = this.convertToBaseUnit(value);

		return targetUnit.convertFromBaseUnit(baseValue);
	}

	public boolean supportsArithmetic() {
		return supportsArithmetic.isSupported();
	}

	@Override
	public void validateOperationSupport(String operation) {
		throw new UnsupportedOperationException("Temperature does not support " + operation + "operation");
	}

	@Override
	public String getUnitName() {
		return name();
	}
}

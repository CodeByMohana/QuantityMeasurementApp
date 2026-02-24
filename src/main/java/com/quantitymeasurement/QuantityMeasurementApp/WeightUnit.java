package com.quantitymeasurement.QuantityMeasurementApp;

public enum WeightUnit {
	KILOGRAM(1.0), GRAM(0.001), POUND(0.453592);

	private final double conversionFactor;

	private WeightUnit(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public double convertToBaseUnit(double value) {
		return value * conversionFactor;
	}

	public double convertFromBaseUnit(double baseValue) {
		return Math.round((baseValue / this.conversionFactor) * 100.0) / 100.0;
	}

	public static void main(String[] args) {

		double grams = 10.0;
		double kilograms = WeightUnit.GRAM.convertToBaseUnit(grams);

		System.out.println(kilograms + " kilograms is " + grams + " grams");

	}
}

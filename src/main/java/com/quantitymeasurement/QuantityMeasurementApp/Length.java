package com.quantitymeasurement.QuantityMeasurementApp;

import java.util.Objects;

public class Length {
	private double value;
	private LengthUnit unit;

	public enum LengthUnit {
		FEET(12.0), INCHES(1.0);

		private final double conversionFactor;

		LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}
	}

	public Length(double value, LengthUnit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		this.value = value;
		this.unit = unit;
	}

	private double convertToBaseUnit() {
		return value * unit.getConversionFactor();
	}

	private boolean compare(Length thatLength) {
		double thisBaseValue = this.convertToBaseUnit();
		double thatBaseValue = thatLength.convertToBaseUnit();
		return Double.compare(thisBaseValue, thatBaseValue) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(convertToBaseUnit());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Length other = (Length) obj;

		double thisBaseValue = this.convertToBaseUnit();
		double otherBaseValue = other.convertToBaseUnit();

		return Math.abs(thisBaseValue - otherBaseValue) < 0.0001; // Using a small threshold for floating-point
																	// comparison
	}

	@Override
	public String toString() {
		return value + " " + unit;
	}
}

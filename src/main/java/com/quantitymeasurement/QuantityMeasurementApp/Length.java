package com.quantitymeasurement.QuantityMeasurementApp;

public class Length {
	private double value;
	private LengthUnit unit;

	public enum LengthUnit {
		FEET(12.0), INCHES(1.0);

		private final double conversionFactor;

		private LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}
	}

	public Length(double value, LengthUnit unit) {
		if (Double.isNaN(value)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		this.value = value;
		this.unit = unit;
	}

	private double convertToBaseUnit() {
		return value * unit.getConversionFactor();
	}

	public boolean compare(Length thatLength) {
		return this.equals(thatLength);
	}

	@Override
	public int hashCode() {
		return Double.hashCode(convertToBaseUnit());
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
		return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
	}

	public static void main(String[] args) {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);

		System.out.println(length1.equals(length2));

	}

}
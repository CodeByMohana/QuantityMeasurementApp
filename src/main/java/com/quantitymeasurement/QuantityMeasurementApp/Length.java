package com.quantitymeasurement.QuantityMeasurementApp;

public class Length {
	private double value;
	private LengthUnit unit;

	public enum LengthUnit {
		FEET(12.0), INCHES(1.0), YARDS(36.0), CENTIMETERS(1 / 2.54);

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

	public double convertToBaseUnit() {
		return value * unit.getConversionFactor();
	}

	public LengthUnit getUnit() {
		return unit;
	}

	public double getValue() {
		return value;
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

	public static double convert(double value, LengthUnit source, LengthUnit target) {
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Value must be finite");
		}

		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		double baseValue = value * source.getConversionFactor();

		return baseValue / target.getConversionFactor();
	}

	public Length convertTo(LengthUnit target) {
		double convertedValue = convert(this.value, this.unit, target);

		return new Length(convertedValue, target);
	}

	public Length add(Length other) {
		if (other == null) {
			throw new IllegalArgumentException("Second operand cannot be null");
		}

		if (!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
			throw new IllegalArgumentException("Values must be finite");
		}

		double baseSum = this.convertToBaseUnit() + other.convertToBaseUnit();

		double resetValue = baseSum / this.unit.getConversionFactor();

		return new Length(resetValue, this.unit);
	}

	@Override
	public String toString() {
		return value + " " + unit;
	}

	public static void main(String[] args) {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);

		System.out.println(length1.equals(length2));

		Length length3 = new Length(1.0, LengthUnit.YARDS);
		Length length4 = new Length(36.0, LengthUnit.INCHES);

		System.out.println(length3.equals(length4));

		Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
		Length length6 = new Length(39.3701, LengthUnit.INCHES);

		System.out.println(length5.equals(length6));

	}

}

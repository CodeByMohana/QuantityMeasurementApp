package com.quantitymeasurement.QuantityMeasurementApp;

/**
 * Represents a Length quantity with a numeric value and unit. Supports unit
 * conversion, addition, and equality comparison.
 */
public class Length {

	// Numerical value of the length
	private double value;

	// Unit of measurement (e.g., INCHES, FEET, YARDS, CM, etc.)
	private LengthUnit unit;

	/**
	 * Constructs a Length object.
	 *
	 * @param value numerical value of length
	 * @param unit  unit of the length
	 * @throws IllegalArgumentException if value is NaN or unit is null
	 */
	public Length(double value, LengthUnit unit) {

		// Ensure value is a valid numeric number
		if (Double.isNaN(value)) {
			throw new IllegalArgumentException("Value must be numeric");
		}

		// Ensure unit is provided
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}

		this.value = value;
		this.unit = unit;
	}

	/**
	 * Returns the unit of this length.
	 */
	public LengthUnit getUnit() {
		return unit;
	}

	/**
	 * Returns the numerical value of this length.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Compares this length with another length for equality.
	 *
	 * @param thatLength length to compare with
	 * @return true if both represent equal length, otherwise false
	 */
	public boolean compare(Length thatLength) {
		return this.equals(thatLength);
	}

	/**
	 * Converts a numerical value from source unit to target unit.
	 *
	 * @param value  length value to convert
	 * @param source source unit
	 * @param target target unit
	 * @return converted value in target unit
	 * @throws IllegalArgumentException if value is not finite or units are null
	 */
	public static double convert(double value, LengthUnit source, LengthUnit target) {

		// Ensure value is finite (not NaN, not Infinity)
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Value must be finite");
		}

		// Ensure units are provided
		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		// Convert to base unit first
		double baseValue = value * source.getConversionFactor();

		// Convert from base unit to target unit
		return baseValue / target.getConversionFactor();
	}

	/**
	 * Converts this Length object into another unit.
	 *
	 * @param target target unit
	 * @return new Length object in target unit
	 */
	public Length convertTo(LengthUnit target) {
		double convertedValue = convert(this.value, this.unit, target);
		return new Length(convertedValue, target);
	}

	/**
	 * Adds another length to this one. Result is returned in this length's unit.
	 *
	 * @param other second length operand
	 * @return new Length object representing sum
	 */
	public Length add(Length other) {
		return add(other, this.unit);
	}

	/**
	 * Adds another length and returns result in specified unit.
	 *
	 * @param other      second length operand
	 * @param targetUnit unit in which result should be returned
	 * @return new Length object containing the sum
	 */
	public Length add(Length other, LengthUnit targetUnit) {

		// Validate second operand
		if (other == null) {
			throw new IllegalArgumentException("Second operand cannot be null");
		}

		// Validate target unit
		if (targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");

		// Ensure both values are finite
		if (!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
			throw new IllegalArgumentException("Values must be finite");
		}

		return addInternal(other, targetUnit);
	}

	/**
	 * Internal method that performs addition logic. Converts both lengths to base
	 * unit, adds them, and converts result into target unit.
	 */
	private Length addInternal(Length other, LengthUnit targetUnit) {

		// Convert both to base unit (inches assumed as base)
		double baseSum = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);

		// Convert sum to target unit
		double resultValue = targetUnit.convertFromBaseUnit(baseSum);

		return new Length(resultValue, targetUnit);
	}

	/**
	 * Generates hash code based on normalized base unit value. Ensures consistency
	 * with equals().
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(unit.convertToBaseUnit(value));
	}

	/**
	 * Checks equality between two Length objects. Equality is based on base unit
	 * comparison. Example: 1 foot == 12 inches
	 */
	private static final double EPSILON = 1e-6; // Tolerance for floating-point comparison

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Length other = (Length) obj;

		double thisBaseValue = unit.convertToBaseUnit(value);
		double otherBaseValue = other.unit.convertToBaseUnit(other.value);

		return Math.abs(thisBaseValue - otherBaseValue) < EPSILON;
	}

	/**
	 * Returns string representation of Length.
	 */
	@Override
	public String toString() {
		return value + " " + unit;
	}
}
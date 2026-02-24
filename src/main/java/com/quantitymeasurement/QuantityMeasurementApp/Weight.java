package com.quantitymeasurement.QuantityMeasurementApp;

/**
 * Represents a Weight quantity with a numerical value and a unit. Provides
 * functionality for comparison, conversion, and addition of weight values
 * across different units.
 */
public class Weight {

	// Numerical value of the weight
	private double value;

	// Unit associated with this weight (e.g., KG, Gram, Pound, etc.)
	private WeightUnit unit;

	/**
	 * Constructs a Weight object with given value and unit.
	 *
	 * @param value numerical value of weight
	 * @param unit  unit of the weight
	 * @throws IllegalArgumentException if value is NaN or unit is null
	 */
	public Weight(double value, WeightUnit unit) {
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
	 * Returns the numerical value of this weight.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Returns the unit of this weight.
	 */
	public WeightUnit getUnit() {
		return unit;
	}

	/**
	 * Compares this weight with another weight for equality.
	 *
	 * @param thatWeight weight to compare with
	 * @return true if both weights are equal, otherwise false
	 */
	public boolean compare(Weight thatWeight) {
		return this.equals(thatWeight);
	}

	/**
	 * Converts a weight value from source unit to target unit.
	 *
	 * @param weight value to convert
	 * @param source source unit
	 * @param target target unit
	 * @return converted weight value
	 * @throws IllegalArgumentException if value is not finite or units are null
	 */
	public static double convert(double weight, WeightUnit source, WeightUnit target) {

		// Validate that weight is finite (not NaN, not Infinity)
		if (!Double.isFinite(weight)) {
			throw new IllegalArgumentException("Value must be finite");
		}

		// Ensure units are provided
		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}

		// Convert to base unit first
		double baseValue = weight * source.getConversionFactor();

		// Convert from base unit to target unit
		return baseValue / target.getConversionFactor();
	}

	/**
	 * Converts this Weight object to another unit.
	 *
	 * @param target target unit
	 * @return new Weight object in target unit
	 */
	public Weight convertTo(WeightUnit target) {
		double convertedValue = convert(this.value, this.unit, target);
		return new Weight(convertedValue, target);
	}

	/**
	 * Adds another weight to this weight. Result will be returned in this weight's
	 * unit.
	 *
	 * @param other weight to add
	 * @return new Weight object containing sum
	 */
	public Weight add(Weight other) {
		return add(other, this.unit);
	}

	/**
	 * Adds another weight and returns result in specified target unit.
	 *
	 * @param other      second weight operand
	 * @param targetUnit unit in which result should be returned
	 * @return new Weight object containing sum in target unit
	 */
	public Weight add(Weight other, WeightUnit targetUnit) {

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
	 * Internal method that performs addition logic. Converts both weights to base
	 * unit, adds them, then converts result into target unit.
	 */
	private Weight addInternal(Weight other, WeightUnit targetUnit) {

		// Convert both weights to base unit and add
		double baseSum = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);

		// Convert sum from base unit to target unit
		double resultValue = targetUnit.convertFromBaseUnit(baseSum);

		return new Weight(resultValue, targetUnit);
	}

	/**
	 * Generates hash code based on value.
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}

	/**
	 * Checks equality between two Weight objects. Currently compares only numerical
	 * value.
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Weight other = (Weight) obj;

		double thisBase = this.unit.convertToBaseUnit(this.value);
		double otherBase = other.unit.convertToBaseUnit(other.value);
		return Double.compare(thisBase, otherBase) == 0;
	}

	/**
	 * Returns string representation of Length.
	 */
	@Override
	public String toString() {
		return value + " " + unit;
	}
}
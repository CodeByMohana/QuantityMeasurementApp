package com.quantitymeasurement.QuantityMeasurementApp;

import java.util.Objects;

/**
 * Generic immutable Quantity class representing a measurable value.
 *
 * <p>
 * This class works with any unit type that implements {@link IMeasurable}. It
 * supports: - Unit conversion - Addition - Equality comparison - Hash-based
 * collections compatibility
 *
 * <p>
 * Type parameter U ensures compile-time type safety: Quantity<LengthUnit>
 * cannot be mixed with Quantity<WeightUnit>.
 *
 * @param <U> Unit type that extends IMeasurable
 */
public final class Quantity<U extends IMeasurable> {

	// Numerical value of the quantity
	private final double value;

	// Unit associated with this quantity
	private final U unit;

	/**
	 * Constructs a Quantity object.
	 *
	 * @param value numerical value (must be finite)
	 * @param unit  unit of measurement (must not be null)
	 * @throws IllegalArgumentException if value is not finite or unit is null
	 */
	public Quantity(double value, U unit) {

		// Ensure numeric value is valid (not NaN, not Infinity)
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Value must be a finite number");
		}

		// Unit must be provided
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}

		this.value = value;
		this.unit = unit;
	}

	/**
	 * Returns the numerical value of this quantity.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Returns the unit of this quantity.
	 */
	public U getUnit() {
		return unit;
	}

	// -------------------------
	// Conversion
	// -------------------------

	/**
	 * Converts this quantity into the specified target unit.
	 *
	 * @param targetUnit target unit
	 * @return new Quantity in target unit (immutability preserved)
	 * @throws IllegalArgumentException if targetUnit is null
	 */
	public Quantity<U> convertTo(U targetUnit) {

		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}

		// Convert current value to base unit
		double baseValue = unit.convertToBaseUnit(value);

		// Convert base unit value to target unit
		double converted = targetUnit.convertFromBaseUnit(baseValue);

		// Return new immutable instance
		return new Quantity<>(round(converted), targetUnit);
	}

	// -------------------------
	// Addition
	// -------------------------

	/**
	 * Adds another quantity and returns result in this quantity's unit.
	 */
	public Quantity<U> add(Quantity<U> other) {
		return add(other, this.unit);
	}

	/**
	 * Adds another quantity and returns result in specified target unit.
	 *
	 * @param other      quantity to add
	 * @param targetUnit unit in which result should be returned
	 * @return new Quantity representing sum
	 * @throws IllegalArgumentException if parameters are invalid
	 */
	public Quantity<U> add(Quantity<U> other, U targetUnit) {

		if (other == null) {
			throw new IllegalArgumentException("Other quantity cannot be null");
		}

		if (targetUnit == null) {
			throw new IllegalArgumentException("Target Unit cannot be null");
		}

		// Ensure both quantities belong to same measurement category
		ensureSameCategory(other);

		// Convert both values to base unit before adding
		double baseSum = this.unit.convertToBaseUnit(this.value) + other.unit.convertToBaseUnit(other.value);

		// Convert sum into target unit
		double result = targetUnit.convertFromBaseUnit(baseSum);

		return new Quantity<>(round(result), targetUnit);
	}

	// -------------------------
	// Subtraction
	// -------------------------

	/**
	 * Subtract's another quantity and returns result in this quantity's unit.
	 */
	public Quantity<U> subtract(Quantity<U> other) {
		return subtract(other, this.unit);
	}

	/**
	 * Subtract's another quantity and returns result in specified target unit.
	 *
	 * @param other      quantity to subtract
	 * @param targetUnit unit in which result should be returned
	 * @return new Quantity representing sum
	 * @throws IllegalArgumentException if parameters are invalid
	 */
	public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

		if (other == null) {
			throw new IllegalArgumentException("Other quantity cannot be null");
		}

		if (targetUnit == null) {
			throw new IllegalArgumentException("Target Unit cannot be null");
		}

		// Ensure both quantities belong to same measurement category
		ensureSameCategory(other);

		// Convert both values to base unit before subtracting
		double baseDifference = this.unit.convertToBaseUnit(this.value) - other.unit.convertToBaseUnit(other.value);

		// Convert sum into target unit
		double result = targetUnit.convertFromBaseUnit(baseDifference);

		return new Quantity<>(round(result), targetUnit);
	}

	// -------------------------
	// Division
	// -------------------------

	/**
	 * Divides another quantity and returns result in this quantity's unit.
	 */
	public double divide(Quantity<U> other) {
		if (other == null) {
			throw new IllegalArgumentException("Other quantity cannot be null");
		}

		ensureSameCategory(other);

		double thisBase = this.unit.convertToBaseUnit(this.value);
		double otherBase = other.unit.convertToBaseUnit(other.value);

		if (otherBase == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}

		return round(thisBase / otherBase);

	}

	// -------------------------
	// Equality
	// -------------------------

	/**
	 * Generates hash code based on normalized base value and unit category. Ensures
	 * consistency with equals().
	 */
	@Override
	public int hashCode() {
		double baseValue = unit.convertToBaseUnit(value);
		return Objects.hash(round(baseValue), unit.getClass());
	}

	/**
	 * Compares two Quantity objects for equality.
	 *
	 * <p>
	 * Equality rules: - Same object reference → true - Null → false - Different
	 * classes → false - Different measurement categories → false - Same base-unit
	 * value (after rounding) → true
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Quantity<?> other = (Quantity<?>) obj;

		// Prevent cross-category comparison (Length vs Weight)
		if (!this.unit.getClass().equals(other.unit.getClass()))
			return false;

		double thisBase = this.unit.convertToBaseUnit(this.value);
		double otherBase = other.unit.convertToBaseUnit(other.value);

		return Double.compare(round(thisBase), round(otherBase)) == 0;
	}

	/**
	 * Ensures both quantities belong to same measurement category.
	 *
	 * @throws IllegalArgumentException if categories differ
	 */
	private void ensureSameCategory(Quantity<U> other) {
		if (!this.unit.getClass().equals(other.unit.getClass())) {
			throw new IllegalArgumentException("Cannot operate on different measurement categories");
		}
	}

	/**
	 * Rounds value to two decimal places. Used to mitigate floating-point precision
	 * issues.
	 */
	private double round(double value) {
		return Math.round(value * 1000.0) / 1000.0;
	}

	/**
	 * Returns readable representation of the quantity.
	 */
	@Override
	public String toString() {
		return "Quantity(" + value + ", " + unit.getUnitName() + ")";
	}
}
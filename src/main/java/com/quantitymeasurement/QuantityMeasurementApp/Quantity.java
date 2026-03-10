package com.quantitymeasurement.QuantityMeasurementApp;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

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

	/**
	 * Enum representing supported arithmetic operations for Quantity objects.
	 *
	 * <p>
	 * This enum uses lambda expressions with the {@link DoubleBinaryOperator}
	 * functional interface to define the behavior of each operation.
	 *
	 * <p>
	 * Each constant stores the arithmetic logic that will be applied to two
	 * base-unit values of quantities.
	 *
	 * <p>
	 * This design follows the Strategy Pattern, allowing arithmetic logic to be
	 * encapsulated within enum constants rather than using switch or if-else
	 * statements.
	 */
	private enum ArithmeticOperation {

		/**
		 * Represents addition operation. Computes the sum of two base-unit values.
		 */
		ADD((a, b) -> a + b),

		/**
		 * Represents subtraction operation. Computes the difference between two
		 * base-unit values.
		 */
		SUBTRACT((a, b) -> a - b),

		/**
		 * Represents division operation.
		 *
		 * <p>
		 * Division returns a dimensionless scalar value. This operation validates that
		 * the divisor is not zero to prevent undefined mathematical operations.
		 */
		DIVIDE((a, b) -> {
			if (b == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return a / b;
		});

		/**
		 * Functional operator that performs the arithmetic logic. Stored as a
		 * {@link DoubleBinaryOperator} which accepts two double values and returns a
		 * double result.
		 */
		private final DoubleBinaryOperator operator;

		/**
		 * Constructs an ArithmeticOperation with the specified operator logic.
		 *
		 * @param operator lambda expression implementing the arithmetic logic
		 */
		private ArithmeticOperation(DoubleBinaryOperator operator) {
			this.operator = operator;
		}

		/**
		 * Executes the arithmetic operation on two base-unit values.
		 *
		 * @param a first operand (base unit value)
		 * @param b second operand (base unit value)
		 * @return result of the arithmetic computation
		 */
		double compute(double a, double b) {
			return operator.applyAsDouble(a, b);
		}

	}

	/**
	 * Centralized validation method for arithmetic operations.
	 *
	 * <p>
	 * This method ensures that all arithmetic methods perform consistent validation
	 * before executing any computation.
	 *
	 * Validation performed:
	 * <ul>
	 * <li>Checks if the operand quantity is null</li>
	 * <li>Ensures both quantities belong to the same measurement category</li>
	 * <li>Validates that the target unit is provided when required</li>
	 * </ul>
	 *
	 * @param other              the second operand quantity
	 * @param targetUnit         the unit in which result should be expressed
	 * @param targetUnitRequired flag indicating whether target unit must be
	 *                           validated
	 * @throws IllegalArgumentException if validation fails
	 */
	private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {

		if (other == null) {
			throw new IllegalArgumentException("Other quantity cannot be null");
		}

		// Ensure both quantities belong to the same measurement category
		ensureSameCategory(other);

		// Validate explicit target unit when required (for add/subtract operations)
		if (targetUnitRequired && targetUnit == null) {
			throw new IllegalArgumentException("Target Unit cannot be null");
		}
	}

	/**
	 * Performs arithmetic operations on base-unit values.
	 *
	 * <p>
	 * This method centralizes the conversion and arithmetic logic used by addition,
	 * subtraction, and division operations.
	 *
	 * Steps performed:
	 * <ol>
	 * <li>Convert both quantities to their base-unit representation</li>
	 * <li>Apply the selected arithmetic operation</li>
	 * <li>Return the result in base-unit form</li>
	 * </ol>
	 *
	 * <p>
	 * The result will later be converted into the desired unit by the calling
	 * method (for add/subtract operations).
	 *
	 * @param other     the second operand quantity
	 * @param operation the arithmetic operation to perform
	 * @return result of the operation in base-unit form
	 */
	private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {

		// Convert current quantity to base unit
		double thisBase = this.unit.convertToBaseUnit(this.value);

		// Convert operand quantity to base unit
		double otherBase = other.unit.convertToBaseUnit(other.value);

		// Perform arithmetic operation on base values
		return operation.compute(thisBase, otherBase);
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

		validateArithmeticOperands(other, targetUnit, true);
		
		this.unit.validateOperationSupport("ADD");

		double baseSum = performBaseArithmetic(other, ArithmeticOperation.ADD);

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

		validateArithmeticOperands(other, targetUnit, true);
		
		this.unit.validateOperationSupport("SUBTRACT");

		double baseDifference = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

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

		validateArithmeticOperands(other, null, false);
		
		this.unit.validateOperationSupport("DIVIDE");

		double result = performBaseArithmetic(other, ArithmeticOperation.DIVIDE);

		return round(result);

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
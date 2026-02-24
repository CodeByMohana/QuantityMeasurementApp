package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

	// ================= SAME UNIT TESTS =================

	@Test
	void testEquality_FeetToFeet_SameValue() {
		Length l1 = new Length(1.0, LengthUnit.FEET);
		Length l2 = new Length(1.0, LengthUnit.FEET);

		assertTrue(l1.equals(l2));
	}

	@Test
	void testEquality_InchToInch_SameValue() {
		Length l1 = new Length(5.0, LengthUnit.INCHES);
		Length l2 = new Length(5.0, LengthUnit.INCHES);

		assertTrue(l1.equals(l2));
	}

	@Test
	void testEquality_FeetToFeet_DifferentValue() {
		Length l1 = new Length(1.0, LengthUnit.FEET);
		Length l2 = new Length(2.0, LengthUnit.FEET);

		assertFalse(l1.equals(l2));
	}

	@Test
	void testEquality_InchToInch_DifferentValue() {
		Length l1 = new Length(5.0, LengthUnit.INCHES);
		Length l2 = new Length(10.0, LengthUnit.INCHES);

		assertFalse(l1.equals(l2));
	}

	// ================= CROSS UNIT TESTS =================

	@Test
	void testEquality_FeetToInch_EquivalentValue() {
		Length feet = new Length(1.0, LengthUnit.FEET);
		Length inches = new Length(12.0, LengthUnit.INCHES);

		assertTrue(feet.equals(inches));
	}

	@Test
	void testEquality_InchToFeet_EquivalentValue() {
		Length inches = new Length(12.0, LengthUnit.INCHES);
		Length feet = new Length(1.0, LengthUnit.FEET);

		assertTrue(inches.equals(feet));
	}

	@Test
	void testEquality_CrossUnit_NotEqual() {
		Length feet = new Length(1.0, LengthUnit.FEET);
		Length inches = new Length(10.0, LengthUnit.INCHES);

		assertFalse(feet.equals(inches));
	}

	// ================= EQUALITY CONTRACT TESTS =================

	@Test
	void testEquality_SameReference() {
		Length length = new Length(2.0, LengthUnit.FEET);

		assertTrue(length.equals(length));
	}

	@Test
	void testEquality_NullComparison() {
		Length length = new Length(2.0, LengthUnit.FEET);

		assertFalse(length.equals(null));
	}

	@Test
	void testEquality_DifferentType() {
		Length length = new Length(2.0, LengthUnit.FEET);

		assertFalse(length.equals("Not a Length"));
	}

	// ================= VALIDATION TESTS =================

	@Test
	void testConstructor_InvalidUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
	}

	@Test
	void testConstructor_InvalidValue() {
		assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));
	}

}

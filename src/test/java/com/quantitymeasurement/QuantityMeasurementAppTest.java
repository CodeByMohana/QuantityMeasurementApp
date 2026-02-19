package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
	@Test
	void testEquality_FeetToFeet_SameValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.FEET);
		Length length2 = new Length(1.0, Length.LengthUnit.FEET);

		assertTrue(length1.equals(length2));
	}

	@Test
	void testEquality_InchToInch_SameValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
		Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

		assertTrue(length1.equals(length2));
	}

	@Test
	void testEquality_FeetToInch_EquivalentValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.FEET);
		Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

		assertTrue(length1.equals(length2));
	}

	@Test
	void testEquality_InchToFeet_EquivalentValue() {
		Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
		Length length2 = new Length(1.0, Length.LengthUnit.FEET);

		assertTrue(length1.equals(length2));
	}

	@Test
	void testEquality_FeetToFeet_DifferentValue() {
		Length a = new Length(1.0, Length.LengthUnit.FEET);
		Length b = new Length(2.0, Length.LengthUnit.FEET);

		assertFalse(a.equals(b));
	}

	@Test
	void testEquality_InchToInch_DifferentValue() {
		Length a = new Length(1.0, Length.LengthUnit.INCHES);
		Length b = new Length(2.0, Length.LengthUnit.INCHES);

		assertFalse(a.equals(b));
	}

	@Test
	void testEquality_SameReference() {
		Length length1 = new Length(1.0, Length.LengthUnit.FEET);

		assertTrue(length1.equals(length1));
	}

	@Test
	void testEquality_NullComparison() {
		Length length1 = new Length(1.0, Length.LengthUnit.FEET);

		assertFalse(length1.equals(null));
	}

	@Test
	void testEquality_TypeSafety() {
		Length length1 = new Length(1.0, Length.LengthUnit.FEET);
		String notALength = "Not a Length";

		assertFalse(length1.equals(notALength));
	}

	@Test
	void testEquality_NullUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Length(1.0, null);
		});
	}
}

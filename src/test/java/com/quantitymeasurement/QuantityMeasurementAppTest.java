package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
	@Test
	void testEquality_YardToYard_SameValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_YardToYard_DifferentValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(2.0, Length.LengthUnit.YARDS);
		assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_YardToFeet_EquivalenValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(3.0, Length.LengthUnit.FEET);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_FeetToYard_EquivalentValue() {
		Length length1 = new Length(3.0, Length.LengthUnit.FEET);
		Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_YardToInches_EquivalentValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_InchesToYard_EquivalentValue() {
		Length length1 = new Length(36.0, Length.LengthUnit.INCHES);
		Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_YardToFeet_NonEquivalentValue() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(2.0, Length.LengthUnit.FEET);
		assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_centimetersToInches_EquivalentValue() {
		Length length1 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
		Length length2 = new Length(39.3701, Length.LengthUnit.INCHES);
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_centimetersToFeet_NonEquivalentValue() {
		Length length1 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
		Length length2 = new Length(3.0, Length.LengthUnit.FEET);
		assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_MultiUnit_TransitiveProperty() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(3.0, Length.LengthUnit.FEET);
		Length length3 = new Length(36.0, Length.LengthUnit.INCHES);

		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length2, length3));
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length3));
	}

	@Test
	void testEquality_YardWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Length(1.0, null);
		});
	}

	@Test
	void testEquality_YardSameReference() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = length1; // Same reference
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_YardNullComparison() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = null; // Null reference
		assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_CentimetersWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Length(100.0, null);
		});
	}

	@Test
	void testEquality_CentimetersSameReference() {
		Length length1 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
		Length length2 = length1; // Same reference
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_CentimetersNullComparison() {
		Length length1 = new Length(100.0, Length.LengthUnit.CENTIMETERS);
		Length length2 = null; // Null reference
		assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
	}

	@Test
	void testEquality_AllUnits_ComplexScenario() {
		Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
		Length length2 = new Length(3.0, Length.LengthUnit.FEET);
		Length length3 = new Length(36.0, Length.LengthUnit.INCHES);
		Length length4 = new Length(91.44, Length.LengthUnit.CENTIMETERS);

		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length2, length3));
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length3, length4));
		assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length4));
	}
}

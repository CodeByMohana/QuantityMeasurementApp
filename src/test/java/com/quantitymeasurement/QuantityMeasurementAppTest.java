package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;
import com.quantitymeasurement.QuantityMeasurementApp.QuantityMeasurementApp;

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

	// ================= YARD TESTS =================

	@Test
	void testEquality_YardToYard_SameValue() {
		Length a = new Length(1.0, LengthUnit.YARDS);
		Length b = new Length(1.0, LengthUnit.YARDS);

		assertTrue(a.equals(b));
	}

	@Test
	void testEquality_YardToYard_DifferentValue() {
		Length a = new Length(1.0, LengthUnit.YARDS);
		Length b = new Length(2.0, LengthUnit.YARDS);

		assertFalse(a.equals(b));
	}

	@Test
	void testEquality_YardToFeet_EquivalentValue() {
		Length yard = new Length(1.0, LengthUnit.YARDS);
		Length feet = new Length(3.0, LengthUnit.FEET);

		assertTrue(yard.equals(feet));
	}

	@Test
	void testEquality_FeetToYard_EquivalentValue() {
		Length feet = new Length(3.0, LengthUnit.FEET);
		Length yard = new Length(1.0, LengthUnit.YARDS);

		assertTrue(feet.equals(yard));
	}

	@Test
	void testEquality_YardToInches_EquivalentValue() {
		Length yard = new Length(1.0, LengthUnit.YARDS);
		Length inches = new Length(36.0, LengthUnit.INCHES);

		assertTrue(yard.equals(inches));
	}

	@Test
	void testEquality_InchesToYard_EquivalentValue() {
		Length inches = new Length(36.0, LengthUnit.INCHES);
		Length yard = new Length(1.0, LengthUnit.YARDS);

		assertTrue(inches.equals(yard));
	}

	@Test
	void testEquality_YardToFeet_NonEquivalentValue() {
		Length yard = new Length(1.0, LengthUnit.YARDS);
		Length feet = new Length(2.0, LengthUnit.FEET);

		assertFalse(yard.equals(feet));
	}

	// ================= CENTIMETER TESTS =================

	@Test
	void testEquality_centimetersToInches_EquivalentValue() {
		Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
		Length inch = new Length(0.393701, LengthUnit.INCHES);

		assertTrue(cm.equals(inch));
	}

	@Test
	void testEquality_centimetersToFeet_NonEquivalentValue() {
		Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
		Length feet = new Length(1.0, LengthUnit.FEET);

		assertFalse(cm.equals(feet));
	}

	// ================= TRANSITIVE PROPERTY =================

	@Test
	void testEquality_MultiUnit_TransitiveProperty() {
		Length yard = new Length(1.0, LengthUnit.YARDS);
		Length feet = new Length(3.0, LengthUnit.FEET);
		Length inches = new Length(36.0, LengthUnit.INCHES);

		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inches));
		assertTrue(yard.equals(inches));
	}

	// ================= NULL & REFERENCE TESTS =================

	@Test
	void testEquality_YardWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
	}

	@Test
	void testEquality_YardSameReference() {
		Length yard = new Length(2.0, LengthUnit.YARDS);

		assertTrue(yard.equals(yard));
	}

	@Test
	void testEquality_YardNullComparison() {
		Length yard = new Length(2.0, LengthUnit.YARDS);

		assertFalse(yard.equals(null));
	}

	@Test
	void testEquality_CentimetersWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Length(2.0, null));
	}

	@Test
	void testEquality_CentimetersSameReference() {
		Length cm = new Length(2.0, LengthUnit.CENTIMETERS);

		assertTrue(cm.equals(cm));
	}

	@Test
	void testEquality_CentimetersNullComparison() {
		Length cm = new Length(2.0, LengthUnit.CENTIMETERS);

		assertFalse(cm.equals(null));
	}

	// ================= COMPLEX MULTI-UNIT SCENARIO =================

	@Test
	void testEquality_AllUnits_ComplexScenario() {
		Length yard = new Length(2.0, LengthUnit.YARDS);
		Length feet = new Length(6.0, LengthUnit.FEET);
		Length inches = new Length(72.0, LengthUnit.INCHES);

		assertTrue(yard.equals(feet));
		assertTrue(feet.equals(inches));
		assertTrue(yard.equals(inches));
	}

}

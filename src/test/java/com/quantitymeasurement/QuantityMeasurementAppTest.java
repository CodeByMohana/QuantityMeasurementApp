package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

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
		Length inch = new Length(1.0 / 2.54, LengthUnit.INCHES);

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

	// ================= UC-5 ====================

	private static final double EPSILON = 1e-6;

	// ================= BASIC CONVERSION =================

	@Test
	void testConversion_FeetToInches() {
		assertEquals(12.0, Length.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_InchesToFeet() {
		assertEquals(2.0, Length.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET), EPSILON);
	}

	@Test
	void testConversion_YardsToInches() {
		assertEquals(36.0, Length.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_InchesToYards() {
		assertEquals(2.0, Length.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS), EPSILON);
	}

	@Test
	void testConversion_CentimetersToInches() {
		assertEquals(1.0, Length.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_FeetToYards() {
		assertEquals(2.0, Length.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS), EPSILON);
	}

	// ================= SAME UNIT =================

	@Test
	void testConversion_SameUnit() {
		assertEquals(5.0, Length.convert(5.0, LengthUnit.FEET, LengthUnit.FEET), EPSILON);
	}

	// ================= ZERO & NEGATIVE =================

	@Test
	void testConversion_ZeroValue() {
		assertEquals(0.0, Length.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_NegativeValue() {
		assertEquals(-12.0, Length.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
	}

	// ================= ROUND TRIP =================

	@Test
	void testConversion_RoundTrip_PreservesValue() {

		double original = 5.0;

		double converted = Length.convert(original, LengthUnit.FEET, LengthUnit.YARDS);

		double back = Length.convert(converted, LengthUnit.YARDS, LengthUnit.FEET);

		assertEquals(original, back, EPSILON);
	}

	// ================= INVALID INPUT =================

	@Test
	void testConversion_InvalidUnit_Throws() {
		assertThrows(IllegalArgumentException.class, () -> Length.convert(1.0, null, LengthUnit.FEET));

		assertThrows(IllegalArgumentException.class, () -> Length.convert(1.0, LengthUnit.FEET, null));
	}

	@Test
	void testConversion_NaNOrInfinite_Throws() {
		assertThrows(IllegalArgumentException.class,
				() -> Length.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));

		assertThrows(IllegalArgumentException.class,
				() -> Length.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
	}

	// ================= LARGE & SMALL VALUES =================

	@Test
	void testConversion_LargeValue() {
		assertEquals(1200000.0, Length.convert(100000.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_SmallValue() {
		assertEquals(0.0393701, Length.convert(0.1, LengthUnit.CENTIMETERS, LengthUnit.INCHES), EPSILON);
	}

	// ============== UC-6 ===============
	// ================= SAME UNIT =================

	@Test
	void testAddition_SameUnit_FeetPlusFeet() {
		Length result = new Length(1.0, LengthUnit.FEET).add(new Length(2.0, LengthUnit.FEET));

		assertEquals(3.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.FEET, result.getUnit());
	}

	@Test
	void testAddition_SameUnit_InchPlusInch() {
		Length result = new Length(6.0, LengthUnit.INCHES).add(new Length(6.0, LengthUnit.INCHES));

		assertEquals(12.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.INCHES, result.getUnit());
	}

	// ================= CROSS UNIT =================

	@Test
	void testAddition_CrossUnit_FeetPlusInches() {
		Length result = new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES));

		assertEquals(2.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.FEET, result.getUnit());
	}

	@Test
	void testAddition_CrossUnit_InchPlusFeet() {
		Length result = new Length(12.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.FEET));

		assertEquals(24.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.INCHES, result.getUnit());
	}

	@Test
	void testAddition_CrossUnit_YardPlusFeet() {
		Length result = new Length(1.0, LengthUnit.YARDS).add(new Length(3.0, LengthUnit.FEET));

		assertEquals(2.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.YARDS, result.getUnit());
	}

	@Test
	void testAddition_CrossUnit_CentimeterPlusInch() {
		Length result = new Length(2.54, LengthUnit.CENTIMETERS).add(new Length(1.0, LengthUnit.INCHES));

		assertEquals(5.08, result.getValue(), EPSILON);
		assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
	}

	// ================= COMMUTATIVITY =================

	@Test
	void testAddition_Commutativity() {

		Length a = new Length(1.0, LengthUnit.FEET);
		Length b = new Length(12.0, LengthUnit.INCHES);

		Length result1 = a.add(b);
		Length result2 = b.add(a);

		// Compare in base unit to avoid unit differences
		assertEquals(result1.getUnit().convertToBaseUnit(result1.getValue()),
				result2.getUnit().convertToBaseUnit(result2.getValue()), EPSILON);
	}

	// ================= ZERO =================

	@Test
	void testAddition_WithZero() {
		Length result = new Length(5.0, LengthUnit.FEET).add(new Length(0.0, LengthUnit.INCHES));

		assertEquals(5.0, result.getValue(), EPSILON);
	}

	// ================= NEGATIVE =================

	@Test
	void testAddition_NegativeValues() {
		Length result = new Length(5.0, LengthUnit.FEET).add(new Length(-2.0, LengthUnit.FEET));

		assertEquals(3.0, result.getValue(), EPSILON);
	}

	// ================= NULL =================

	@Test
	void testAddition_NullSecondOperand() {
		assertThrows(IllegalArgumentException.class, () -> new Length(1.0, LengthUnit.FEET).add(null));
	}

	// ================= LARGE =================

	@Test
	void testAddition_LargeValues() {
		Length result = new Length(1e6, LengthUnit.FEET).add(new Length(1e6, LengthUnit.FEET));

		assertEquals(2e6, result.getValue(), EPSILON);
	}

	// ================= SMALL =================

	@Test
	void testAddition_SmallValues() {
		Length result = new Length(0.001, LengthUnit.FEET).add(new Length(0.002, LengthUnit.FEET));

		assertEquals(0.003, result.getValue(), EPSILON);
	}
}
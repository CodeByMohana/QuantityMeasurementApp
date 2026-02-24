package com.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;

public class LengthConversionTest {

	private static final double EPSILON = 1e-6;

	@Test
	void testConversion_FeetToInches() {
		assertEquals(12.0, Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_InchesToFeet() {
		assertEquals(2.0, Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET), EPSILON);
	}

	@Test
	void testConversion_YardsToInches() {
		assertEquals(36.0, Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_InchesToYards() {
		assertEquals(2.0, Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS), EPSILON);
	}

	@Test
	void testConversion_CentimetersToInches() {
		assertEquals(1.0, Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES), 1e-4);
	}

	@Test
	void testConversion_FeetToYards() {
		assertEquals(2.0, Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS), EPSILON);
	}

	@Test
	void testConversion_ZeroValue() {
		assertEquals(0.0, Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_NegativeValue() {
		assertEquals(-12.0, Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
	}

	@Test
	void testConversion_SameUnit() {
		assertEquals(5.0, Length.convert(5.0, Length.LengthUnit.FEET, Length.LengthUnit.FEET), EPSILON);
	}

	@Test
	void testConversion_RoundTrip_PreservesValue() {
		double original = 7.35;

		double converted = Length.convert(
				Length.convert(original, Length.LengthUnit.FEET, Length.LengthUnit.CENTIMETERS),
				Length.LengthUnit.CENTIMETERS, Length.LengthUnit.FEET);

		assertEquals(original, converted, 1e-4);
	}

	@Test
	void testEquality_AfterConversion() {
		Length a = new Length(1.0, Length.LengthUnit.FEET);
		Length b = new Length(12.0, Length.LengthUnit.INCHES);

		assertTrue(a.equals(b));
	}

	@Test
	void testConversion_InvalidUnit_Throws() {
		assertThrows(IllegalArgumentException.class, () -> Length.convert(1.0, null, Length.LengthUnit.FEET));
	}

	@Test
	void testConversion_NaN_Throws() {
		assertThrows(IllegalArgumentException.class,
				() -> Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
	}

	@Test
	void testConversion_Infinite_Throws() {
		assertThrows(IllegalArgumentException.class,
				() -> Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
	}

	@Test
	void testInstanceConversion() {
		Length original = new Length(1.0, Length.LengthUnit.FEET);

		Length result = original.convertTo(Length.LengthUnit.INCHES).convertTo(Length.LengthUnit.FEET)
				.convertTo(Length.LengthUnit.CENTIMETERS).convertTo(Length.LengthUnit.YARDS)
				.convertTo(Length.LengthUnit.FEET);

		assertTrue(original.equals(result));
	}

}
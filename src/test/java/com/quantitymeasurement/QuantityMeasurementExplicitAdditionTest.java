package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementExplicitAdditionTest {

	private static final double EPSILON = 1e-12;

	@Test
	void testAddition_ExplicitTargetUnit_Feet() {

		Length result = new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET);

		assertEquals(2.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.FEET, result.getUnit());
	}

	@Test
	void testAddition_ExplicitTargetUnit_Inches() {

		Length result = new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.INCHES);

		assertEquals(24.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.INCHES, result.getUnit());
	}

	@Test
	void testAddition_ExplicitTargetUnit_Yards() {

		Length result = new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);

		assertEquals(24.0 / 36.0, result.getValue(), EPSILON);
		assertEquals(LengthUnit.YARDS, result.getUnit());
	}

	@Test
	void testAddition_ExplicitTargetUnit_Centimeters() {

		Length result = new Length(1.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.INCHES),
				LengthUnit.CENTIMETERS);

		assertEquals(2 * 2.54, result.getValue(), EPSILON);
		assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
	}

	@Test
	void testAddition_ExplicitTargetUnit_Commutativity() {

		Length a = new Length(1.0, LengthUnit.FEET);
		Length b = new Length(12.0, LengthUnit.INCHES);

		Length result1 = a.add(b, LengthUnit.YARDS);
		Length result2 = b.add(a, LengthUnit.YARDS);

		assertEquals(result1.getValue(), result2.getValue(), EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_WithZero() {

		Length result = new Length(5.0, LengthUnit.FEET).add(new Length(0.0, LengthUnit.INCHES), LengthUnit.YARDS);

		assertEquals(5.0 / 3.0, result.getValue(), EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_NegativeValues() {

		Length result = new Length(5.0, LengthUnit.FEET).add(new Length(-2.0, LengthUnit.FEET), LengthUnit.INCHES);

		assertEquals(36.0, result.getValue(), EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_NullTargetUnit() {

		assertThrows(IllegalArgumentException.class,
				() -> new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), null));
	}

	@Test
	void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

		Length result = new Length(1000.0, LengthUnit.FEET).add(new Length(500.0, LengthUnit.FEET), LengthUnit.INCHES);

		assertEquals(1500.0 * 12.0, result.getValue(), EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

		Length result = new Length(12.0, LengthUnit.INCHES).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);

		assertEquals(24.0 / 36.0, result.getValue(), EPSILON);
	}
}
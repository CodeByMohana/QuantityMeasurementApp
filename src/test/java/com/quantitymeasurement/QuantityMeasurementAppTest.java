package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

	@Test
	public void testFeetEquality_SameValue() {
		QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

		assertTrue(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_DifferentValue() {
		QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);

		assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_NullComparison() {
		QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);

		assertFalse(feet1.equals(null));
	}

	@Test
	public void testFeetEquality_NonNumericInput() {
		QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
		char nonNumericInput = 'a';
		assertFalse(feet1.equals(nonNumericInput));
	}

	@Test
	public void testFeetEquality_SameReference() {
		QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet feet2 = feet1; // Same reference

		assertTrue(feet1.equals(feet2));
	}

	@Test
	public void testInchesEquality_SameValue() {
		QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
		QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);

		assertTrue(inches1.equals(inches2));
	}

	@Test
	public void testInchesEquality_DifferentValue() {
		QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
		QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(2.0);

		assertFalse(inches1.equals(inches2));
	}

	@Test
	public void testInchesEquality_NullComparison() {
		QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);

		assertFalse(inches1.equals(null));
	}

	@Test
	public void testInchesEquality_NonNumericInput() {
		QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
		String nonNumericInput = "abc";
		assertFalse(inches1.equals(nonNumericInput));
	}

	@Test
	public void testInchesEquality_SameReference() {
		QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
		QuantityMeasurementApp.Inches inches2 = inches1; // Same reference

		assertTrue(inches1.equals(inches2));
	}

}

package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

	@Test
	void testFeetEquqality_SameValue() {
		QuantityMeasurementApp.Feet value1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet value2 = new QuantityMeasurementApp.Feet(1.0);

		assertTrue(value1.equals(value2), "Feet objects with the same value should be equal");
	}

	@Test
	void testFeetEquqality_DifferentValue() {
		QuantityMeasurementApp.Feet value1 = new QuantityMeasurementApp.Feet(1.0);
		QuantityMeasurementApp.Feet value2 = new QuantityMeasurementApp.Feet(2.0);

		assertFalse(value1.equals(value2), "Feet objects with the different value should not be equal");

	}

	@Test
	void testFeetEquqality_NullComparision() {
		QuantityMeasurementApp.Feet value1 = new QuantityMeasurementApp.Feet(2.0);

		assertFalse(value1.equals(null), "Feet object should not be equal to null");
	}

	@Test
	void testFeetEquqality_DifferentClass() {
		QuantityMeasurementApp.Feet value1 = new QuantityMeasurementApp.Feet(2.0);

		String nonFeet = "non feet";

		assertFalse(value1.equals(nonFeet), "Feet object should not be equal to an object of different class");
	}

	@Test
	void testFeetEquqality_SameReference() {
		QuantityMeasurementApp.Feet value1 = new QuantityMeasurementApp.Feet(2.0);

		assertTrue(value1.equals(value1), "Feet object should be equal to itself");

	}
}

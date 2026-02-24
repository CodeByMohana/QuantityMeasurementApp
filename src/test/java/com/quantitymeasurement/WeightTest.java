package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.Weight;
import com.quantitymeasurement.QuantityMeasurementApp.WeightUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {

	private static final double EPSILON = 0.0001;

	// =========================
	// Equality Tests
	// =========================

	@Test
	void testEquality_KilogramToKilogram_SameValue() {
		assertTrue(new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(1.0, WeightUnit.KILOGRAM)));
	}

	@Test
	void testEquality_KilogramToKilogram_DifferentValue() {
		assertFalse(new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(2.0, WeightUnit.KILOGRAM)));
	}

	@Test
	void testEquality_KilogramToGram_EquivalentValue() {
		assertTrue(new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(1000.0, WeightUnit.GRAM)));
	}

	@Test
	void testEquality_GramToKilogram_EquivalentValue() {
		assertTrue(new Weight(1000.0, WeightUnit.GRAM).equals(new Weight(1.0, WeightUnit.KILOGRAM)));
	}

	@Test
	void testEquality_NullComparison() {
		assertFalse(new Weight(1.0, WeightUnit.KILOGRAM).equals(null));
	}

	@Test
	void testEquality_SameReference() {
		Weight w = new Weight(1.0, WeightUnit.KILOGRAM);
		assertTrue(w.equals(w));
	}

	@Test
	void testEquality_NullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Weight(1.0, null));
	}

	@Test
	void testEquality_TransitiveProperty() {
		Weight a = new Weight(1.0, WeightUnit.KILOGRAM);
		Weight b = new Weight(1000.0, WeightUnit.GRAM);
		Weight c = new Weight(1.0, WeightUnit.KILOGRAM);

		assertTrue(a.equals(b));
		assertTrue(b.equals(c));
		assertTrue(a.equals(c));
	}

	@Test
	void testEquality_ZeroValue() {
		assertTrue(new Weight(0.0, WeightUnit.KILOGRAM).equals(new Weight(0.0, WeightUnit.GRAM)));
	}

	@Test
	void testEquality_NegativeWeight() {
		assertTrue(new Weight(-1.0, WeightUnit.KILOGRAM).equals(new Weight(-1000.0, WeightUnit.GRAM)));
	}

	@Test
	void testEquality_LargeWeightValue() {
		assertTrue(new Weight(1000000.0, WeightUnit.GRAM).equals(new Weight(1000.0, WeightUnit.KILOGRAM)));
	}

	@Test
	void testEquality_SmallWeightValue() {
		assertTrue(new Weight(0.001, WeightUnit.KILOGRAM).equals(new Weight(1.0, WeightUnit.GRAM)));
	}

	// =========================
	// Conversion Tests
	// =========================

	@Test
	void testConversion_PoundToKilogram() {
		Weight converted = new Weight(2.20462, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM);

		assertEquals(1.0, converted.getValue(), EPSILON);
	}

	@Test
	void testConversion_KilogramToPound() {
		Weight converted = new Weight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.POUND);

		assertEquals(2.20462, converted.getValue(), EPSILON);
	}

	@Test
	void testConversion_SameUnit() {
		Weight converted = new Weight(5.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.KILOGRAM);

		assertEquals(5.0, converted.getValue());
	}

	@Test
	void testConversion_ZeroValue() {
		Weight converted = new Weight(0.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);

		assertEquals(0.0, converted.getValue());
	}

	@Test
	void testConversion_NegativeValue() {
		Weight converted = new Weight(-1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);

		assertEquals(-1000.0, converted.getValue());
	}

	@Test
	void testConversion_RoundTrip() {
		Weight original = new Weight(1.5, WeightUnit.KILOGRAM);

		Weight roundTrip = original.convertTo(WeightUnit.GRAM).convertTo(WeightUnit.KILOGRAM);

		assertEquals(original.getValue(), roundTrip.getValue(), EPSILON);
	}

	// =========================
	// Addition Tests
	// =========================

	@Test
	void testAddition_SameUnit_KilogramPlusKilogram() {
		Weight result = new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(2.0, WeightUnit.KILOGRAM));

		assertEquals(3.0, result.getValue());
	}

	@Test
	void testAddition_CrossUnit_KilogramPlusGram() {
		Weight result = new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(1000.0, WeightUnit.GRAM));

		assertEquals(2.0, result.getValue());
	}

	@Test
	void testAddition_CrossUnit_PoundPlusKilogram() {
		Weight result = new Weight(2.20462, WeightUnit.POUND).add(new Weight(1.0, WeightUnit.KILOGRAM));

		assertEquals(4.41, result.getValue(), EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_Kilogram() {
		Weight result = new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

		assertEquals(2000.0, result.getValue());
	}

	@Test
	void testAddition_Commutativity() {
		Weight a = new Weight(1.0, WeightUnit.KILOGRAM);
		Weight b = new Weight(1000.0, WeightUnit.GRAM);

		assertTrue(a.add(b).equals(b.add(a)));
	}

	@Test
	void testAddition_WithZero() {
		Weight result = new Weight(5.0, WeightUnit.KILOGRAM).add(new Weight(0.0, WeightUnit.GRAM));

		assertEquals(5.0, result.getValue());
	}

	@Test
	void testAddition_NegativeValues() {
		Weight result = new Weight(5.0, WeightUnit.KILOGRAM).add(new Weight(-2000.0, WeightUnit.GRAM));

		assertEquals(3.0, result.getValue());
	}

	@Test
	void testAddition_LargeValues() {
		Weight result = new Weight(1e6, WeightUnit.KILOGRAM).add(new Weight(1e6, WeightUnit.KILOGRAM));

		assertEquals(2e6, result.getValue());
	}
}
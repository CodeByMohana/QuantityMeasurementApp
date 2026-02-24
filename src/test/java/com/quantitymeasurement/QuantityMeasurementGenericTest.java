package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.QuantityMeasurementApp.IMeasurable;
import com.quantitymeasurement.QuantityMeasurementApp.LengthUnit;
import com.quantitymeasurement.QuantityMeasurementApp.Quantity;
import com.quantitymeasurement.QuantityMeasurementApp.WeightUnit;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementGenericTest {

	private static final double EPSILON = 0.01;

	// =========================================================
	// IMeasurable Interface Tests
	// =========================================================

	@Test
	void testIMeasurableInterface_LengthUnitImplementation() {

		IMeasurable unit = LengthUnit.FEET;

		assertNotNull(unit.getConversionFactor());
		assertEquals(1.0, unit.convertToBaseUnit(1.0)); // 1 ft → 1 ft
		assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0)); // 1 ft → 12 inches
		assertEquals("FEET", unit.getUnitName());
	}

	@Test
	void testIMeasurableInterface_WeightUnitImplementation() {
		IMeasurable unit = WeightUnit.KILOGRAM;

		assertEquals(1.0, unit.convertToBaseUnit(1.0)); // 1 kg → 1 kg
		assertEquals(1000.0, unit.convertFromBaseUnit(1000.0)); // 1000 kg → 1000 kg
		assertEquals("KILOGRAM", unit.getUnitName());
	}

	@Test
	void testIMeasurableInterface_ConsistentBehavior() {
		assertTrue(LengthUnit.FEET instanceof IMeasurable);
		assertTrue(WeightUnit.GRAM instanceof IMeasurable);
	}

	// =========================================================
	// Generic Quantity – Equality
	// =========================================================

	@Test
	void testGenericQuantity_LengthOperations_Equality() {
		Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

		assertTrue(q1.equals(q2));
	}

	@Test
	void testGenericQuantity_WeightOperations_Equality() {
		Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
		Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		assertTrue(q1.equals(q2));
	}

	// =========================================================
	// Conversion
	// =========================================================

	@Test
	void testGenericQuantity_LengthOperations_Conversion() {
		Quantity<LengthUnit> result = new Quantity<>(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);

		assertEquals(12.0, result.getValue(), EPSILON);
	}

	@Test
	void testGenericQuantity_WeightOperations_Conversion() {
		Quantity<WeightUnit> result = new Quantity<>(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);

		assertEquals(1000.0, result.getValue(), EPSILON);
	}

	// =========================================================
	// Addition
	// =========================================================

	@Test
	void testGenericQuantity_LengthOperations_Addition() {
		Quantity<LengthUnit> result = new Quantity<>(1.0, LengthUnit.FEET).add(new Quantity<>(12.0, LengthUnit.INCHES),
				LengthUnit.FEET);

		assertEquals(2.0, result.getValue(), EPSILON);
	}

	@Test
	void testGenericQuantity_WeightOperations_Addition() {
		Quantity<WeightUnit> result = new Quantity<>(1.0, WeightUnit.KILOGRAM)
				.add(new Quantity<>(1000.0, WeightUnit.GRAM), WeightUnit.KILOGRAM);

		assertEquals(2.0, result.getValue(), EPSILON);
	}

	// =========================================================
	// Cross Category Safety
	// =========================================================

	@Test
	void testCrossCategoryPrevention_LengthVsWeight() {
		Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

		Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

		assertFalse(length.equals(weight));
	}

	/*
	 * testCrossCategoryPrevention_CompilerTypeSafety()
	 *
	 * This is compile-time enforced.
	 *
	 * Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
	 *
	 * Quantity<WeightUnit> weight = length; // DOES NOT COMPILE
	 */

	// =========================================================
	// Constructor Validation
	// =========================================================

	@Test
	void testGenericQuantity_ConstructorValidation_NullUnit() {
		assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
	}

	@Test
	void testGenericQuantity_ConstructorValidation_InvalidValue() {
		assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
	}

	// =========================================================
	// HashCode & Equals Contract
	// =========================================================

	@Test
	void testHashCode_GenericQuantity_Consistency() {
		Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

		Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

		assertEquals(q1.hashCode(), q2.hashCode());
	}

	@Test
	void testEquals_GenericQuantity_ContractPreservation() {
		Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
		Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
		Quantity<LengthUnit> c = new Quantity<>(1.0, LengthUnit.FEET);

		assertTrue(a.equals(a)); // reflexive
		assertTrue(a.equals(b)); // symmetric
		assertTrue(b.equals(a));
		assertTrue(a.equals(c)); // transitive
	}

	// =========================================================
	// Immutability
	// =========================================================

	@Test
	void testImmutability_GenericQuantity() {
		Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);

		assertTrue(Modifier.isFinal(q.getClass().getModifiers()));
	}

	// =========================================================
	// Wildcard Flexibility
	// =========================================================

	private void acceptWildcard(Quantity<?> q) {
		assertNotNull(q);
	}

	@Test
	void testTypeWildcard_FlexibleSignatures() {
		acceptWildcard(new Quantity<>(1.0, LengthUnit.FEET));
		acceptWildcard(new Quantity<>(1.0, WeightUnit.KILOGRAM));
	}

	// =========================================================
	// Scalability – New Category Integration
	// =========================================================

	enum VolumeUnit implements IMeasurable {
		LITER(1.0), MILLILITER(0.001);

		private final double factor;

		VolumeUnit(double factor) {
			this.factor = factor;
		}

		public double getConversionFactor() {
			return factor;
		}

		public double convertToBaseUnit(double value) {
			return value * factor;
		}

		public double convertFromBaseUnit(double baseValue) {
			return baseValue / factor;
		}

		public String getUnitName() {
			return name();
		}
	}

	@Test
	void testScalability_NewUnitEnumIntegration() {
		Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITER);

		Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);

		assertTrue(q1.equals(q2));
	}
}

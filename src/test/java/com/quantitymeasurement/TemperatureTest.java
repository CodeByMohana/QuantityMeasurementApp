package com.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.units.LengthUnit;
import com.quantitymeasurement.units.TemperatureUnit;
import com.quantitymeasurement.units.VolumeUnit;
import com.quantitymeasurement.units.WeightUnit;

class TemperatureTest {

	@Test
	void testTemperatureEquality_CelsiusToCelsius_SameValue() {
		assertTrue(new Quantity<>(0.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(0.0, TemperatureUnit.CELSIUS)));
	}

	@Test
	void testTemperatureEquality_FahrenheitToFahrenheit_SameValue() {
		assertTrue(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)
				.equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)));
	}

	@Test
	void testTemperatureEquality_CelsiusToFahrenheit_0C_32F() {
		assertTrue(
				new Quantity<>(0.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)));
	}

	@Test
	void testTemperatureEquality_CelsiusToFahrenheit_100C_212F() {
		assertTrue(new Quantity<>(100.0, TemperatureUnit.CELSIUS)
				.equals(new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT)));
	}

	@Test
	void testTemperatureEquality_CelsiusToFahrenheit_Neg40() {
		assertTrue(new Quantity<>(-40.0, TemperatureUnit.CELSIUS)
				.equals(new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT)));
	}

	@Test
	void testTemperatureEquality_SymmetricProperty() {
		Quantity<TemperatureUnit> a = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
		Quantity<TemperatureUnit> b = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
	}

	@Test
	void testTemperatureEquality_ReflexiveProperty() {
		Quantity<TemperatureUnit> temp = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
		assertTrue(temp.equals(temp));
	}


	@Test
	void testTemperatureConversion_CelsiusToFahrenheit() {
		Quantity<TemperatureUnit> result = new Quantity<>(50.0, TemperatureUnit.CELSIUS)
				.convertTo(TemperatureUnit.FAHRENHEIT);

		assertEquals(122.0, result.getValue());
	}

	@Test
	void testTemperatureConversion_FahrenheitToCelsius() {
		Quantity<TemperatureUnit> result = new Quantity<>(122.0, TemperatureUnit.FAHRENHEIT)
				.convertTo(TemperatureUnit.CELSIUS);

		assertEquals(50.0, result.getValue());
	}

	@Test
	void testTemperatureConversion_RoundTrip() {
		Quantity<TemperatureUnit> original = new Quantity<>(37.0, TemperatureUnit.CELSIUS);

		Quantity<TemperatureUnit> converted = original.convertTo(TemperatureUnit.FAHRENHEIT)
				.convertTo(TemperatureUnit.CELSIUS);

		assertEquals(original.getValue(), converted.getValue(), 0.01);
	}

	@Test
	void testTemperatureConversion_SameUnit() {
		Quantity<TemperatureUnit> result = new Quantity<>(25.0, TemperatureUnit.CELSIUS)
				.convertTo(TemperatureUnit.CELSIUS);

		assertEquals(25.0, result.getValue());
	}

	@Test
	void testTemperatureConversion_ZeroValue() {
		Quantity<TemperatureUnit> result = new Quantity<>(0.0, TemperatureUnit.CELSIUS)
				.convertTo(TemperatureUnit.FAHRENHEIT);

		assertEquals(32.0, result.getValue());
	}

	@Test
	void testTemperatureConversion_NegativeValue() {
		Quantity<TemperatureUnit> result = new Quantity<>(-20.0, TemperatureUnit.CELSIUS)
				.convertTo(TemperatureUnit.FAHRENHEIT);

		assertEquals(-4.0, result.getValue());
	}

	@Test
	void testTemperatureConversion_LargeValue() {
		Quantity<TemperatureUnit> result = new Quantity<>(1000.0, TemperatureUnit.CELSIUS)
				.convertTo(TemperatureUnit.FAHRENHEIT);

		assertEquals(1832.0, result.getValue());
	}

	@Test
	void testTemperatureUnsupportedOperation_Add() {
		assertThrows(UnsupportedOperationException.class, () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
				.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
	}

	@Test
	void testTemperatureUnsupportedOperation_Subtract() {
		assertThrows(UnsupportedOperationException.class, () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
				.subtract(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
	}

	@Test
	void testTemperatureUnsupportedOperation_Divide() {
		assertThrows(UnsupportedOperationException.class, () -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
				.divide(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
	}

	@Test
	void testTemperatureUnsupportedOperation_ErrorMessage() {
		Exception ex = assertThrows(UnsupportedOperationException.class,
				() -> new Quantity<>(100.0, TemperatureUnit.CELSIUS)
						.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));

		assertTrue(ex.getMessage().contains("does not support"));
	}

	@Test
	void testTemperatureVsLengthIncompatibility() {
		assertFalse(new Quantity<>(100.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(100.0, LengthUnit.FEET)));
	}

	@Test
	void testTemperatureVsWeightIncompatibility() {
		assertFalse(new Quantity<>(50.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(50.0, WeightUnit.KILOGRAM)));
	}

	@Test
	void testTemperatureVsVolumeIncompatibility() {
		assertFalse(new Quantity<>(25.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(25.0, VolumeUnit.LITRE)));
	}

	@Test
	void testOperationSupport_Temperature_Addition() {
		assertFalse(TemperatureUnit.CELSIUS.supportsArithmetic());
	}

	@Test
	void testOperationSupport_Temperature_Division() {
		assertFalse(TemperatureUnit.FAHRENHEIT.supportsArithmetic());
	}

	@Test
	void testTemperatureUnit_AllConstants() {
		assertNotNull(TemperatureUnit.CELSIUS);
		assertNotNull(TemperatureUnit.FAHRENHEIT);
	}

	@Test
	void testTemperatureUnit_NameMethod() {
		assertEquals("CELSIUS", TemperatureUnit.CELSIUS.getUnitName());
	}

	@Test
	void testTemperatureUnit_ConversionFactor() {
		assertEquals(1.0, TemperatureUnit.CELSIUS.getConversionFactor());
	}

	@Test
	void testTemperatureNullOperandComparison() {
		assertFalse(new Quantity<>(10.0, TemperatureUnit.CELSIUS).equals(null));
	}

	@Test
	void testTemperatureDifferentValuesInequality() {
		assertFalse(
				new Quantity<>(50.0, TemperatureUnit.CELSIUS).equals(new Quantity<>(100.0, TemperatureUnit.CELSIUS)));
	}

	@Test
	void testTemperatureValidateOperationSupport_Method() {
		assertThrows(UnsupportedOperationException.class,
				() -> TemperatureUnit.CELSIUS.validateOperationSupport("ADD"));
	}
}

package com.quantitymeasurement.QuantityMeasurementApp;

public class QuantityMeasurementApp {

	public static <U extends IMeasurable> void demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
		System.out.println(q1 + " equals " + q2 + " → " + q1.equals(q2));
	}

	public static <U extends IMeasurable> void demonstrateConversion(Quantity<U> q, U targetUnit) {
		System.out.println(q + " converted → " + q.convertTo(targetUnit));
	}

	public static <U extends IMeasurable> void demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
		System.out.println(q1 + " + " + q2 + " → " + q1.add(q2, targetUnit));
	}

	public static void main(String[] args) {

		// Length
		System.out.println("============= Length ================");
		System.out.println();
		demonstrateEquality(new Quantity<>(1.0, LengthUnit.FEET), new Quantity<>(12.0, LengthUnit.INCHES));

		demonstrateConversion(new Quantity<>(1.0, LengthUnit.FEET), LengthUnit.INCHES);

		demonstrateAddition(new Quantity<>(1.0, LengthUnit.FEET), new Quantity<>(12.0, LengthUnit.INCHES),
				LengthUnit.FEET);

		// Weight
		System.out.println();
		System.out.println("============= Weight ================");
		System.out.println();
		demonstrateEquality(new Quantity<>(1.0, WeightUnit.KILOGRAM), new Quantity<>(1000.0, WeightUnit.GRAM));

		demonstrateConversion(new Quantity<>(1.0, WeightUnit.KILOGRAM), WeightUnit.GRAM);

		demonstrateAddition(new Quantity<>(1.0, WeightUnit.KILOGRAM), new Quantity<>(1000.0, WeightUnit.GRAM),
				WeightUnit.KILOGRAM);

		// Volume
		System.out.println();
		System.out.println("============= Volume ================");
		System.out.println();
		demonstrateEquality(new Quantity<>(3.79, VolumeUnit.LITRE), new Quantity<>(1, VolumeUnit.GALLON));
		demonstrateConversion(new Quantity<>(1.0, VolumeUnit.GALLON), VolumeUnit.LITRE);
		demonstrateAddition(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(100, VolumeUnit.MILLILITRE),
				VolumeUnit.LITRE);

		Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
		Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
		Quantity<VolumeUnit> v3 = new Quantity<>(1.0, VolumeUnit.GALLON);

		// Equality
		System.out.println(v1.equals(v2)); // true
		System.out.println(v3.equals(new Quantity<>(3.78541, VolumeUnit.LITRE))); // true

		// Conversion
		System.out.println(v1.convertTo(VolumeUnit.MILLILITRE)); // 1000 mL
		System.out.println(v3.convertTo(VolumeUnit.LITRE)); // 3.78541 L

		// Addition
		System.out.println(v1.add(v2)); // 2.0 L
		System.out.println(v1.add(v3, VolumeUnit.MILLILITRE)); // 4785.41 mL
	}
}
package com.quantitymeasurement.QuantityMeasurementApp;

import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementApp {
	public static boolean demonstrateLengthEquality(Length length1, Length length2) {
		return length1.equals(length2);
	}

	public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2,
			LengthUnit unit2) {
		Length length1 = new Length(value1, unit1);
		Length length2 = new Length(value2, unit2);

		return length1.equals(length2);

	}

	public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
		return new Length(value, from).convertTo(to);

	}

	public static Length demonstrateLengthConversion(Length length, LengthUnit target) {

		return length.convertTo(target);
	}

	public static void main(String[] args) {

		// -------- Raw value conversion --------
		Length result1 = demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

		System.out.println("1 FEET → INCHES = " + result1);

		Length result2 = demonstrateLengthConversion(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);

		System.out.println("3 YARDS → FEET = " + result2);

		Length result3 = demonstrateLengthConversion(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);

		System.out.println("36 INCHES → YARDS = " + result3);

		Length result4 = demonstrateLengthConversion(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);

		System.out.println("1 CM → INCHES = " + result4);

		// -------- Instance-based conversion --------
		Length lengthInYards = new Length(2.0, Length.LengthUnit.YARDS);

		Length converted = demonstrateLengthConversion(lengthInYards, Length.LengthUnit.INCHES);

		System.out.println("2 YARDS → INCHES = " + converted);

		// -------- Equality check --------
		Length feet = new Length(3.0, Length.LengthUnit.FEET);
		Length yard = new Length(1.0, Length.LengthUnit.YARDS);

		System.out.println("3 FEET equals 1 YARD ? " + feet.equals(yard));

	}
}

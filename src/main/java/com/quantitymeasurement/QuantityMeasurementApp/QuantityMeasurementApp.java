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

	public static void main(String[] args) {

		// 1 yard = 3 feet
		System.out.println(demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET));

		// 1 yard = 36 inches
		System.out.println(demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES));

		// 1 = 0.393701 inches
		System.out.println(demonstrateLengthComparison(1.0, LengthUnit.CENTIMETERS, 0.393701, LengthUnit.INCHES));
	}
}

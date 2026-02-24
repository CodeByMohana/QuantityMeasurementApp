package com.quantitymeasurement.QuantityMeasurementApp;

import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementApp {
	public static boolean demonstrateLengthEquality(Length length1, Length length2) {
		return length1.equals(length2);
	}

	public static void demonstrateFeetEquality() {
		Length feet1 = new Length(1.0, LengthUnit.FEET);
		Length feet2 = new Length(1.0, LengthUnit.FEET);

		System.out.println(feet1.equals(feet2));

	}

	public static void demonstrateInchesEquality() {
		Length inches1 = new Length(1.0, LengthUnit.INCHES);
		Length inches2 = new Length(1.0, LengthUnit.INCHES);

		System.out.println(inches1.equals(inches2));

	}

	public static void demonstrateFeetInchesComparision() {
		Length feet = new Length(1.0, LengthUnit.FEET);
		Length inches = new Length(12.0, LengthUnit.INCHES);

		System.out.println(feet.equals(inches));

	}

	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetInchesComparision();

		Length feet = new Length(1.0, LengthUnit.FEET);
		Length inches = new Length(12.0, LengthUnit.INCHES);

		System.out.println(demonstrateLengthEquality(feet, inches));
	}
}

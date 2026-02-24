package com.quantitymeasurement.QuantityMeasurementApp;

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

	public static Length demonstrateLengthAddition(Length l1, Length l2) {
		return l1.add(l2);
	}

	public static void main(String[] args) {

		System.out.println(new Length(1.0, LengthUnit.FEET).add(new Length(2.0, LengthUnit.FEET)));

		System.out.println(new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES)));

		System.out.println(new Length(12.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.FEET)));

		System.out.println(new Length(1.0, LengthUnit.YARDS).add(new Length(3.0, LengthUnit.FEET)));

		System.out.println(new Length(36.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.YARDS)));

		System.out.println(new Length(2.54, LengthUnit.CENTIMETERS).add(new Length(1.0, LengthUnit.INCHES)));

		System.out.println(new Length(5.0, LengthUnit.FEET).add(new Length(0.0, LengthUnit.INCHES)));

		System.out.println(new Length(5.0, LengthUnit.FEET).add(new Length(-2.0, LengthUnit.FEET)));

	}
}

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

	public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
		return weight1.equals(weight2);
	}

	public static boolean demonstrateWeightComparison(double value1, WeightUnit unit1, double value2,
			WeightUnit unit2) {
		Weight weight1 = new Weight(value1, unit1);
		Weight weight2 = new Weight(value2, unit2);

		return weight1.equals(weight2);

	}

	public static Weight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
		return new Weight(value, from).convertTo(to);

	}

	public static Weight demonstrateweightConversion(Weight weight, WeightUnit target) {

		return weight.convertTo(target);
	}

	public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {
		return weight1.add(weight2);
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

		// Weight test cases
		System.out.println(new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(2.0, WeightUnit.KILOGRAM)));

		System.out.println(new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(1000.0, WeightUnit.GRAM)));

		System.out.println(new Weight(1000.0, WeightUnit.GRAM).add(new Weight(1.0, WeightUnit.KILOGRAM)));

		System.out.println(new Weight(1.0, WeightUnit.POUND).add(new Weight(16.0, WeightUnit.KILOGRAM)));

		System.out.println(new Weight(16.0, WeightUnit.GRAM).add(new Weight(1.0, WeightUnit.POUND)));

		System.out.println(new Weight(1000.0, WeightUnit.GRAM).add(new Weight(1.0, WeightUnit.KILOGRAM)));

		System.out.println(new Weight(5.0, WeightUnit.KILOGRAM).add(new Weight(0.0, WeightUnit.GRAM)));

		System.out.println(new Weight(5.0, WeightUnit.KILOGRAM).add(new Weight(-2.0, WeightUnit.KILOGRAM)));

	}
}

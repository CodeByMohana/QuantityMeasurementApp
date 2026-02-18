package com.quantitymeasurement.QuantityMeasurementApp;

import java.util.Objects;

public class QuantityMeasurementApp {

	public static class Feet {
		private final double value;

		// Constructor
		public Feet(double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Feet other = (Feet) obj;
			return Double.compare(this.value, other.value) == 0;
		}

	}

	public static class Inches {
		private final double value;

		// Constructor
		public Inches(double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Inches other = (Inches) obj;
			return Double.compare(this.value, other.value) == 0;
		}
	}

	public static void demonstrateFeetEquality() {
		Feet value1 = new Feet(1.0);
		Feet value2 = new Feet(1.0);

		System.out.println(value1.equals(value2)); // true
	}

	public static void demonstrateInchesEquality() {
		Inches value1 = new Inches(1.0);
		Inches value2 = new Inches(1.0);

		System.out.println(value1.equals(value2)); // true
	}

	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
	}
}

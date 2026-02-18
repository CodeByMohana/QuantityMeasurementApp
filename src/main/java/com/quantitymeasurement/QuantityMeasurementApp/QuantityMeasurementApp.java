package com.quantitymeasurement.QuantityMeasurementApp;

import java.util.Objects;

/**
 * Hello world!
 *
 */
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

	public static void main(String[] args) {

		Feet value1 = new Feet(1.0);
		Feet value2 = new Feet(1.0);

		System.out.println(value1.equals(value2)); // true
	}
}

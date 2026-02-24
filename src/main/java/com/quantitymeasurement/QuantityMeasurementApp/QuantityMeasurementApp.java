package com.quantitymeasurement.QuantityMeasurementApp;

public class QuantityMeasurementApp {
	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			// Check if both references point to the same object
			if (this == obj)
				return true;

			// Check if the object is null or of different class
			if (obj == null || getClass() != obj.getClass())
				return false;
			;

			// Safe casting
			Feet other = (Feet) obj;

			return Double.compare(this.value, other.value) == 0;
		}

	}

	public static void main(String[] args) {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(1.0);

		System.out.println(feet1.equals(feet2));
	}
}
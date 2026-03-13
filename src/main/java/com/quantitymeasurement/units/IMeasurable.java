package com.quantitymeasurement.units;

@FunctionalInterface
interface SupportsArithmetic {
	boolean isSupported();
}

public interface IMeasurable {

	SupportsArithmetic supportArithmetic = () -> true;

	double getConversionFactor();

	double convertToBaseUnit(double value);

	double convertFromBaseUnit(double baseValue);

	String getUnitName();

	default boolean supportArithmetic() {
		return supportArithmetic.isSupported();
	}
	
	default void validateOperationSupport(String operation) {
		
	}
}

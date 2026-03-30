package com.app.quantitymeasurement.unit;

/**
 * Interface for all measurable units.
 */
public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    /**
     * Default: all units support arithmetic
     */
    default void validateOperationSupport(String operation) {
        // Default → allow all
    }
}
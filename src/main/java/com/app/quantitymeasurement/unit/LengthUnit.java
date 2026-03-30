package com.app.quantitymeasurement.unit;

public enum LengthUnit implements IMeasurable {

    FEET(12),
    INCHES(1),
    YARDS(36),
    CENTIMETERS(0.393701),
    METERS(39.3701);

    private final double toBaseFactor; // base = inches

    LengthUnit(double factor) {
        this.toBaseFactor = factor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toBaseFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
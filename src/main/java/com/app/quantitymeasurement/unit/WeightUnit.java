package com.app.quantitymeasurement.unit;

public enum WeightUnit implements IMeasurable {

    GRAM(1),
    KILOGRAM(1000),
    POUND(453.592),
    OUNCE(28.3495);

    private final double factor; // base = gram

    WeightUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
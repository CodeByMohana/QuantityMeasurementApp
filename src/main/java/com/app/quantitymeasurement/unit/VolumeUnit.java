package com.app.quantitymeasurement.unit;

public enum VolumeUnit implements IMeasurable {

    LITER(1),
    MILLILITER(0.001),
    GALLON(3.78541);

    private final double factor; // base = liter

    VolumeUnit(double factor) {
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
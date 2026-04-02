package com.app.quantitymeasurement.unit;

import java.util.Objects;

public final class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // ---------------------------
    // CONVERT
    // ---------------------------
    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    // ---------------------------
    // ADD
    // ---------------------------
    public Quantity<U> add(Quantity<U> other) {
        unit.validateOperationSupport("ADD");

        double result = base(this) + base(other);
        return new Quantity<>(round(unit.convertFromBaseUnit(result)), unit);
    }

    // ---------------------------
    // SUBTRACT
    // ---------------------------
    public Quantity<U> subtract(Quantity<U> other) {
        unit.validateOperationSupport("SUBTRACT");

        double result = base(this) - base(other);
        return new Quantity<>(round(unit.convertFromBaseUnit(result)), unit);
    }

    // ---------------------------
    // DIVIDE
    // ---------------------------
    public double divide(Quantity<U> other) {
        unit.validateOperationSupport("DIVIDE");

        double divisor = base(other);
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return round(base(this) / divisor);
    }

    // ---------------------------
    // EQUALITY
    // ---------------------------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass())) return false;

        return Double.compare(round(base(this)), round(base((Quantity<U>) other))) == 0;
    }

    private double base(Quantity<U> q) {
        return q.unit.convertToBaseUnit(q.value);
    }

    private double round(double v) {
        return Math.round(v * 1000.0) / 1000.0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round(base(this)), unit.getClass());
    }
}
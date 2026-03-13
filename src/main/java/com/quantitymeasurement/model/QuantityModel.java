package com.quantitymeasurement.model;

import com.quantitymeasurement.units.IMeasurable;

public class QuantityModel<U extends IMeasurable> {

	private Quantity<U> quantity;

	public QuantityModel(Quantity<U> quantity) {
		this.quantity = quantity;
	}

	public Quantity<U> getQuantity() {
		return quantity;
	}
}

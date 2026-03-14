package com.quantitymeasurement.entity;

import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.unit.IMeasurable;

public class QuantityModel<U extends IMeasurable> {

	private Quantity<U> quantity;

	public QuantityModel(Quantity<U> quantity) {
		this.quantity = quantity;
	}

	public Quantity<U> getQuantity() {
		return quantity;
	}
}

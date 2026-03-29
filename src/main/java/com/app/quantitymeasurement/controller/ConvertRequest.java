package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.entity.QuantityDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertRequest {
	private QuantityDTO quantity;
	private String targetUnit;
}
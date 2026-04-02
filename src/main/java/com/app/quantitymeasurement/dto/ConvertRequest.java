package com.app.quantitymeasurement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertRequest {
	private QuantityDTO quantity;
	private String targetUnit;
}
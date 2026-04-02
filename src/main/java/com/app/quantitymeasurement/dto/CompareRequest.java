package com.app.quantitymeasurement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompareRequest {
    private QuantityDTO q1;
    private QuantityDTO q2;
}
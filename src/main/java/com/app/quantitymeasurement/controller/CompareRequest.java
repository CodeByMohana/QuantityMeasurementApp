package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.entity.QuantityDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompareRequest {
    private QuantityDTO q1;
    private QuantityDTO q2;
}
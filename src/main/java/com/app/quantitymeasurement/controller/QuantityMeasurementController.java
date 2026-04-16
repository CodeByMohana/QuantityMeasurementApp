package com.app.quantitymeasurement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.quantitymeasurement.dto.CompareRequest;
import com.app.quantitymeasurement.dto.ConvertRequest;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

	private final IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	// ---------------------------
	// COMPARE
	// ---------------------------
	@PostMapping("/compare")
	public ResponseEntity<Boolean> compare(@Valid @RequestBody CompareRequest request) {

		boolean result = service.compare(request.getQ1(), request.getQ2());

		return ResponseEntity.ok(result);
	}

	// ---------------------------
	// CONVERT
	// ---------------------------
	@PostMapping("/convert")
	public ResponseEntity<QuantityDTO> convert(@Valid @RequestBody ConvertRequest request) {

		QuantityDTO result = service.convert(request.getQuantity(), request.getTargetUnit());

		return ResponseEntity.ok(result);
	}

	// ---------------------------
	// ADD
	// ---------------------------
	@PostMapping("/add")
	public ResponseEntity<QuantityDTO> add(@Valid @RequestBody CompareRequest request) {

		QuantityDTO result = service.add(request.getQ1(), request.getQ2());

		return ResponseEntity.ok(result);
	}

	// ---------------------------
	// SUBTRACT
	// ---------------------------
	@PostMapping("/subtract")
	public ResponseEntity<QuantityDTO> subtract(@Valid @RequestBody CompareRequest request) {

		QuantityDTO result = service.subtract(request.getQ1(), request.getQ2());

		return ResponseEntity.ok(result);
	}

	// ---------------------------
	// DIVIDE
	// ---------------------------
	@PostMapping("/divide")
	public ResponseEntity<Double> divide(@Valid @RequestBody CompareRequest request) {

		double result = service.divide(request.getQ1(), request.getQ2());

		return ResponseEntity.ok(result);
	}

	// ---------------------------
	// HISTORY
	// ---------------------------
	@GetMapping("/history")
	public ResponseEntity<java.util.List<com.app.quantitymeasurement.entity.QuantityMeasurementEntity>> getHistory() {
		return ResponseEntity.ok(service.getHistory());
	}
}
package com.quantitymeasurement.controller;

import java.util.Scanner;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

	private final IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	public void handleUserOperation(int choice, Scanner scanner) {

		System.out.print("Enter value: ");
		double value = scanner.nextDouble();

		System.out.print("Enter unit: ");
		String unit = scanner.next();

		System.out.print("Enter measurement type: ");
		String type = scanner.next();

		QuantityDTO q1 = new QuantityDTO(value, unit, type);

		switch (choice) {

		case 1 -> {

			System.out.print("Enter second value: ");
			double v2 = scanner.nextDouble();

			System.out.print("Enter second unit: ");
			String u2 = scanner.next();

			QuantityDTO q2 = new QuantityDTO(v2, u2, type);

			boolean result = service.compare(q1, q2);

			System.out.println("Equal: " + result);
		}

		case 2 -> {

			System.out.print("Enter target unit: ");
			String target = scanner.next();

			QuantityDTO result = service.convert(q1, target);

			System.out.println("Converted: " + result);
		}

		case 3 -> {

			System.out.print("Enter second value: ");
			double v2 = scanner.nextDouble();

			System.out.print("Enter second unit: ");
			String u2 = scanner.next();

			QuantityDTO q2 = new QuantityDTO(v2, u2, type);

			System.out.println(service.add(q1, q2));
		}

		case 4 -> {

			System.out.print("Enter second value: ");
			double v2 = scanner.nextDouble();

			System.out.print("Enter second unit: ");
			String u2 = scanner.next();

			QuantityDTO q2 = new QuantityDTO(v2, u2, type);

			System.out.println(service.subtract(q1, q2));
		}

		case 5 -> {

			System.out.print("Enter second value: ");
			double v2 = scanner.nextDouble();

			System.out.print("Enter second unit: ");
			String u2 = scanner.next();

			QuantityDTO q2 = new QuantityDTO(v2, u2, type);

			System.out.println("Result: " + service.divide(q1, q2));
		}
		}
	}
}
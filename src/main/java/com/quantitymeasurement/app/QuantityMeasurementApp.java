package com.quantitymeasurement.app;

import java.util.Scanner;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import com.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.util.DatabaseInitializer;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

		DatabaseInitializer.initializeDatabase();

		IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();

		IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repository);

		QuantityMeasurementController controller = new QuantityMeasurementController(service);

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("\nSelect Operation:");
			System.out.println("1. Compare");
			System.out.println("2. Convert");
			System.out.println("3. Add");
			System.out.println("4. Subtract");
			System.out.println("5. Divide");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();

			if (choice == 6)
				break;

			controller.handleUserOperation(choice, scanner);
		}

		scanner.close();
	}
}
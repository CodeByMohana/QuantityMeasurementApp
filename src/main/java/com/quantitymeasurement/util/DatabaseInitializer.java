package com.quantitymeasurement.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void initializeDatabase() {

		try (Connection conn = ConnectionPool.getConnection(); Statement stmt = conn.createStatement()) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					DatabaseInitializer.class.getClassLoader().getResourceAsStream("db/schema.sql")));

			StringBuilder sql = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				sql.append(line);
			}

			stmt.execute(sql.toString());

			System.out.println("Database schema initialized.");

		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize database", e);
		}
	}
}
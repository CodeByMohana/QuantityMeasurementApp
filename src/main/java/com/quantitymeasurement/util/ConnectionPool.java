package com.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(ApplicationConfig.get("db.url"), ApplicationConfig.get("db.username"),
					ApplicationConfig.get("db.password"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

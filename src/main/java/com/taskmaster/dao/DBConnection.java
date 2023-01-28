package com.taskmaster.dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

/*
 * This is the database connection class. It will be setting the username, password and connection to the database. 
 * This class utilizes the singleton pattern to ensure only one instance of the connection is made to the database.
 * This helps to ensure global control of the resource.   
 * 
 * 
 */

public class DBConnection {

	private static DBConnection instance;
	private static final String dbUser = "root";
	private static final String dbPassword = "password";
	private static final String conString = "jdbc:mysql://localhost:3309/taskmaster";
	private Connection connection;

	private DBConnection() throws SQLException {
		try {

			
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(conString, dbUser, dbPassword);
			System.out.println("Connection made to database!");

		} catch (ClassNotFoundException e) {

			System.out.println("Something is wrong with the database connection: " + e.getMessage());

		}
	}

	public Connection getConnection() {

		return connection;
	}

	public static DBConnection getInstance() throws SQLException {

		if (instance == null) {

			instance = new DBConnection();

		} else if (instance.getConnection().isClosed()) {

			instance = new DBConnection();
		}

		return instance;
	}

}
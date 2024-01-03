package com.zsgs.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.zsgs.taxiViewmodel.TaxiViewModel;
import com.zsgs.booktaxi.BookTaxiViewModel;
import com.zsgs.dto.Taxi;

public class TaxiModel {
	private List<Taxi> taxis;
	TaxiViewModel taxiViewModel;
	BookTaxiViewModel bookTaxiViewModel;
	private static final String URL = "jdbc:mysql://localhost:3306/taxi";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public TaxiModel(TaxiViewModel taxiViewModel) {
		taxis = new ArrayList<>();
		this.taxiViewModel = taxiViewModel;
//		initializeDatabase();

	}

//	private void initializeDatabase() {
//		try {
//			// Register JDBC driver
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// Open a connection
//			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//
//			// Create a table if not exists
//			String createTableSQL = "CREATE TABLE IF NOT EXISTS taxis "
//					+ "(id INT PRIMARY KEY, booked BOOLEAN, currentSpot CHAR, freeTime INT, totalEarnings INT)";
//			try (Statement statement = connection.createStatement()) {
//				statement.executeUpdate(createTableSQL);
//			}
//
//			// Close the connection
//			connection.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void initializeTaxis(boolean b, char nextSpot, int nextfreeTime, int i, String tripDetail)
//			throws SQLException {
//
//		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//		for (int j = 0; j < 4; j++) {
//			String insertTaxiSQL = "INSERT INTO taxis (id, booked, currentSpot, freeTime, totalEarnings) "
//					+ "VALUES (?, ?, ?, ?, ?)";
//
//			try (PreparedStatement preparedStatement = connection.prepareStatement(insertTaxiSQL)) {
//				preparedStatement.setInt(1, i + 1);
//				preparedStatement.setBoolean(2, false);
//				preparedStatement.setString(3, "A");
//				preparedStatement.setInt(4, 6);
//				preparedStatement.setInt(5, 0);
//				preparedStatement.executeUpdate();
//			}
//
//		}
//		Taxi taxi = new Taxi();
//		taxis.add(taxi);
//
//	}

	public TaxiModel(BookTaxiViewModel bookTaxiViewModel) {
		this.bookTaxiViewModel = bookTaxiViewModel;
		taxis = new ArrayList<>();

	}

	public List<Taxi> getTaxis() {
		return taxis;
	}

	public List<Taxi> createTaxi() {
		// TODO Auto-generated method stub
		List<Taxi> taxiList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Taxi taxi = new Taxi();
			taxiList.add(taxi);
		}
		return taxiList;
//		return taxis;
	}

}

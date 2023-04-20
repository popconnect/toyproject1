package com.personal.juice.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeverageInserter {
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/toyproject";
	private static final String USER = "toyproject";
	private static final String PASS = "toyprojectpw";

	private String beverage;
	private String type;
	private String brand;
	private int calories;
	private double servingSize;
	private int caffeine;

	public BeverageInserter(String beverage, String type, String brand, int calories, double servingSize,
			int caffeine) {
		this.beverage = beverage;
		this.type = type;
		this.brand = brand;
		this.calories = calories;
		this.servingSize = servingSize;
		this.caffeine = caffeine;
	}

	public void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "INSERT INTO beverages (beverage, type, brand, calories, serving_size, caffeine) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, beverage);
			pstmt.setString(2, type);
			pstmt.setString(3, brand);
			pstmt.setInt(4, calories);
			pstmt.setDouble(5, servingSize);
			pstmt.setInt(6, caffeine);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
package com.personal.juice.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeverageUpdater {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/toyproject";
	private static final String USER = "toyproject";
	private static final String PASS = "toyprojectpw";
	private String id;
	private String beverage;
	private String type;
	private String brand;
	private String calories;
	private String servingSize;
	private String caffeine;
	
	public BeverageUpdater(String beverage, String type, String brand, String calories, String servingSize,
			String caffeine, String id) {
		this.beverage = beverage;
		this.type = type;
		this.brand = brand;
		this.calories = calories;
		this.servingSize = servingSize;
		this.caffeine = caffeine;
		this.id = id;
	}
	
	public void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "UPDATE beverages SET beverage = ?, type = ?, brand = ?, calories = ?, serving_size = ?, caffeine = ? WHERE id = ?";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, beverage);
			pstmt.setString(2, type);
			pstmt.setString(3, brand);
			pstmt.setString(4, calories);
			pstmt.setString(5, servingSize);
			pstmt.setString(6, caffeine);
			pstmt.setString(7, id);
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


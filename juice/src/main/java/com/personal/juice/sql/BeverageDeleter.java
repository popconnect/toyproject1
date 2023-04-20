package com.personal.juice.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeverageDeleter {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/toyproject";
	private static final String USER = "toyproject";
	private static final String PASS = "toyprojectpw";
	private String id;
	
	public BeverageDeleter(String id) {
		this.id = id;
	}
	
	public void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "DELETE FROM beverages WHERE id = ?";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
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


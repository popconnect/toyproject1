package com.personal.juice.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.personal.juice.swing.RegisterManager;

public class RegisterController {
	 private final String driver = "org.mariadb.jdbc.Driver";
	 private final String url = "jdbc:mariadb://localhost:3306/toyproject";
	 private final String user = "toyproject"; 
	 private final String password = "toyprojectpw"; 
	    
	 private Connection conn;
	 
	 //호출시 데이터 in
	 public void connect() {
	    try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 //호출시 데이터 out
	 public void disconnect() {
	        try {
	            conn.close();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 public void insertData(String id, String pw, String jb, String nm) {
		    try {
		        // Account 테이블에 데이터 추가
		        String accountQuery = "INSERT INTO Account (id, password, email, name) VALUES (?, ?, ?, ?)";
		        PreparedStatement accountPstmt = conn.prepareStatement(accountQuery);
		        accountPstmt.setString(1, id);
		        accountPstmt.setString(2, pw);
		        accountPstmt.setString(3, jb);
		        accountPstmt.setString(4, nm);

		        int accountResult = accountPstmt.executeUpdate();

		        // Member 테이블에 데이터 추가
		        String memberQuery = "INSERT INTO Member (id) VALUES (?)";
		        PreparedStatement memberPstmt = conn.prepareStatement(memberQuery);
		        memberPstmt.setString(1, id);
		       

		        int memberResult = memberPstmt.executeUpdate();
		        
		        if (accountResult == 1 && memberResult == 1) {
		        	JOptionPane.showMessageDialog(null, "계정 생성이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		        	
		        }
		        
		    } catch (SQLException e) {
		    	JOptionPane.showMessageDialog(null, "계정 생성에 실패하였습니다.\n" + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
		    	
		    }
		}

}
	        
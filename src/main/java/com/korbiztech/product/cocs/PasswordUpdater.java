package com.korbiztech.product.cocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.korbiztech.product.cocs.COM.util.SecurityUtil;

public class PasswordUpdater {

	/* 1. TEST 컬럼을 ADD
	 * 2. checkConnection 메소드를 이용해 DB 연결 확인
	 * 3. updateTestColumn 메소드를 이용해 TEST 컬럼으로 암호화 된 값을 생성
	 * 4. applyHashedPasswords 메소드를 이용해 TEST 컬럼의 값을 암호화가 필요한 컬럼으로 변경
	 */
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@121.167.219.232:1522:XE";
		String user = "CWCON";
		String password = "1234";
		
		//checkConnection(url, user, password);
		//updateTestColumn(url, user, password);
		//applyHashedPasswords(url, user, password);
	}

	public static void checkConnection(String url, String user, String password) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			System.out.println("DB Connection established.");
		} catch (SQLException e) {
			System.out.println("An SQL Exception occurred: " + e.getMessage());
		}
	}

	public static void updateTestColumn(String url, String user, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			System.out.println("Updating TEST column for testing purposes.");

			PreparedStatement selectStmt = conn.prepareStatement("SELECT USERS_ID, USERS_PW FROM SYTB0100");
			ResultSet rs = selectStmt.executeQuery();
			PreparedStatement updateStmt = conn.prepareStatement("UPDATE SYTB0100 SET TEST = ? WHERE USERS_ID = ?");

			while (rs.next()) {
			    String id = rs.getString("USERS_ID");
			    String originalPassword = rs.getString("USERS_PW");

			    String hashedPassword = SecurityUtil.encodePasswordWithBCrypt(originalPassword);

			    updateStmt.setString(1, hashedPassword);
			    updateStmt.setString(2, id);

			    updateStmt.executeUpdate();
			}
			conn.commit();
			System.out.println("TEST column updated successfully!");

		} catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());

			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("Transaction rolled back.");
				} catch (SQLException ex) {
					System.out.println("Failed to rollback the transaction: " + ex.getMessage());
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Failed to close the connection: " + e.getMessage());
				}
			}
		}
	}

	public static void applyHashedPasswords(String url, String user, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);

			System.out.println("Applying hashed passwords.");

			PreparedStatement selectStmt = conn.prepareStatement("SELECT USERS_ID, USERS_PW, TEST FROM SYTB0100");
			ResultSet rs = selectStmt.executeQuery();

			PreparedStatement updatePwStmt = conn.prepareStatement("UPDATE SYTB0100 SET USERS_PW = ? WHERE USERS_ID = ?");
			PreparedStatement updateTestStmt = conn.prepareStatement("UPDATE SYTB0100 SET TEST = ? WHERE USERS_ID = ?");
			
			while (rs.next()) {
				String id = rs.getString("USERS_ID");
				String originalPassword = rs.getString("USERS_PW");
				String testPassword = rs.getString("TEST");

				if (testPassword != null) {
					updatePwStmt.setString(1, testPassword);
					updatePwStmt.setString(2, id);
					updatePwStmt.executeUpdate();
					System.out.println("Updated USERS_PW for id: " + id);
				}

				if (originalPassword != null && testPassword == null) {
					updateTestStmt.setString(1, originalPassword);
					updateTestStmt.setString(2, id);
					updateTestStmt.executeUpdate();
					System.out.println("Updated TEST for id: " + id);
				}
			}

			conn.commit();
			System.out.println("Hashed passwords applied successfully!");
			
		} catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());
			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("Transaction rolled back.");
				} catch (SQLException ex) {
					System.out.println("Failed to rollback the transaction: " + ex.getMessage());
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Failed to close the connection: " + e.getMessage());
				}
			}
		}
	}

}

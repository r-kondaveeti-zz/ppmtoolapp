package com.yash.ppmtoolapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * This JDBCUtil will be used for performing databased related operations like
 * Driver loader, connection handling, and getting PreparedStatement objects
 * @author nolanschoenle
 *
 */
public class JDBCUtil {

		private static final String URL = "jdbc:mysql://gtp-2019-ppmtoolapp.cop25g5tba8w.us-east-2.rds.amazonaws.com:3306/ppmtoolappdb"; //Update to match new DB
//		private static final String TIMEZONEFIX = "?useTimezone=true&serverTimezone=UTC";
		private static final String USER = "group3";
		private static final String PASS = "group3group3";
		protected Connection con = null;

		protected PreparedStatement pstmt = null;
		
		static {
			String driverClassName = "com.mysql.cj.jdbc.Driver";
			try {
				Class c = Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		
		public Connection connect() {
			try {
				con = DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		
		public PreparedStatement createPreparedStatement(String sql) {
			try {
				connect();
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pstmt;
		}


		public void releaseResources() {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}

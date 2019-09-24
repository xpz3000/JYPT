

package com.jypt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
//1driver  2url 3 username 4pwd
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/shixunjdbc";
	private static final String username = "root";
	private static final String password = "";
//getconn
	public static Connection  getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
		   conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
//close
	
	public static void closeResource(Connection conn, PreparedStatement psment,Statement stmt,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(psment!=null){
				psment.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

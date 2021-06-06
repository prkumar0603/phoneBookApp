package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	static String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	static String user = "scott";
	static String pass = "tiger";
	
	public static Connection getConn(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			// System.out.println("driver is loaded successfully");
			
			conn = DriverManager.getConnection(url, user, pass);
			// System.out.println("Connection is successfull with driver"+conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}

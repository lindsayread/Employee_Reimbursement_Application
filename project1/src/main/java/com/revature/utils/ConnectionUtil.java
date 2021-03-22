package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil cu = null;
	private static Properties prop;
	
	private String url;
	private String username;
	private String password;
	
	private static Connection con;
	/**
	 * This method should read in the "database.properties" file and load
	 * the values into the Properties variable
	 */
	private ConnectionUtil() {
		ClassLoader clo = getClass().getClassLoader();
		InputStream is = clo.getResourceAsStream("jdbc.properties");
		prop = new Properties();
		
		try {
			prop.load(is);
			this.url = (String) prop.getProperty("url");
			this.username = (String) prop.getProperty("uname");
			this.password = (String) prop.getProperty("pword");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(cu == null)
			cu = new ConnectionUtil();
		return cu;
	}
	
	/**
	 * This method should create and return a Connection object
	 * @return a Connection to the database
	 */
	public Connection getConnection() {
		// Hint: use the Properties variable to setup your Connection object
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}

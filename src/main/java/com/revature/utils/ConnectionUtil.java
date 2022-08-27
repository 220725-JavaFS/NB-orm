package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	//attempting to make variables for the connectionUtil?
	public static Connection getConnection(String connectionURL, String connectionUN, String connectionPW, String driverName) throws SQLException {
		if (connection!=null && !connection.isClosed()) { //this makes it a singleton connection
			return connection;
		}else {
			
			//For many frameworks, or cases where there are multiple SQL drivers, you will need to register which
			//Driver you are using for the connection interface. The Class.forName method will allow you to do this.
			//This step is often redundant or often unnecessary for simple projects but is considered best practice.
			
			try {
				Class.forName(driverName);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url = connectionURL;
			String username = connectionUN;
			String password = connectionPW;
			
			//Unsure if I need to run environment variables or just use these. Will ask Pablo or Tim
			
			connection = DriverManager.getConnection(url, username, password);
			
			return connection;
		}
	}

}

package com.edp.luma.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection
			("jdbc:mariadb://localhost/java?user=root&password=");
	}
}

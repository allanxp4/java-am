package com.edp.luma.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection
			("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
			"login","senha");
	}
}

package com.zoopla.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public Connection getdbconnection(String databasename) throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;Database=" + databasename;
		String username = "sa";
		String pwd = "tiger";
		return DriverManager.getConnection(url, username, pwd);

	}

}

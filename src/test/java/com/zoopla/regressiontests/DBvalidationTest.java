package com.zoopla.regressiontests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.zoopla.utilities.DatabaseConnector;

public class DBvalidationTest {

	@Test
	public void displayemptable() throws Exception {
		DatabaseConnector DatabaseConnectorref = new DatabaseConnector();
		String databasename = "companydata";
		Connection con = DatabaseConnectorref.getdbconnection(databasename);
		Statement stmt = con.createStatement();

		String query = "select * from emp";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String empid = rs.getString("empname");

			System.out.println(empid);

		}
		
		stmt.close();
		con.close();

	}

}

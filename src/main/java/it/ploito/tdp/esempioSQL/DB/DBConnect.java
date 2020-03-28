package it.ploito.tdp.esempioSQL.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect { // Non ci metto il public, perche' nessuno al di fuori del package DB deve mai chiamare DBConnect
	
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		return DriverManager.getConnection(jdbcURL);
	}
}

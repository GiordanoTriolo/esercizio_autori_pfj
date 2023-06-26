package it.betacom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

public Connection creaConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/esercizio2";
	    String username = "root";
	    String password = "giordanotriolo";
	    
	    try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	    
	    return connection;
}}

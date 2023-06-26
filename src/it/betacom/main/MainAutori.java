package it.betacom.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.connection.DBConnection;

public class MainAutori {

	public static void main(String[] args) {

		DBConnection db = new DBConnection();
		Connection connection = db.creaConnection();

		 try {
	            String callProcedure = "CALL get_age_autori_nazione(?)";
	            CallableStatement statement = connection.prepareCall(callProcedure);
	            statement.setString(1, "Italia");
	            statement.execute();

	            String selectQuery = "SELECT nome, cognome, eta FROM autori_eta_temp";
	            Statement selectStatement = connection.createStatement();
	            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

	            while (resultSet.next()) {
	                String nome = resultSet.getString("nome");
	                String cognome = resultSet.getString("cognome");
	                int eta = resultSet.getInt("eta");

	                System.out.println("Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta);
	            }

	            resultSet.close();
	            selectStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }		
	}
}

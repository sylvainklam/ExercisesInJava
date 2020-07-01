package sdk.exercises.fr.paris.pise.tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	/**
	 * Question 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Connecting ...");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost", "root", "");
			System.out.println("Connected successfully!!");
			System.out.println("Creating database...");

			String sqlCreateDatabase = "create database tp8;";
			stmt = conn.createStatement();
			stmt.execute(sqlCreateDatabase);
			System.out.println("Database created.");

			System.out.println("Creating tables in database...");

			String sqlUseDatabase = "use tp8;";
			String sqlCreateTableVoiture = "create table voiture (marque varchar(20),modele varchar(20), annee int(4));";
			String sqlCreateTableUtilitaire = "create table utilitaire (marque varchar(20),modele varchar(20), annee int(4), capacite int(2));";

			stmt.execute(sqlUseDatabase);
			stmt.execute(sqlCreateTableVoiture);
			stmt.execute(sqlCreateTableUtilitaire);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

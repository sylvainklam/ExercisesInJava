package sdk.exercises.fr.paris.pise.tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question 4
 * 
 * @author test
 *
 */

public class CreateVehicule {

	/**
	 * Liste de véhicule
	 */
	private List<Vehicule> listVehicule = new ArrayList<>();

	/**
	 * Création d'une voiture
	 * 
	 * @param scanner
	 */
	private void creerVoiture(Scanner scanner) {
		System.out.print("Marque : ");
		String marque = scanner.next();
		System.out.print("Modele : ");
		String modele = scanner.next();
		System.out.print("Annee : ");
		int annee = scanner.nextInt();

		Voiture v = new Voiture(marque, modele, annee);
		listVehicule.add(v);
	}

	/**
	 * Création d'un utilitaire
	 * 
	 * @param scanner
	 */
	private void creerUtilitaire(Scanner scanner) {
		System.out.print("Marque : ");
		String marque = scanner.next();
		System.out.print("Modele : ");
		String modele = scanner.next();
		System.out.print("Annee : ");
		int annee = scanner.nextInt();
		System.out.print("Capacité : ");
		int capacite = scanner.nextInt();

		Utilitaire u = new Utilitaire(marque, modele, annee, capacite);
		listVehicule.add(u);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CreateVehicule createVehicule = new CreateVehicule();
		int choix = -1;
		do {
			System.out.println("1 - Créer une voiture");
			System.out.println("2 - Créer un utilitaire");
			System.out.println("3 - Voir la liste");
			System.out.println("4 - Insérer les véhicules en base");
			System.out.println("5 - Effacer la liste");
			System.out.println("6 - Lire le contenu de la base");
			System.out.println("0 - Quitter");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				createVehicule.creerVoiture(scanner);
				break;
			case 2:
				createVehicule.creerUtilitaire(scanner);
				break;
			case 3:
				System.out.println(createVehicule.getListVehicule());
				break;
			case 4:
				createVehicule(createVehicule.getListVehicule());
				break;
			case 5:
				createVehicule.getListVehicule().clear();
				break;
			case 6:
				System.out.println(createVehicule.getListVehiculeFromDB());
				break;
			}
		} while (choix != 0);
		scanner.close();
	}

	private List<Vehicule> getListVehiculeFromDB() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/tp8", "root", "");
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from voiture;");
			while (rs.next()) {
				Voiture v = new Voiture(rs.getString("marque"), rs.getString("modele"), rs.getInt("annee"));
				vehicules.add(v);
			}

			ResultSet rsUtilitaire = stmt.executeQuery("select * from utilitaire;");
			while (rsUtilitaire.next()) {
				Utilitaire v = new Utilitaire(rsUtilitaire.getString("marque"), rsUtilitaire.getString("modele"),
						rsUtilitaire.getInt("annee"), rsUtilitaire.getInt("capacite"));
				vehicules.add(v);
			}
		} catch (SQLException e) {
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
		return vehicules;

	}

	private static void createVehicule(List<Vehicule> listVehicule2) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/tp8", "root", "");
			stmt = conn.createStatement();
			for (Vehicule v : listVehicule2) {
				String sqlInsert = "";
				if (v instanceof Voiture) {
					Voiture voiture = (Voiture) v;
					sqlInsert = voiture.createInsertStatement();
				} else {
					Utilitaire utilitaire = (Utilitaire) v;
					sqlInsert = utilitaire.createInsertStatement();
				}
				stmt.execute(sqlInsert);
			}
		} catch (SQLException e) {
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

	public List<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(List<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}
}

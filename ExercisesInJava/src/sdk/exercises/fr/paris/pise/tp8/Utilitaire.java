package sdk.exercises.fr.paris.pise.tp8;

import java.util.Random;

@SuppressWarnings("serial")
public class Utilitaire extends Voiture {

	private int capacite;

	public Utilitaire() {

	}

	public Utilitaire(String marque, String modele, int annee, int capacite) {
		setMarque(marque);
		setModele(modele);
		setAnnee(annee);
		setCapacite(capacite);
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getRandomCapacite() {
		Random random = new Random();
		return random.nextInt(10);
	}

	/**
	 * Question 3
	 */
	public String createInsertStatement() {
		String sqlInsert = "insert into utilitaire (annee,capacite,marque,modele) values (" + getAnnee() + ","
				+ getCapacite() + ",'" + getMarque() + "','" + getModele() + "');";
		return sqlInsert;
	}
}

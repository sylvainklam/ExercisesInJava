package sdk.exercises.fr.paris.pise.tp3.banque;

import java.util.ArrayList;
import java.util.List;

/**
 * Cr�er une classe CompteEnBanque sur lesquels il est permis de d�poser,
 * retirer une certaine somme et d�terminer combien il y a sur le compte en
 * banque. L�op�ration de retrait devra v�rifier que le compte en banque est
 * suffisamment garni, et si l�op�ration est possible renverra true et false
 * sinon
 * 
 * @author SKLAM
 *
 */

public class CompteEnBanque {

	static List<CompteEnBanque> compteEnBanques = new ArrayList<CompteEnBanque>();

	private double solde;

	public void deposer(double somme) {
		solde += somme;
	}

	public boolean retirer(double somme) {
		return (somme > solde ? false : true); // Op�rateur Ternaire En Java - booleanExpression ? expression1 :
												// expression2
	}

	public double getSolde() {
		return solde;
	}

	public static List<CompteEnBanque> getComptesEnBanque() {
		return compteEnBanques;
	}

	public static void afficheTousLesComptes() {
		for (CompteEnBanque compteEnBanque : getComptesEnBanque()) {
			System.out.println(compteEnBanque);
		}
	}
}

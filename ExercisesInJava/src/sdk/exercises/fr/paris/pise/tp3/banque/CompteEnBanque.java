package sdk.exercises.fr.paris.pise.tp3.banque;

import java.util.ArrayList;
import java.util.List;

/**
 * Créer une classe CompteEnBanque sur lesquels il est permis de déposer,
 * retirer une certaine somme et déterminer combien il y a sur le compte en
 * banque. L’opération de retrait devra vérifier que le compte en banque est
 * suffisamment garni, et si l’opération est possible renverra true et false
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
		return (somme > solde ? false : true); // Opérateur Ternaire En Java - booleanExpression ? expression1 :
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

	public String toString() {
		return " -> " + getSolde();
	}
}

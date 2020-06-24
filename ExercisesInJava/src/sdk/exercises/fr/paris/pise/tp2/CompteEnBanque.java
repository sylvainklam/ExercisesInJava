package sdk.exercises.fr.paris.pise.tp2;

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

	private double solde;

	public void deposer(double somme) {
		solde += somme;
	}

	public boolean retirer(double somme) {
		return (somme > solde ? false : true); //Opérateur Ternaire En Java - booleanExpression ? expression1 : expression2
	}

	public double getSolde() {
		return solde;
	}
}

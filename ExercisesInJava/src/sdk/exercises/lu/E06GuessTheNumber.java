package sdk.exercises.lu;

import java.util.Scanner;

/**
 * Exercice 6 – Devinez le nombre - Ecrivez un programme qui choisit un nombre
 * entre 1 et 100 au hasard et qui laisse l’utilisateur deviner le nombre
 * correct. A chaque essai le programme lui indiquera si le nombre entré est
 * plus petit ou plus grand que le nombre recherché jusqu’à ce que le nombre
 * correct ait été deviné. Le programme va alors afficher le nombre d’essais
 * dont l’utilisateur avait besoin pour trouver le bon nombre.
 * 
 * @author SKLAM
 *
 */
public class E06GuessTheNumber {

	private static final int MIN = 1;
	private static final int MAX = 100;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int d = (int) Math.round(Math.random() * (MAX - MIN));
		int nbSaisi = -1;
		int nbEssai = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Entrez un nombre : ");
			nbSaisi = scanner.nextInt();
			if (nbSaisi < d)
				System.out.println("Le nombre à deviner est plus grand");
			if (nbSaisi > d)
				System.out.println("Le nombre à deviner est plus petit");
			nbEssai++;
		} while (nbSaisi != d);
		System.out.println("Bravo ! Nombre d'essai : " + nbEssai);
	}
}

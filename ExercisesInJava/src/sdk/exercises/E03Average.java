package sdk.exercises;

import java.util.Scanner;

/**
 * Exercice 3 � Moyenne - Ecrivez un programme qui calcule la moyenne d�une
 * suite de nombres lus de la console. Si l�utilisateur entre le nombre 0, le
 * programme va arr�ter de lire des nombres et va afficher la moyenne des
 * nombres entr�s.
 * 
 * @author SKLAM
 *
 */

public class E03Average {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n = -1, cpt = 0, sum = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Entrez un nombre : ");
			n = scanner.nextInt();
			if (n != 0)
				cpt++;
			sum += n;
		} while (n != 0);
		System.out.println("R�sultat : " + (sum / cpt));
	}
}

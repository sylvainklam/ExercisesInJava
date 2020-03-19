package sdk.exercises;

import java.util.Scanner;

/**
 * Exercice 2 – Somme - Ecrivez un programme qui lit un entier positif n de
 * l’entrée standard et qui calcule la somme de tous les entiers de 1 à n. Tant
 * que l’utilisateur n’a pas entré un entier positif continuez à le lui
 * demander. Calculez la somme de trois façons différentes: en utilisant une
 * boucle for, une boucle while et une boucle do-while.
 * 
 * @author SKLAM
 *
 */
public class E02Sum {

	public static void main(String[] args) {
		int n = -1, sum = 0;
		int j = 1, k = 1;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Entrez un nombre positif : ");
			n = scanner.nextInt();
		} while (n <= 0);
		System.out.println("Boucle FOR");
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("==> Résultat : " + sum);
		sum = 0;
		System.out.println("");
		System.out.println("Boucle WHILE");
		while (j <= n) {
			sum += j;
			j++;
		}
		System.out.println("==> Résultat : " + sum);
		sum = 0;
		System.out.println("");
		System.out.println("Boucle DO WHILE");
		do {
			sum += k;
			k++;
		} while (k <= n);
		System.out.println("==> Résultat : " + sum);
	}
}

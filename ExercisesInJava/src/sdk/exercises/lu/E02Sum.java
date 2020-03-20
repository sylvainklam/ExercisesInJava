package sdk.exercises.lu;

import java.util.Scanner;

/**
 * Exercice 2 � Somme - Ecrivez un programme qui lit un entier positif n de
 * l�entr�e standard et qui calcule la somme de tous les entiers de 1 � n. Tant
 * que l�utilisateur n�a pas entr� un entier positif continuez � le lui
 * demander. Calculez la somme de trois fa�ons diff�rentes: en utilisant une
 * boucle for, une boucle while et une boucle do-while.
 * 
 * @author SKLAM
 *
 */
public class E02Sum {

	@SuppressWarnings("resource")
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
		System.out.println("==> R�sultat : " + sum);
		sum = 0;
		System.out.println("");
		System.out.println("Boucle WHILE");
		while (j <= n) {
			sum += j;
			j++;
		}
		System.out.println("==> R�sultat : " + sum);
		sum = 0;
		System.out.println("");
		System.out.println("Boucle DO WHILE");
		do {
			sum += k;
			k++;
		} while (k <= n);
		System.out.println("==> R�sultat : " + sum);
	}
}

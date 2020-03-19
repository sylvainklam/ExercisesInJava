package sdk.exercises;

import java.util.Scanner;

/**
 * Exercice 4 – Conversion de nombres - Ecrivez un programme qui lit un entier
 * de la console et affiche chaque chiffre du nombre sous forme de texte. Par
 * exemple, si le nombre 314 est lu, la console affichera trois un quatre.
 * 
 * @author SKLAM
 *
 */
public class E04NumberConversion {

	private static final String[] tabUnit = { " zéro", " un", " deux", " trois", " quatre", " cinq", " six", " sept",
			" huit", " neuf" };

	private static String convertNumber(int number) {
		String result = "";
		switch (number) {
		case 0:
			result += tabUnit[0];
			break;
		case 1:
			result += tabUnit[1];
			break;
		case 2:
			result += tabUnit[2];
			break;
		case 3:
			result += tabUnit[3];
			break;
		case 4:
			result += tabUnit[4];
			break;
		case 5:
			result += tabUnit[5];
			break;
		case 6:
			result += tabUnit[6];
			break;
		case 7:
			result += tabUnit[7];
			break;
		case 8:
			result += tabUnit[8];
			break;
		case 9:
			result += tabUnit[9];
			break;
		}
		return result;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String result = "";
		System.out.print("Entrez un nombre : ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n >= 100 && n < 1000) {
			int resultat = n / 100;
			result += convertNumber(resultat);
			int reste = n % 100;
			if (reste >= 10) {
				resultat = reste / 10;
				reste = reste % 10;
				result += convertNumber(resultat);
				result += convertNumber(reste);
			} else {
				result += convertNumber(0);
				result += convertNumber(reste);
			}
		}
		if (n >= 10 && n < 100) {
			int resultat = n / 10;
			int reste = n % 10;
			result += convertNumber(resultat);
			result += convertNumber(reste);
		}
		if (n < 10) {
			result += convertNumber(n);
		}
		System.out.println(result);
	}
}

package sdk.exercises.fr.paris.pise.tp1;

import java.util.Scanner;

/**
 * Écrire un programme permettant de saisir autant de nombres que souhaités, la
 * fin sera indiquée par le nombre -1, et calculer la moyenne olympique (moyenne
 * des valeurs auxquelles on enlève la plus petite et la plus grande des
 * valeurs, les extrêmes).
 * 
 * @author SKLAM
 *
 */
public class E03OlympicAvg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nb, max, min;
		int somme = 0;
		int nbVal = 0;
		System.out.println("Donnez un nombre ");
		nb = sc.nextInt();
		max = min = nb;
		while (nb != -1) {
			nbVal++;
			if (nb > max)
				max = nb;
			if (nb < min)
				min = nb;
			somme = somme + nb;
			System.out.println("Donnez un nombre ");
			nb = sc.nextInt();
		}
		System.out.println(
				"Le nombre le plus élevé (" + max + ") et le nombre le plus bas (" + min + " ) ont été retirés");
		somme = somme - max - min;
		System.out.println("La moyenne olympique est : " + somme / nbVal);
		sc.close();
	}
}
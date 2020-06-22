package sdk.exercises.fr.paris.pise.tp1;

import java.util.Scanner;

/**
 * �crire un programme permettant de saisir autant de nombres que souhait�s, la
 * fin sera indiqu�e par le nombre -1, et calculer la moyenne olympique (moyenne
 * des valeurs auxquelles on enl�ve la plus petite et la plus grande des
 * valeurs, les extr�mes).
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
				"Le nombre le plus �lev� (" + max + ") et le nombre le plus bas (" + min + " ) ont �t� retir�s");
		somme = somme - max - min;
		System.out.println("La moyenne olympique est : " + somme / nbVal);
		sc.close();
	}
}
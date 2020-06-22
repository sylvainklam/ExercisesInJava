package sdk.exercises.fr.paris.pise.tp1;

import java.util.Scanner;

/**
 * �crire un programme permettant de saisir le rayon d�un cercle qui sera
 * consid�r� comme centr� en (0,0); puis de saisir les coordonn�es d�un point et
 * de d�terminer si ce point est � l�int�rieur ou � l�ext�rieur du cercle (avec
 * while) Modifier le programme de sorte que l�on puisse saisir autant de points
 * que l�on souhaite, sachant que le programme terminera si le point saisi est
 * (0,0). Un point P = (x; y) est � l�int�rieur d�un cercle de rayon r centr�e
 * en (0; 0) si x2 + y2 < r2.
 * 
 * @author SKLAM
 *
 */
public class E02Circle {

	public static boolean isInCircle(int x, int y, int rayon) {
		boolean isInCircle = false;
		int rayonDouble = rayon * rayon;
		int sum = (x * x) + (y * y);
		if (sum < rayonDouble)
			isInCircle = true;
		return isInCircle;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y = -1;
		System.out.print("Entrez le rayon du cercle : ");
		int rayon = scanner.nextInt();
		do {
			System.out.print("x : ");
			x = scanner.nextInt();

			System.out.print("y : ");
			y = scanner.nextInt();

			System.out.println("x,y : " + x + "," + y + " - rayon : " + rayon + " ==> " + isInCircle(x, y, rayon));
		} while (x != 0 && y != 0);
		System.out.println("finished!");
		scanner.close();
	}
}

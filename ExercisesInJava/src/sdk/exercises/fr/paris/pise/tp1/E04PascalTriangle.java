package sdk.exercises.fr.paris.pise.tp1;

import java.util.Scanner;

/**
 * �crire un programme permettant d�afficher un triangle pour une hauteur
 * donn�e.
 * 
 * @author sdklm
 *
 */
public class E04PascalTriangle {

	public static void main(String args[]) {
		int r, i, k, number = 1, j;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Rows : ");
		r = scan.nextInt();
		for (i = 0; i < r; i++) {
			for (k = r; k > i; k--) {
				System.out.print(" ");
			}
			number = 1;
			for (j = 0; j <= i; j++) {
				System.out.print("* ");
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
		scan.close();
	}
}
package sdk.exercises;

import java.util.Scanner;

/**
 * Exercice 1 � Le tableau noir #ForLoop Au d�but des �pisodes des The Simpsons,
 * Bart �crit des phrases amusantes sur le tableau (Figure 1). Ecrivez un
 * programme qui donne la possibilit� � madame Krapabelle de pr�ciser le nombre
 * de fois que Bart doit �crire, p.ex. la phrase "Je ne suis pas allergique � la
 * programmation" (ou une autre phrase de votre choix). Le nombre est lu �
 * partir de la console et la phrase est affich�e autant de fois � l��cran.
 * 
 * @author sdklm
 *
 */

public class E01Blackboard {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez une phrase : ");
		String sentence = scanner.nextLine();
		System.out.print("Entrez un nombre : ");
		int nb = scanner.nextInt();
		for (int i = 0; i < nb; i++) {
			System.out.println(sentence);
		}

	}
}

package sdk.exercises.lu;

import java.util.Scanner;

/**
 * Exercice 1 – Le tableau noir #ForLoop Au début des épisodes des The Simpsons,
 * Bart écrit des phrases amusantes sur le tableau (Figure 1). Ecrivez un
 * programme qui donne la possibilité à madame Krapabelle de préciser le nombre
 * de fois que Bart doit écrire, p.ex. la phrase "Je ne suis pas allergique à la
 * programmation" (ou une autre phrase de votre choix). Le nombre est lu à
 * partir de la console et la phrase est affichée autant de fois à l’écran.
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

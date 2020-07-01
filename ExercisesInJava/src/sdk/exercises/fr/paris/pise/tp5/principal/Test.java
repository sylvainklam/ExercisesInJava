package sdk.exercises.fr.paris.pise.tp5.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sdk.exercises.fr.paris.pise.tp5.humain.Grognon;
import sdk.exercises.fr.paris.pise.tp5.humain.Personne;
import sdk.exercises.fr.paris.pise.tp5.humain.PersonneFamiliere;

public class Test {

	static List<Personne> personnes = new ArrayList<Personne>();

	public static void menu() {

		Scanner scanner = new Scanner(System.in);
		int choix = -1;
		do {
			System.out.println("1 - créer personne normale");
			System.out.println("2 - créer individu familier");
			System.out.println("3 - créer personne grognon");
			System.out.println("4 - dire bonjour à tout le monde");
			System.out.println("5 - quitter");

			choix = scanner.nextInt();

			switch (choix) {
			case 1:
				personnes.add(new Personne("Sylvain"));
				break;
			case 2:
				personnes.add(new PersonneFamiliere("Sami"));
				break;
			case 3:
				personnes.add(new Grognon("Bob"));
				break;
			case 4:
				direBonjour(personnes);
				break;
			case 5:
				System.out.println("Au revoir");
				System.exit(0);
				break;
			default:
				System.err.println("Option inconnue");
				break;
			}
		} while (choix != 5);

		scanner.close();
	}

	public static void main(String[] args) {
		menu();
	}

	public static void direBonjour(Personne p) {
		p.bonjour();
	}

	public static void direBonjour(Personne p1, Personne p2) {
		p1.bonjour();
		p2.bonjour();
	}

	public static void direBonjour(List<Personne> personnes) {
		System.out.println("Bonjour à tous !!!");

		for (Personne personne : personnes) {
			personne.bonjour();
		}
	}

}

package sdk.exercises.fr.paris.pise.tp2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personne {

	private String nom;
	private List<String> prenom = new ArrayList<String>();
	private String adresse;
	private String dateNaissance;

	public Personne(String nom, List<String> prenom, String adresse, String dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.setAdresse(adresse);
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		String prenoms = "";
		for (String p : prenom)
			prenoms += p + " ";
		return prenoms;
	}

	public String getDateNaissance() {
		return this.dateNaissance.toString();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String toString() {
		return getNom() + " " + getPrenom() + " " + getAdresse() + " " + getDateNaissance();
	}

	public static void main(String[] args) throws ParseException {
		ArrayList<Personne> l = new ArrayList<Personne>(); // création d’une liste vide
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nb personnes : ");
		int nb = scanner.nextInt();
		do {
			Personne personne = lireUnePersonneAuClavier(scanner);
			l.add(personne);
			nb--;
		} while (nb != 0);
		Personne.afficheAdresses(l);
		Personne.affichePrenoms(l);
		scanner.close();
	}

	private static void affichePrenoms(ArrayList<Personne> l) {
		for (Personne p : l) {
			System.out.println(p.getPrenom());
		}

	}

	private static void afficheAdresses(ArrayList<Personne> l) {
		for (Personne p : l) {
			System.out.println(p.getAdresse());
		}
	}

	public static Personne lireUnePersonneAuClavier(Scanner scanner) throws ParseException {
		System.out.print("Nom : ");
		String nom = scanner.next();
		System.out.print("Prénom : ");
		String prenom = scanner.next();
		System.out.print("Deuxième Prénom : ");
		String prenom2 = scanner.next();

		List<String> prenoms = new ArrayList<String>();
		prenoms.add(prenom);
		if (prenom2.equalsIgnoreCase("") == false)
			prenoms.add(prenom2);

		System.out.print("Adresse : ");
		String adresse = scanner.next();
		System.out.print("Date de naissance (dd-MM-yyyy) : ");
		String dateNaissance = scanner.next();
		Personne personne = new Personne(nom, prenoms, adresse, dateNaissance);
		System.out.println("Personne saisie : " + personne);
		return personne;
	}
}

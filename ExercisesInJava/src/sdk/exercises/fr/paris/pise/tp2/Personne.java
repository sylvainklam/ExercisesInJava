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
	private List<CompteEnBanque> compteEnBanque = new ArrayList<CompteEnBanque>();

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
		return getNom() + " " + getPrenom() + getAdresse() + " " + getDateNaissance() + " possède " + getRichesse(this)
				+ "€";
	}

	public static void main(String[] args) throws ParseException {
		List<String> prenoms = new ArrayList<String>();
		prenoms.add("Sylvain");
		prenoms.add("Joseph");
		Personne skl = new Personne("KLAM", prenoms, "42 rue de la paix", "06-06-1966");
		CompteEnBanque c1 = new CompteEnBanque();
		CompteEnBanque c2 = new CompteEnBanque();
		skl.addCompteEnBanque(c1);
		skl.addCompteEnBanque(c2);
		c2.deposer(1000);
		c1.deposer(100);
		System.out.println(skl);
	}

	private void addCompteEnBanque(CompteEnBanque c1) {
		getCompteEnBanque().add(c1);
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

	public List<CompteEnBanque> getCompteEnBanque() {
		return compteEnBanque;
	}

	int getRichesse(ArrayList<Personne> population) {
		int sum = 0;
		for (Personne p : population) {
			for (CompteEnBanque compteEnBanque : p.getCompteEnBanque())
				sum += compteEnBanque.getSolde();
		}
		return sum;
	}

	int getRichesse(Personne p) {
		int sum = 0;
		for (CompteEnBanque compteEnBanque : p.getCompteEnBanque())
		{
			sum += compteEnBanque.getSolde();
		}
		return sum;
	}
}

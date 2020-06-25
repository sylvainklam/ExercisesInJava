package sdk.exercises.fr.paris.pise.tp3.humain;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import sdk.exercises.fr.paris.pise.tp3.banque.CompteEnBanque;

public class Personne {

	private String nom;
	private List<String> prenom = new ArrayList<String>();
	private String adresse;
	private LocalDate dateNaissance;
	private List<CompteEnBanque> compteEnBanque = new ArrayList<CompteEnBanque>();

	private static List<Personne> personnes = new ArrayList<Personne>();

	public Personne(String nom, List<String> prenom, String adresse, LocalDate dateNaissance) {
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
		return (this.dateNaissance != null ? this.dateNaissance.toString() : "UNKNOWN");
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

	public void addCompteEnBanque(CompteEnBanque c1) {
		getCompteEnBanque().add(c1);
	}

	private static void affichePrenoms() {
		for (Personne p : getPersonnes()) {
			System.out.println(p.getPrenom());
		}

	}

	private static void afficheAdresses() {
		for (Personne p : getPersonnes()) {
			System.out.println(p.getAdresse());
		}
	}

	public static LocalDate convertStringToLocalDate(String dateNaissance) {
		try {
			String[] tabDateNaissance = dateNaissance.split("-");
			int day = Integer.parseInt(tabDateNaissance[0]);
			int month = Integer.parseInt(tabDateNaissance[1]);
			int year = Integer.parseInt(tabDateNaissance[2]);
			return LocalDate.of(year, month, day);
		} catch (PatternSyntaxException patternSyntaxException) {
			System.err.println(dateNaissance + ", Pattern syntax error  => " + patternSyntaxException.getMessage());
		} catch (NumberFormatException numberFormatException) {
			System.err.println(dateNaissance + ", Number format error  => " + numberFormatException.getMessage());
		} catch (DateTimeException dateTimeException) {
			System.err.println(dateNaissance + ", Date error => " + dateTimeException.getMessage());
		}
		return null;
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

		LocalDate date = convertStringToLocalDate(dateNaissance);

		Personne personne = new Personne(nom, prenoms, adresse, date);
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
		for (CompteEnBanque compteEnBanque : p.getCompteEnBanque()) {
			sum += compteEnBanque.getSolde();
		}
		return sum;
	}

	public static List<Personne> getPersonnes() {
		return personnes;
	}
}

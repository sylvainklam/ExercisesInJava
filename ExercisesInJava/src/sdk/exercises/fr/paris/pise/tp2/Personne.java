package sdk.exercises.fr.paris.pise.tp2;

public class Personne {

	private String nom;
	private String prenom;
	private String adresse;
	private MyDate dateNaissance;

	public Personne(String nom, String prenom, String adresse, MyDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.setAdresse(adresse);
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
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

	public static void main(String[] args) {
		Personne jby = new Personne("Sylvain", "KLAM", "42 rue de la Force 99666 Poudlard", new MyDate(27, 7, 1977));
		System.out.println(jby);
		jby.setAdresse("999 avenue John Lennon, 99990 Edenpark");
		System.out.println(jby);
	}
}

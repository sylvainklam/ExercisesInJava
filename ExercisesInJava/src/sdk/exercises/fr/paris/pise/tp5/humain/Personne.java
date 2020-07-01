package sdk.exercises.fr.paris.pise.tp5.humain;

public class Personne {

	public String prenom;

	public Personne(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void bonjour() {
		System.out.println("(" + getPrenom() + ") Bonjour");
	}
}

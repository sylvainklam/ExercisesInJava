package sdk.exercises.fr.paris.pise.tp7;

import java.util.Random;

@SuppressWarnings("serial")
public class Utilitaire extends Voiture {

	private int capacite;

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public int getRandomCapacite() {
		Random random = new Random();
		return random.nextInt(10);
	}
}

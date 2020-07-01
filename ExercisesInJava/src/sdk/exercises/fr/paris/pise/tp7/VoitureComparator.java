package sdk.exercises.fr.paris.pise.tp7;

import java.util.Comparator;

public class VoitureComparator implements Comparator<Voiture> {

	@Override
	public int compare(Voiture o1, Voiture o2) {
		return o1.getAnnee() - o2.getAnnee();
	}

}

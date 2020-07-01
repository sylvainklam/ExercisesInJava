package sdk.exercises.fr.paris.pise.tp7;

import java.util.Comparator;

public class VehiculeComparator implements Comparator<Vehicule> {

	@Override
	public int compare(Vehicule o1, Vehicule o2) {
		// TODO Auto-generated method stub
		int compareToMarque = o1.getMarque().compareTo(o2.getMarque());
		/**
		 * Tri alphabétique par marque
		 */
		// return compareToMarque;

		/**
		 * marque par ordre alphabétique, si égales le modèle fait la différence,si
		 * égaux l’année de fabrication fait la différence
		 */
		if (compareToMarque == 0) {
			int compareToModele = o1.getModele().compareTo(o2.getModele());
			if (compareToModele == 0) {
				if (o1.getAnnee() > o2.getAnnee())
					return 1;
				else if (o1.getAnnee() == o2.getAnnee())
					return 0;
				return -1;
			} else {
				return compareToModele;
			}
		} else {
			return compareToMarque;
		}
	}

}

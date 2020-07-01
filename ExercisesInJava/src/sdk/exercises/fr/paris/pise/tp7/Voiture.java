package sdk.exercises.fr.paris.pise.tp7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Voiture implements Comparable<Voiture>, Comparator<Voiture>, Serializable, Vehicule {

	private String marque;
	private String modele;
	private int annee;

	private String[] tMarque = { "Peugeot", "Renault", "Citroen", "Ferrari" };

	public int getRandomAnnee() {
		Random random = new Random();
		return 2000 + random.nextInt(20);
	}

	public String getRandomModele() {
		Random rand = new Random();
		String str = "";
		for (int i = 0; i < 5; i++) {
			char c = (char) (rand.nextInt(26) + 97);
			str += c;
		}
		return str;
	}

	public String getRandomMarque() {
		Random random = new Random();
		return tMarque[random.nextInt(4)];
	}

	public static void main(String[] args) {
		int choix = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nombre de voitures : ");
		int nb = scanner.nextInt();
		List<Vehicule> list = new ArrayList<Vehicule>();
		for (int i = 0; i < nb; i++) {
			Vehicule voiture = new Voiture();
			voiture.setMarque(voiture.getRandomMarque());
			voiture.setAnnee(voiture.getRandomAnnee());
			voiture.setModele(voiture.getRandomModele());
			list.add(voiture);
		}

		System.out.print("Nombre d'utilitaires : ");
		int nbUtilitaires = scanner.nextInt();
		List<Vehicule> listUtilitaire = new ArrayList<Vehicule>();
		for (int i = 0; i < nbUtilitaires; i++) {
			Utilitaire utilitaire = new Utilitaire();
			utilitaire.setMarque(utilitaire.getRandomMarque());
			utilitaire.setAnnee(utilitaire.getRandomAnnee());
			utilitaire.setModele(utilitaire.getRandomModele());
			utilitaire.setCapacite(utilitaire.getCapacite());
			listUtilitaire.add(utilitaire);
		}

		list.addAll(listUtilitaire);

		do {
			System.out.println("1 - Tri par ordre naturel");
			System.out.println("2 - Ecrire dans un fichier");
			System.out.println("3 - Lire depuis le fichier");
			System.out.println("4 - Afficher les éléments de la liste");
			System.out.println("5 - Quitter");

			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				Collections.sort(list, new VehiculeComparator());
				break;
			case 2:
				try {
					FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/voiture.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(list);
					oos.flush();
					oos.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				FileInputStream fis;
				try {
					fis = new FileInputStream(System.getProperty("user.home") + "/voiture.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					@SuppressWarnings("unchecked")
					List<Voiture> list1 = (List<Voiture>) ois.readObject();
					System.out.println(list1);
					ois.close();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println(list);
				break;
			}
		} while (choix != 5);
		scanner.close();

//		System.out.println("liste originale");
//		System.out.println(list);
//
//		System.out.println(
//				"marque par ordre alphabétique, si égales le modèle fait la différence,si égaux l’année de fabrication fait la différence.");
//		Collections.sort(list);
//		System.out.println(list);
//
//		System.out.println("Ordre externe : tri selon l'année de fabrication");
//		Collections.sort(list, new Voiture());
//		System.out.println(list);
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String toString() {
		return this.getMarque() + " " + this.getModele() + " " + this.getAnnee();
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	@Override
	public int compareTo(Voiture o) {

		int compareToMarque = getMarque().compareTo(o.getMarque());
		/**
		 * Tri alphabétique par marque
		 */
		// return compareToMarque;

		/**
		 * marque par ordre alphabétique, si égales le modèle fait la différence,si
		 * égaux l’année de fabrication fait la différence
		 */
		if (compareToMarque == 0) {
			int compareToModele = getModele().compareTo(o.getModele());
			if (compareToModele == 0) {
				if (getAnnee() > o.getAnnee())
					return 1;
				else if (getAnnee() == o.getAnnee())
					return 0;
				return -1;
			} else {
				return compareToModele;
			}
		} else {
			return compareToMarque;
		}

	}

	/**
	 * Ordre externe : tri des voitures selon l'année
	 */
	@Override
	public int compare(Voiture o1, Voiture o2) {
		return o1.getAnnee() - o2.getAnnee();
	}
}

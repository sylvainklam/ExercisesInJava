package sdk.exercises.fr.paris.pise.tp3.principal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import sdk.exercises.fr.paris.pise.tp3.banque.CompteEnBanque;
import sdk.exercises.fr.paris.pise.tp3.humain.Personne;

public class Main {

	public static void main(String[] args) throws ParseException {
		List<String> prenoms = new ArrayList<String>();
		prenoms.add("Sylvain");
		prenoms.add("Joseph");
		Personne skl = new Personne("KLAM", prenoms, "42 rue de la paix",
				Personne.convertStringToLocalDate("29-02-2020"));
		CompteEnBanque c1 = new CompteEnBanque();
		CompteEnBanque c2 = new CompteEnBanque();
		skl.addCompteEnBanque(c1);
		skl.addCompteEnBanque(c2);
		c2.deposer(1000);
		c1.deposer(100);
		System.out.println(skl);
	}

}

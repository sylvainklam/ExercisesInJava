package sdk.exercises.fr.paris.pise.tp2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Calendar gc = Calendar.getInstance();

	public MyDate(int jour, int mois, int annee) {
		gc.set(Calendar.DATE, jour);
		gc.set(Calendar.MONTH, mois - 1);
		gc.set(Calendar.YEAR, annee);
	}

	public String toString() {
		return dateFormat.format(gc.getTime());
	}
}

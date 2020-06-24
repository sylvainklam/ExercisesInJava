package sdk.exercises.fr.paris.pise.tp2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Calendar gc = Calendar.getInstance();

	public MyDate(int annee, int mois, int jour) {
		gc.set(Calendar.DATE, jour);
		gc.set(Calendar.MONTH, mois - 1);
		gc.set(Calendar.YEAR, annee);
	}

	public String toString() {
		return dateFormat.format(gc.getTime());
	}

	public static MyDate getMyDateFromString(String sDate) throws ParseException {
		String[] tab = sDate.split("-");
		return new MyDate(Integer.parseInt(tab[2]), Integer.parseInt(tab[1]), Integer.parseInt(tab[0]));
	}
}

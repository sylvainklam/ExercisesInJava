package sdk.exercises.fr.paris;

import java.util.Scanner;

/**
 * Écrire un programme permettant de convertir des températures exprimées en
 * degrés Celsius en degrés Fahrenheit. La température sera lue depuis le
 * clavier. (avec if) Modifier le programme de sorte qu’il permette de convertir
 * de C en F ou l’inverse selon le choix de l’utilisateur. La «formule de
 * conversion» est F = C x 1,8 + 32.
 * 
 * @author SKLAM
 *
 */
public class E01TemperatureConverter {

	private static float convertCelsiusToFahrenheit(float temp) {
		return temp * (9f / 5) + 32;
	}

	private static float convertFahrenheitToCelsius(float temp) {
		return ((temp - 32) * 5) / 9f;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		/* Input temperature in Celsius from user */
		System.out.print("Enter temperature : ");
		float C = in.nextFloat();
		System.out.print("Celsius (C) or Fahrenheit (F) ? : ");
		String mesure = in.next();

		/* Convert Celsius to Fahrenheit */
		if (mesure.equalsIgnoreCase("C")) {
			float F = convertCelsiusToFahrenheit(C);

			/* Print result */
			System.out.println(C + " degree Celsius is equal to " + F + " degree Fahrenheit.");
		}

		/* Convert Fahrenheit to Celsius */
		if (mesure.equalsIgnoreCase("F")) {
			float F = convertFahrenheitToCelsius(C);

			/* Print result */
			System.out.println(C + " degree Fahrenheit is equal to " + F + " degree Celsius.");
		}
	}
}
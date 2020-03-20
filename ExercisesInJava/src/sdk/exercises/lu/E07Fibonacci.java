package sdk.exercises.lu;

import java.util.Scanner;

/**
 * Exercice 7 – Suite de Fibonacci - Ecrivez un programme qui affiche la suite
 * de Fibonacci F jusqu’au nième terme Fn.
 */

public class E07Fibonacci {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.print("Entrez le nombre : ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// afficher les N premiers nombres Fibonacci
		for (int i = 1; i <= N; i++)// commencer de n=1
			System.out.println(i + ": " + fib(i));
	}

	private static int fib(int n) {
		if (n <= 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}
}
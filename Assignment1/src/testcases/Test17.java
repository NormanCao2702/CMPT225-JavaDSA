package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.PrimeNumbersIterator;

public class Test17 {

	public static final int N = 100000;

	public static boolean test() {
		// skip the first 25 primes
		long x = 0;
		PrimeNumbersIterator iter = new PrimeNumbersIterator(98);
		for (int i = 0; i < N - 25; i++)
			x = iter.next();

		System.out.println(x);
		return x == 1299709;
	}

	public static void main(String[] args) {
		String className = MethodHandles.lookup().lookupClass().getSimpleName();

		try {
			if (test())
				System.out.println(className + " ok");
			else
				System.out.println(className + " ERROR");
		} catch (Exception e) {
			System.out.println(className + " EXCEPTION");
		}
	}
}

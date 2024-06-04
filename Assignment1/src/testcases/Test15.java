package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.PrimeNumbersIterator;

public class Test15 {

	public static boolean test() {
		int primes[] = { 17, 19, 23, 29, 31, 37, 41 };

		PrimeNumbersIterator iter = new PrimeNumbersIterator(14);
		for (int i = 0; i < primes.length; i++)
			if (!iter.hasNext() || iter.next() != primes[i])
				return false;

		return true;
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

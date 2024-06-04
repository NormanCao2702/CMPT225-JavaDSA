package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.PrimeNumbersIterator;

public class Test13 {

	public static boolean test() {
		int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		PrimeNumbersIterator iter = new PrimeNumbersIterator();
		for (int i = 0; i < primes.length; i++)
			if (!iter.hasNext() || iter.next() != primes[i])
				return false;

		iter.reset();
		for (int i = 0; i < primes.length - 2; i++)
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

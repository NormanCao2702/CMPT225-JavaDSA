package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.PrimeNumbersIterator;

public class Test20 {

	public static final int LEN = 300000;

	public static boolean test() {
		// iterator starts from the 200,001st prime
		PrimeNumbersIterator iter = new PrimeNumbersIterator(2750160);

		// compute the sum of 200,001st up to 500,000th prime
		long sum = 0;
		for (int i = 0; i < LEN; i++)
			sum += iter.next();

		return sum == 1774825271439l - 264129169599l;
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

package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.PrimeNumbersIterator;

public class Test18 {

	public static final int LEN = 200000;

	public static boolean test() {
		PrimeNumbersIterator iter = new PrimeNumbersIterator();
		long sum = 0;
		for (int i = 0; i < LEN; i++)
			sum += iter.next();

		System.out.println(iter.next());
		return sum == 264129169599l;
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

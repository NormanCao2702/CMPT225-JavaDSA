package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.RangeIterator;

public class Test11 {

	public static boolean test() {
		try {
			new RangeIterator(6, 1);
			// should not reach here
			return false;
		} catch (IllegalArgumentException e) {
			return true;
		}

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

package testcases;

import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

import integeriterators.RangeIterator;

public class Test10 {

	public static boolean test() {
		RangeIterator iter = new RangeIterator(25, 30);

		for (int i = 0; i < 5; i++)
			if (!iter.hasNext() || iter.next() != 25 + i)
				return false;

		if (iter.hasNext())
			return false;

		try {
			iter.next();
			// should throw NoSuchElementException
			return false;
		} catch (NoSuchElementException nsee) {
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

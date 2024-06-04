package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.RangeIterator;

public class Test08 {

	public static boolean test() {
		RangeIterator iter = new RangeIterator(25);
		for (int i = 0; i < 40; i++)
			if (!iter.hasNext() || iter.next() != 25 + i)
				return false;

		for (int i = 0; i < 10; i++) {
			iter.reset();
			if (!iter.hasNext() || iter.next() != 25)
				return false;
		}

		if (!iter.hasNext())
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

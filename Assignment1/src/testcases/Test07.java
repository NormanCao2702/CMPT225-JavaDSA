package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.RangeIterator;

public class Test07 {

	public static boolean test() {
		RangeIterator iter = new RangeIterator();
		for (int i = 0; i < 5; i++)
			if (!iter.hasNext() || iter.next() != i)
				return false;

		iter.reset();

		for (int i = 0; i < 10; i++)
			if (!iter.hasNext() || iter.next() != i)
				return false;

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

package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.RangeIterator;

public class Test09 {

	public static boolean test() {
		RangeIterator iter = new RangeIterator(25, 30);

		for (int j = 0; j < 20; j++) {

			for (int i = 0; i < 5; i++)
				if (!iter.hasNext() || iter.next() != 25 + i)
					return false;

			if (iter.hasNext())
				return false;

			iter.reset();
		}

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

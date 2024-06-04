package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.RangeIterator;

public class Test12 {

	public static boolean test() {
		RangeIterator iter = new RangeIterator(128, 2000000000);

		if (!iter.hasNext())
			return false;

		iter.reset();


		for (int i = 0; i < 10; i++)
			if (!iter.hasNext() || iter.next() != 128 + i)
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

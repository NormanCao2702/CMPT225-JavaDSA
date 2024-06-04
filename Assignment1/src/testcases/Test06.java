package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.ArrayIterator;

public class Test06 {

	public static final int LEN = 50000000;

	public static boolean test() {
		int ans[] = new int[LEN];
		for (int i = 0; i < LEN; i++)
			ans[i] = i * i;

		ArrayIterator iter;
		for (int j = 0; j < 10000; j++) {
			iter = new ArrayIterator(ans, false);
			for (int i = 0; i < 1256; i++)
				if (!iter.hasNext() || iter.next() != ans[i % ans.length])
					return false;

			if (!iter.hasNext())
				return false;
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

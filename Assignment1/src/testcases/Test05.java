package testcases;

import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

import integeriterators.ArrayIterator;

public class Test05 {

	public static final int LEN = 100000;

	public static boolean test() {
		int ans[] = new int[LEN];
		for (int i = 0; i < LEN; i++)
			ans[i] = i%2==0 ? 0 : i*i;

		ArrayIterator iter = new ArrayIterator(ans, false);

		for (int j = 0; j < 10; j++) {
			iter.reset();
			for (int i = 0; i < ans.length; i++)
				if (!iter.hasNext() || iter.next() != ans[i % ans.length])
					return false;

			try {
				iter.next();
				return false;
			} catch (NoSuchElementException nsee) {
			}
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

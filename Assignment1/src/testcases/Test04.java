package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.ArrayIterator;

public class Test04 {

	public static final int LEN = 1000000;
	
	public static boolean test() {
		int ans[] = new int[LEN];
		for (int i = 0; i < LEN; i++)
			ans[i] = -4;
		
		ArrayIterator iter = new ArrayIterator(ans, true);
		for (int i=0; i<1*ans.length+2; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length])
				return false;

		if (!iter.hasNext())
			return false;
		
		iter.reset();
		for (int i=0; i<1.5*LEN; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length])
				return false;

		if (!iter.hasNext())
			return false;
		
		iter.reset();
		for (int i=0; i<3*LEN; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length])
				return false;

		if (!iter.hasNext())
			return false;

		iter.reset();
		for (int i=0; i<LEN/2; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length])
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

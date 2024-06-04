package testcases;

import java.lang.invoke.MethodHandles;
import integeriterators.ArrayIterator;

public class Test03 {

	public static boolean test() {
		int ans[] = {0,0,0,2,5,8,11,14};
		
		ArrayIterator iter = new ArrayIterator(ans, true);
		for (int i=0; i<3*ans.length+2; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length])
				return false;

		if (!iter.hasNext())
			return false;
		
		iter.reset();
		for (int i=0; i<8*ans.length; i++)
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

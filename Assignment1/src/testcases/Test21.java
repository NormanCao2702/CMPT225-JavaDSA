package testcases;

import java.lang.invoke.MethodHandles;

import fifteenpuzzle.FifteenPuzzle;

public class Test21 {

	public static boolean test() {
		try {
			FifteenPuzzle game1 = new FifteenPuzzle("board1.txt");
			String expected = " 1  8  4  6\n"
							+ " 2  3  5 15\n"
							+ "11 12 10  9\n"
							+ " 7 14 13   ";
			String expected_n = expected + "\n";

			String ans = game1.toString();
			return (expected.equals(ans) || expected_n.equals(ans));
		}
		catch (Exception e) {
			return false;
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

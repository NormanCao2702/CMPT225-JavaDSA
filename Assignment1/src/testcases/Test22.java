package testcases;

import java.lang.invoke.MethodHandles;

import fifteenpuzzle.FifteenPuzzle;

public class Test22 {

	public static boolean test() {
		try {
			FifteenPuzzle game2 = new FifteenPuzzle("board2.dat");
			String expected = " 1  2  3  4\n"
							+ " 5  6  8 11\n"
							+ " 9 10    12\n"
							+ "13 14  7 15";

			String expected_n = expected + "\n";

			String ans = game2.toString();
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

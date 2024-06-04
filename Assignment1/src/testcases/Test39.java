package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test39 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board4.txt");
			//15  3  2  5
			// 1     4  8
			// 9 10 11  7
			//13 14  6 12
			game.makeMove(1, FifteenPuzzle.RIGHT);
			game.makeMove(9, FifteenPuzzle.UP);
			game.makeMove(10, FifteenPuzzle.LEFT);
			//15  3  2  5
			// 9  1  4  8
			//10    11  7
			//13 14  6 12
			if (game.isSolved())
				return false;
			String expected = "15  3  2  5\n"
							+ " 9  1  4  8\n"
							+ "10    11  7\n"
							+ "13 14  6 12";
			String expected_n = expected + "\n";

			String ans = game.toString();
			return (expected.equals(ans) || expected_n.equals(ans));

		} catch (Exception e) {
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

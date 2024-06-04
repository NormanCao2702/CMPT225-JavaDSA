package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test23 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board1.txt");
			// 1  8  4  6
			// 2  3  5 15
			//11 12 10  9
			// 7 14 13
			game.makeMove(9, FifteenPuzzle.DOWN);
			game.makeMove(10, FifteenPuzzle.RIGHT);
			game.makeMove(13, FifteenPuzzle.UP);
			game.makeMove(13, FifteenPuzzle.DOWN);
			game.makeMove(5, FifteenPuzzle.DOWN);
			game.makeMove(15, FifteenPuzzle.LEFT);
			game.makeMove(10, FifteenPuzzle.UP);
			// Expected state
			// 1  8  4  6
			// 2  3 15 10
			//11 12  5
			// 7 14 13  9
			String expected = " 1  8  4  6\n" 
							+ " 2  3 15 10\n"
							+ "11 12  5   \n"
							+ " 7 14 13  9";
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

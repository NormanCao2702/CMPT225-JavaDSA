package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test24 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board3.txt");
			// 1  2  3  4
			// 5  6  7  8 
			// 9 10 11
			//13 14 15 12
			for (int i = 0; i < 2; i++) {
				game.makeMove(11, FifteenPuzzle.RIGHT);
				game.makeMove(15, FifteenPuzzle.UP);
				game.makeMove(12, FifteenPuzzle.LEFT);
				
				game.makeMove(11, FifteenPuzzle.DOWN);
				game.makeMove(15, FifteenPuzzle.RIGHT);
				game.makeMove(12, FifteenPuzzle.UP);

				game.makeMove(11, FifteenPuzzle.LEFT);
				game.makeMove(15, FifteenPuzzle.DOWN);
				game.makeMove(12, FifteenPuzzle.RIGHT);

				game.makeMove(11, FifteenPuzzle.UP);
				game.makeMove(15, FifteenPuzzle.LEFT);
				game.makeMove(12, FifteenPuzzle.DOWN);
			}
			game.makeMove(12, FifteenPuzzle.UP);
			String expected = " 1  2  3  4\n" 
							+ " 5  6  7  8\n"
							+ " 9 10 11 12\n"
							+ "13 14 15   ";
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

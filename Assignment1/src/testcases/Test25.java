package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test25 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board4.txt");
			//15  3  2  5
			// 1     4  8   
			// 9 10 11  7
			//13 14  6 12
			game.makeMove(4, FifteenPuzzle.LEFT);
			game.makeMove(8, FifteenPuzzle.LEFT);
			game.makeMove(5, FifteenPuzzle.DOWN);
			game.makeMove(2, FifteenPuzzle.RIGHT);
			game.makeMove(3, FifteenPuzzle.RIGHT);
			game.makeMove(15, FifteenPuzzle.RIGHT);
			//   15  3  2  
			// 1  4  8  5   
			// 9 10 11  7
			//13 14  6 12
			try {
				game.makeMove(15, FifteenPuzzle.RIGHT);
			}
			catch (IllegalMoveException e) {}
			catch (Exception e) {
				return false;
			}
			game.makeMove(1, FifteenPuzzle.UP);
			game.makeMove(9, FifteenPuzzle.UP);
			game.makeMove(10, FifteenPuzzle.LEFT);
			// 1 15  3  2  
			// 9  4  8  5   
			//10    11  7
			//13 14  6 12
			try {
				game.makeMove(15, FifteenPuzzle.UP);
			}
			catch (IllegalMoveException e) {}
			catch (Exception e) {
				return false;
			}

			String expected = " 1 15  3  2\n"
							+ " 9  4  8  5\n"
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

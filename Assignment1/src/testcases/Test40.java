package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test40 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board_test40.dat");
			// 1  6  2  3
			// 5     7  4
			// 9 10 11  8
			//13 14 15 12
			game.makeMove(6, FifteenPuzzle.DOWN);
			game.makeMove(2, FifteenPuzzle.LEFT);
			game.makeMove(3, FifteenPuzzle.LEFT);
			// 1  2  3   
			// 5  6  7  4
			// 9 10 11  8
			//13 14 15 12
			if (game.isSolved())
				return false;
			String expected1 = " 1  2  3   \n"
							+ " 5  6  7  4\n"
							+ " 9 10 11  8\n"
							+ "13 14 15 12";
			String expected1_n = expected1 + "\n";
			String ans1 = game.toString();
			if (!expected1.equals(ans1) && !expected1_n.equals(ans1))
				return false;

			game.makeMove(4, FifteenPuzzle.UP);
			game.makeMove(8, FifteenPuzzle.UP);
			game.makeMove(12, FifteenPuzzle.UP);
			// 1  2  3  4
			// 5  6  7  8
			// 9 10 11 12
			//13 14 15   
			for (int i = 0; i < 1000; i++) {
				game.makeMove(15, FifteenPuzzle.RIGHT);
				game.makeMove(11, FifteenPuzzle.DOWN);
				game.makeMove(12, FifteenPuzzle.LEFT);
				game.makeMove(12, FifteenPuzzle.RIGHT);
				game.makeMove(11, FifteenPuzzle.UP);
				game.makeMove(15, FifteenPuzzle.LEFT);
			}
			if (!game.isSolved())
				return false;
			String expected2 = " 1  2  3  4\n"
							+ " 5  6  7  8\n"
							+ " 9 10 11 12\n"
							+ "13 14 15   ";
			String expected2_n = expected2 + "\n";
			String ans2 = game.toString();
			if (!expected2.equals(ans2) && !expected2_n.equals(ans2))
				return false;
			
			return true;

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

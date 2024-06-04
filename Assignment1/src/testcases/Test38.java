package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test38 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board3.txt");
			// 1  2  3  4
			// 5  6  7  8 
			// 9 10 11
			//13 14 15 12
			if (game.isSolved())
				return false;

			game.makeMove(12, FifteenPuzzle.UP);
			return game.isSolved();
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

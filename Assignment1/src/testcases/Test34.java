package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test34 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board4.txt");
			//15  3  2  5
			// 1     4  8
			// 9 10 11  7
			//13 14  6 12
			game.makeMove(4, FifteenPuzzle.LEFT);
			game.makeMove(1, FifteenPuzzle.LEFT);
			// should throw IllegalMoveException
			return false;
		}
		catch (IllegalMoveException ime) {
			return true;
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

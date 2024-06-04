package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test32 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board2.dat");
			// 1  2  3  4
			// 5  6  8 11
			// 9 10 12
			//13 14  7 15
			game.makeMove(3, FifteenPuzzle.RIGHT);
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

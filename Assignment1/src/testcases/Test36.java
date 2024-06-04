package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test36 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board1.txt");
			if (game.isSolved())
				return false;
			else
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

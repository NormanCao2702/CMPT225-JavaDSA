package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test37 {

	public static boolean test() {
		try {
			FifteenPuzzle game = new FifteenPuzzle("board2.dat");
			//  1  2  3  4
			//  5  6  8 11 
			//  9 10    12
			// 13 14  7 15
			game.makeMove(7, FifteenPuzzle.UP);
			game.makeMove(15, FifteenPuzzle.LEFT);
			game.makeMove(12, FifteenPuzzle.DOWN);
			game.makeMove(11, FifteenPuzzle.DOWN);
			//  1  2  3  4
			//  5  6  8    
			//  9 10  7 11
			// 13 14 15 12
			if (game.isSolved())
				return false;
			
			game.makeMove(8, FifteenPuzzle.RIGHT);
			game.makeMove(7, FifteenPuzzle.UP);
			game.makeMove(11, FifteenPuzzle.LEFT);
			game.makeMove(12, FifteenPuzzle.UP);
			//  1  2  3  4
			//  5  6  7  8
			//  9 10 11 12
			// 13 14 15      
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

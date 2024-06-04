package testcases;

import java.lang.invoke.MethodHandles;
import fifteenpuzzle.*;

public class Test26 {

	public static boolean test() {
		try {
			new FifteenPuzzle("badboard1.txt");
			// should throw BadBoardException
			return false;
		}
		catch (BadBoardException bbe) {
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

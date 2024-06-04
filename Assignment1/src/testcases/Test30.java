package testcases;

import java.lang.invoke.MethodHandles;
import java.io.*;
import fifteenpuzzle.FifteenPuzzle;

public class Test30 {

	public static boolean test() {
		try {
			new FifteenPuzzle("nofile_test23.txt");
			// should throw FileNotFoundException
			return false;
		}
		catch (FileNotFoundException e) {
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

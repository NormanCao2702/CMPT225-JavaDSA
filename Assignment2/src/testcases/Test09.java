package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test09 {

	/*
	 * Tests that reverse does not affect middle of odd list.
	 */
	final static int N = 1000001;

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();

		l.addLeft("Z");
		l.addLeft("X");
		l.addLeft("Y");
		l.addRight("T");
		l.addRight("O");
		// O-T-Z-X-Y
		
		for (int i = 0; i < N; i++)
			l.addLeft("a");
		// a-a-a...-a-O-T-Z-X-Y
		for (int i = 0; i < 2*N+1; i++)
			l.reverse();
		for (int i = 0; i < N; i++)
			l.addLeft("brrr");
		l.reverse();
		// a-a-a...-a-O-T-Z-X-Y-brrr-...-brrr-brrr

		for (int i = 0; i < N; i++) {
			if (!l.getMiddle().equals("Z"))
				return false;
			l.reverse();
		}

		return true;
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

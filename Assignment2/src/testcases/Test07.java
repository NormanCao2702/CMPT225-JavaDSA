package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test07 {

	/*
	 * Tests that reverse runs in constant time.
	 */

	final static int N = 1000000;

	public static boolean test() {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			l.addLeft(1202542);
		}

		if (!(l.size() == N))
			return false;

		for (int i = 0; i < N; i++) {
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

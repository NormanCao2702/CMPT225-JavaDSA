package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test13 {

	/*
	 * Tests removeLeft, removeRight, addLeft, addRight, size and isEmpty all run in
	 * constant time.
	 */
	public static int N = 1000000;

	public static boolean test() {
		MyLinkedList<Character> l = new MyLinkedList<Character>();

		for (int i = 0; i < N; i++)
			l.addLeft('*');

		if (!(l.size() == N))
			return false;

		for (int i = 0; i < N; i++)
			l.isEmpty();

		for (int i = 0; i < N; i++)
			l.size();

		for (int i = 0; i < N; i++)
			l.addLeft('*');

		for (int i = 0; i < N; i++)
			l.removeLeft();

		for (int i = 0; i < N; i++)
			l.addRight('*');

		for (int i = 0; i < N * 2; i++)
			l.removeRight();

		if (!l.isEmpty())
			return false;

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

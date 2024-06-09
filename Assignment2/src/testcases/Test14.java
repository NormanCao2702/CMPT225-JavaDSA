package testcases;

import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

import assignment2.MyLinkedList;

public class Test14 {

	/*
	 * General test case.
	 */

	final static int N = 1000000;

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		if (!l.isEmpty())
			return false;

		l.addRight("MNO");
		l.addLeft("JKL");

		l.addRight("PQR");
		l.addLeft("GHI");

		l.addRight("STU");
		l.addLeft("DEF");

		l.addLeft("ABC");
		l.addRight("VWX");

		l.addRight("YZ");
		// ABC-DEF-GHI-JKL-MNO-PQR-STU-VWX-YZ

		if (!(l.size() == 9))
			return false;

		l.reverse();
		l.reverse();
		l.reverse();
		// YZ-VWX-STU-PQR-MNO-JKL-GHI-DEF-ABC

		if (!l.getMiddle().equals("MNO"))
			return false;

		if (!l.removeRight().equals("ABC"))
			return false;
		// YZ-VWX-STU-PQR-MNO-JKL-GHI-DEF

		for (int i = 0; i < N; i++) {
			l.reverse();
			// DEF-GHI-JKL-MNO-PQR-STU-VWX-YZ
			if (!l.getMiddle().equals("PQR"))
				return false;

			l.reverse();
			// YZ-VWX-STU-PQR-MNO-JKL-GHI-DEF
			if (!l.getMiddle().equals("MNO"))
				return false;
		}

		l.reverse();

		if (!l.removeRight().equals("YZ"))
			return false;

		if (!l.removeLeft().equals("DEF"))
			return false;

		if (!l.removeRight().equals("VWX"))
			return false;

		if (!l.removeLeft().equals("GHI"))
			return false;

		if (!l.removeLeft().equals("JKL"))
			return false;

		if (!l.removeLeft().equals("MNO"))
			return false;

		if (!l.removeLeft().equals("PQR"))
			return false;

		if (!l.removeLeft().equals("STU"))
			return false;

		try {
			l.removeRight();
			// If no exception is thrown, behaviour is incorrect.
			return false;
		} catch (NoSuchElementException e) {
			// Correct behaviour, do nothing.
		} catch (Exception e) {
			// Wrong exception was thrown.
			return false;
		}

		try {
			l.getMiddle();
			return false;
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			return false;
		}

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

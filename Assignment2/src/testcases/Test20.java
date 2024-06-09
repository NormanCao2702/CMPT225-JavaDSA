package testcases;

import java.lang.invoke.MethodHandles;
import java.util.*;

import assignment2.MyLinkedList;

public class Test20 {

	/*
	 * Recursive test.
	 */

	public static boolean equals(MyLinkedList<Integer> e1, MyLinkedList<Integer> e2) {
		if (e1.size() != e2.size())
			return false;
		int n = e1.size();
		if (n == 0)
			return true;
		int[] hold1 = new int[n];
		int[] hold2 = new int[n];

		boolean flag = true;
		int i;
		for (i = 0; i < n; i++) {
			hold1[i] = e1.removeLeft();
			hold2[i] = e2.removeLeft();
			if (hold1[i] != hold2[i]) {

				flag = false;
				i++;
				break;
			}
		}
		i--;
		while (i >= 0) {
			e1.addLeft(hold1[i]);
			e2.addLeft(hold2[i]);
			i--;
		}

		return flag;
	}

	public static boolean test() {

		MyLinkedList<MyLinkedList<Integer>> mainList = new MyLinkedList<>();

		int J = 500;
		int Z = 1000;

		ArrayList<MyLinkedList<Integer>> jLists = new ArrayList<MyLinkedList<Integer>>(J);
		for (int j = 0; j < J; j++) {
			MyLinkedList<Integer> jList1 = new MyLinkedList<Integer>();
			MyLinkedList<Integer> jList2 = new MyLinkedList<Integer>();
			for (int z = 0; z < Z; z++) {
				jList1.addRight(z * j);
				jList2.addRight(z * j);
			}
			mainList.addRight(jList1);
			jLists.add(jList2);
		}

		int counter = 0;
		while (!mainList.isEmpty()) {
			if (!equals(mainList.removeLeft(), jLists.get(counter)))
				return false;
			counter++;
		}

		try {
			mainList.removeRight();
			// If no exception is thrown, behavior is incorrect.
			return false;
		} catch (NoSuchElementException e) {
			// Correct behavior, return true
			return true;
		} catch (Exception e) {
			// Wrong exception was thrown.
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
			System.out.println(className + " EXCEPTION" + e);
		}
	}
}

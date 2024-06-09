package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test19 {

	/*
	 * General test case.
	 */

	public static int M = 10000;

	public static boolean test() {

		// a list of MyLinkedList
		for (int k = 0; k < M; k++) {

			int N = (k % 1000) + 1;
			MyLinkedList<int[]> mll = new MyLinkedList<int[]>();

			int[][] intArrays = new int[N][];

			for (int i = 0; i < N; i++) {
				int[] intArray = new int[i];
				for (int j = 0; j < i; j++)
					intArray[j] = i * j;

				mll.addRight(intArray);
				intArrays[N - i - 1] = intArray;
			}

			if (mll.size() != N)
				return false;

			mll.reverse();

			for (int i = 0; i < N; i++)
				if (!mll.removeLeft().equals(intArrays[i]))
					return false;
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
			System.out.println(className + " EXCEPTION" + e.getMessage() + "--\n");
			e.printStackTrace();
		}
	}
}

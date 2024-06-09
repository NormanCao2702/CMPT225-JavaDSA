package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test31 {

	public static Queue<Integer> createQueueFromArray(int[] a) {
		Queue<Integer> q = new QueueLinkedListBased<Integer>();
		for (int i = 0; i < a.length; i++)
			q.enqueue(a[i]);

		return q;
	}

	public static boolean checkQueueAndEmpty(Queue<Integer> q, int[] a) {
		for (int i = 0; i < a.length; i++)
			if (q.isEmpty() || q.dequeue() != a[i])
				return false;
		if (!q.isEmpty())
			return false;

		return true;
	}

	public static boolean test() {
		int[] A = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 0, 2, 1 };
		int[] revA = new int[A.length];
		for (int i = 0; i < A.length; i++)
			revA[i] = A[A.length - i - 1];

		Queue<Integer> q = createQueueFromArray(A);

		MyQueueOperations.reverse(q);

		return checkQueueAndEmpty(q, revA);
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

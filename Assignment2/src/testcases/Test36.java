package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test36 {

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

	public static final int LEN = 1000000;

	public static boolean test() {
		int[] a = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 0, 2, 1 };
		Queue<Integer> q1 = createQueueFromArray(a);
		Queue<Integer> q2 = createQueueFromArray(a);

		if (!MyQueueOperations.areEqual(q1,q2))
			return false;
		
		// check that the queues were not modified
		return checkQueueAndEmpty(q1, a)
				&& checkQueueAndEmpty(q2, a);
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

package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test27 {


	public static Queue<Integer> createQueueFromArray( int[] a) {
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
		int a[] = new int[LEN];
		for (int i = 0; i < a.length; i++)
			a[i] = i;

		Queue<Integer> q1 = createQueueFromArray(a);

		Queue<Integer> q2 = MyQueueOperations.clone(q1);

		// testing q2
		if (q2 == null)
			return false;

		if (q2 == q1)
			return false;

		// check the content of q2 is correct
		if (!checkQueueAndEmpty(q1, a))
			return false;

		// check the content of q1 is the same as originally
		if (!checkQueueAndEmpty(q2, a))
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

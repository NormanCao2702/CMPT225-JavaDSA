package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;
import geomerticshapes.*;

public class Test37 {

	public static <T> Queue<T> createQueueFromArray(T[] a) {
		Queue<T> q = new QueueLinkedListBased<T>();
		for (int i = 0; i < a.length; i++)
			q.enqueue(a[i]);

		return q;
	}

	public static <T> boolean checkQueueAndEmpty(Queue<T> q, T[] a) {
		for (int i = 0; i < a.length; i++)
			if (q.isEmpty() || q.dequeue() != a[i])
				return false;
		if (!q.isEmpty())
			return false;

		return true;
	}

	public static final int LEN = 100000;

	public static boolean test() {
		GeometricShape[] a = new GeometricShape[LEN];
		for (int i = 0; i < a.length; i++) {
			if (i%3==0)
				a[i] = new Circle(i, i, 2*i);
			else if (i%3 == 1)
				a[i] = new Square(10*i, 0, 3*i);
			else
				a[i] = new Rectangle(10*i, 0, 3*i, 4*i);
		}
		
		Queue<GeometricShape> q1 = createQueueFromArray(a);
		Queue<GeometricShape> q2 = createQueueFromArray(a);

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

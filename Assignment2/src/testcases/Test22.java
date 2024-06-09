package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;
import geomerticshapes.*;

public class Test22 {

	public static boolean test() {
		Queue<GeometricShape> q2 = new QueueLinkedListBased<GeometricShape>();
		Circle c = new Circle(5, 10, 15);
		for (int i = 0; i < 50; i++)
			q2.enqueue(c);
		for (int i = 0; i < 50; i++)
			q2.enqueue(new Circle(1, 2, 3));

		return (MyQueueOperations.size(q2) == 100);
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

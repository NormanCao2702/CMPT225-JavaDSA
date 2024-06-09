package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.*;
import basicdatastructures.queue.*;

public class Test21 {

	public static boolean test() {
		Queue<Integer> q1 = new QueueLinkedListBased<Integer>();
		q1.enqueue(5);
		q1.enqueue(6);
		q1.enqueue(7);

		if (MyQueueOperations.size(q1) != 3)
			return false;

		q1.enqueue(7);
		if (MyQueueOperations.size(q1) != 4)
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

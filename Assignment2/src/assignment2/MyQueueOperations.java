package assignment2;

import basicdatastructures.queue.*;

import java.util.Stack;

public class MyQueueOperations {
	/**
	 * Returns the number of elements in q.
	 */
	public static <T> int size(Queue<T> q) {
		// TODO implement me
		int count = 0;
		Queue<T> temp = new QueueArrayBased<>();

		while(!q.isEmpty()){
			T item = q.dequeue();
			temp.enqueue(item);
			count++;
		}

		while(!temp.isEmpty()){
			q.enqueue(temp.dequeue());
		}
		return count;
	}

	/**
	 * Returns a copy of orig. The items are copied from orig to the new queue using
	 * = operator. For the concrete type of the returned object, you may use either
	 * QueueArrayBased or QueueLinkedListBased, up to you.
	 */
	public static <T> Queue<T> clone(Queue<T> orig) {
		// TODO implement me
		Queue<T> copy = new QueueArrayBased<>(); // Or QueueLinkedListBased
		Queue<T> temp = new QueueArrayBased<>(); // Temporary queue

		while (!orig.isEmpty()) {
			T item = orig.dequeue();
			copy.enqueue(item);
			temp.enqueue(item);
		}

		while (!temp.isEmpty()) {
			orig.enqueue(temp.dequeue());
		}

		return copy;
	}

	/**
	 * Reverses the order of the elements in q.
	 */
	public static <T> void reverse(Queue<T> q) {
		// TODO implement me
		Stack<T> stack = new Stack<>();

		while (!q.isEmpty()) {
			stack.push(q.dequeue());
		}

		while (!stack.isEmpty()) {
			q.enqueue(stack.pop());
		}
	}

	/**
	 * Checks if the two queues have the same items in the same order. The items in
	 * the queues are compared using == operator.
	 */
	public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2) {
		// TODO implement me
		if (size(q1) != size(q2)) {
			return false;
		}

		boolean equal = true;
		Queue<T> temp1 = new QueueArrayBased<>(); // Temporary queue
		Queue<T> temp2 = new QueueArrayBased<>(); // Temporary queue

		while (!q1.isEmpty() && !q2.isEmpty()) {
			T item1 = q1.dequeue();
			T item2 = q2.dequeue();
			temp1.enqueue(item1);
			temp2.enqueue(item2);
			if (item1 != item2) {
				equal = false;
			}
		}

		while (!temp1.isEmpty()) {
			q1.enqueue(temp1.dequeue());
		}

		while (!temp2.isEmpty()) {
			q2.enqueue(temp2.dequeue());
		}

		return equal;
	}
}

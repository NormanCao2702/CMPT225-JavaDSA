package assignment2;

/**
 *
 * This is a generic class representing a list of objects.
 * The operations on the list are as follows:
 * - adding and removing elements from the left and from the right.
 * - reversing the list
 * - obtaining the middle element
 * - getting the size of the list
 * 
 * **All operations must run in O(1) time.**
 */
public class MyLinkedList<T> {

	/**
	 * The constructor creates an empty list
	 */
	public MyLinkedList() {
	}

	/**
	 * Adds the new item to the left of the list. 
	 */
	public void addLeft(T item) {
	}

	/**
	 * Adds the new item to the right of the list. 
	 */
	public void addRight(T item) {
	}

	/**
	 * Removes the leftmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeLeft() {
		return null;
	}

	/**
	 * Removes the rightmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeRight() {
		return null;
	}


	/**
	 * Reverses the list
	 */
	public void reverse() {
		
	}

	/**
	 * Returns the item in the middle of the list.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T getMiddle() {
		return null;
	}

	/** 
	 * Returns the size of the list.
	 */
	public int size() {
		return -1;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
		return false;
	}

}

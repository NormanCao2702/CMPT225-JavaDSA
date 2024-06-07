package assignment2;

import java.util.NoSuchElementException;

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
	private class Node{
		T data;
		Node next;
		Node prev;

		Node(T item){
			this.data = item;
			this.next = null;
			this.prev = null;
		}
	}
	private Node head;
	private Node tail;
	private Node middle;
	private int size;
	private boolean isReverse;

	/**
	 * The constructor creates an empty list
	 */
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.middle = null;
		size = 0;
		isReverse = false;
	}

	/**
	 * Adds the new item to the left of the list. 
	 */
	public void addLeft(T item) {
		Node newNode = new Node(item);
		if(size == 0) head = tail = middle = newNode;
		else{
			if(isReverse){
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}else{
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
//			if(size % 2 == 0) middle = isReverse ? middle.prev:middle.next;
		}
		size++;
	}


	/**
	 * Adds the new item to the right of the list. 
	 */
	public void addRight(T item) {
		Node newNode = new Node(item);
		if(size == 0) head = tail = middle = newNode;
		else{
			if(isReverse){
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}else{
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
//			if(size % 2 != 0) middle = isReverse ? middle.prev:middle.next;
		}
		size++;
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
		if(size == 0) throw new NoSuchElementException("Size is 0");
		Node returnedData = null;
		if(!isReverse) {
			returnedData = tail;
			tail = tail.prev;
			if(tail != null) tail.next = null;
		}
		else{
			returnedData = head;
			head = head.next;

		}


		return returnedData.data;
	}


	/**
	 * Reverses the list
	 */
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		isReverse = true;
	}

	/**
	 * Returns the item in the middle of the list.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T getMiddle() {
		if(size ==0) throw new NoSuchElementException("Size is now 0");
	}

	/** 
	 * Returns the size of the list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
		return size==0;
	}

}

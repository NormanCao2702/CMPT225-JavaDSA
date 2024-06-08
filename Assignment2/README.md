# Assignment 2
There are 2 parts: **MyLinkedList** and **MyQueueOperations**.

## 1. MyLinkedList
Implement all methods in class MyLinkedList including:
* [x] public MyLinkedList(): Creates an empty linked list
* [x] public void addLeft(T item): Adds the new item to the left of the list.
* [x] public void addRight(T item): Adds the new item to the right of the list.
* [x] public T removeLeft(): Removes the leftmost item from the list and returns it. If the list is empty, throws NoSuchElementException.
* [x] public T removeRight(): Removes the rightmost item from the list and returns it. If the list is empty, throws NoSuchElementException.
* [x] public void reverse(): Reverses the list. For example, if the list was 1-2-3-1-4, after running the method, it becomes 4-1-3-2-1.
* [x] public T getMiddle(): Returns the item in the middle of the list. If the list has even length (and there are two middle nodes) the method returns the node closer to the right end. For example:
  - if the list is 3-4-5-6-5-4-3, the method returns 6.
  - if the list is 100, the method returns 100.
  - if the list is 0-6-8-100, the method returns 8.
  - if the list is 1-2, the method returns 2.
  - If the list is empty, throws NoSuchElementException.
* [x] public int size(): Returns the size of the list
* [x] public boolean isEmpty(): Checks if the list is empty.

## 2. MyQueueOperations:
Implement all methods in class MyQueueOperations, these methods is to keep track of information of given q of both concrete implementations QueueArrayBased and QueueLinkedListBased given by Professor, including:
* [x] public static <T> int size(Queue<T> q): Returns the number of elements in q.
* [] public static <T> Queue<T> clone(Queue<T> orig): Returns a copy of orig. The items are copied from orig to the new queue using = operator. For the concrete type of the returned object, you may use either QueueArrayBased or QueueLinkedListBased. That’s up to you.
* [] public static <T> void reverse(Queue<T> q): Reverses the order of the elements in q.
* [] public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2): Checks if the two queues have the same items in the same order.  The items in the queues are to be compared using == operator.

After the methods return, the input queues must be in the same state as in the beginning
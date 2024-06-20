package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test03 {

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("Q");
		l.addLeft("A");
		l.addLeft("A");
		l.addLeft("X");
		l.addRight("Q");
		l.addRight("Q");
		// X-A-A-Q-Q-Q
//		l.printLinkedList();
//		l.printMiddle();
//		l.removeRight();
//		l.printLinkedList();
//		l.printMiddle();
//		l.removeRight();
//		l.printLinkedList();
//		l.printMiddle();
//		l.removeRight();
//		l.printLinkedList();
//		l.printMiddle();
//		l.removeLeft();
//		l.printLinkedList();


		return (l.removeRight().equals("Q")
				&& l.removeRight().equals("Q")
				&& l.removeRight().equals("Q")
				&& l.removeLeft().equals("X")
				// A-A
				&& !l.isEmpty()
				&& l.size()==2
				&& l.removeRight().equals("A")
				&& l.removeLeft().equals("A")
				&& l.isEmpty()
				&& l.size()==0);
//		return false;
	}

	public static void main(String[] args) {
		String className = MethodHandles.lookup().lookupClass().getSimpleName();

//		test();
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

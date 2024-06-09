package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test04 {

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("X");
		l.addRight("Y");
		l.addRight("Z");
		// A-B-C-X-Y-Z
		l.reverse();
		// Z-Y-X-C-B-A
		l.addLeft("R");
		// R-Z-Y-X-C-B-A
		
		return (l.removeRight().equals("A")
				&& l.removeRight().equals("B")
				&& l.removeRight().equals("C")
				&& l.removeRight().equals("X")
				&& l.size()==3);
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

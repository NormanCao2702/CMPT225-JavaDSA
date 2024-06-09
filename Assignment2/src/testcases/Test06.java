package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test06 {

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("Z");
		// A-B-C-D-Z

		if (!l.getMiddle().equals("C"))
			return false;
		
		l.removeLeft();
		// B-C-D-Z

		if (!l.getMiddle().equals("D"))
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

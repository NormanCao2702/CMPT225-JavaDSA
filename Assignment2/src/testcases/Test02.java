package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test02 {

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("X");
		l.addRight("Y");
		l.addRight("Z");
		// A-B-C-D-X-Y-Z

		return(l.removeLeft().equals("A") 
				&& l.removeRight().equals("Z")
				&& l.size()==5);
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

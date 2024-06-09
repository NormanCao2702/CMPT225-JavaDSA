package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test05 {

	public static boolean test() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		if (!l.isEmpty())
			return false;

		l.addLeft("A");
		l.addLeft("123");
		l.addRight("XYZ");
		// 123-A-XYZ
		
		l.reverse();
		l.reverse();
		l.reverse();
		// XYZ-A-123

		if (!l.removeRight().equals("123"))
			return false;
		// XYZ-A
		
		if (!l.removeRight().equals("A"))
			return false;
		
		if (l.isEmpty())
			return false;

		if (!l.removeLeft().equals("XYZ"))
			return false;

		return l.isEmpty();
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

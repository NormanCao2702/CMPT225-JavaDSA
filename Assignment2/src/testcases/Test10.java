package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test10 {

    /*
        Tests that reverse works correctly on long lists.
     */
    final static int N=1000000;

	public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        for(int i =0; i < N; i++)
            l.addLeft("*");
        // *-*-...-*

        l.addRight("Z");
        l.addRight("X");
        l.addRight("Y");
        // *-*-...-*-Z-X-Y

        if(!l.removeRight().equals("Y"))
            return false;
        // *-*-...-*-Z-X

        l.reverse();
        // X-Z-*-...-*

        if(!l.removeRight().equals("*"))
            return false;

        if(!l.removeLeft().equals("X"))
            return false;

        if(!l.removeLeft().equals("Z"))
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

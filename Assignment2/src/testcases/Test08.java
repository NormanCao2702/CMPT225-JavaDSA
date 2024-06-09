package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test08 {

    /*
        Tests that both reverse and getMiddle run in constant time.
     */
	final static int N = 1000000;

	public static boolean test() {
        MyLinkedList<Character> l = new MyLinkedList<Character>();

        for(int i =0; i < N; i++){
            l.addLeft('*');
            l.addLeft('#');
        }

        if (!(l.size()==N*2))
            return false;

        for(int i =0; i < N; i++) {
            l.reverse();

            if(i % 2 == 0){
                if (l.getMiddle() == '#')
                    return false;
            }else{
                if (l.getMiddle() == '*')
                    return false;
            }

        }

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

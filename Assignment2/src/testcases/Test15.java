package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test15 {

    /*
        Tests remove and reverse on long lists.
     */
    public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        int N=1000000;
        for(int i = 0; i < N; i++){
            l.addLeft("*");
            l.addLeft("#");
        }
        // #-*-#-...-#-*

        for(int i = 0; i < N; i++){
            l.addRight("$");
            l.addLeft("@");
        }
        // @-...-@-#-*-#-...-#-*-$-$-...$

        l.reverse();
        // $-...-$-*-#-*-...-*-#-@-@-...@

        // Remove half "$"
        for(int i = 0; i < N/2; i++){
            if(!l.removeLeft().equals("$"))
                return false;
        }

        // Remove all "@"
        for(int i = 0; i < N; i++){
            if(!l.removeRight().equals("@"))
                return false;
        }
        // $-...-$-*-#-*-...-*-#

        // Remove all "*-#"
        for(int i = 0; i < N; i++){
            if(!l.removeRight().equals("#"))
                return false;
            if(!l.removeRight().equals("*"))
                return false;
        }
        //$-$-...$

        // Remove remaining "$"
        for(int i = 0; i < N/2; i++){
            if(!l.removeLeft().equals("$"))
                return false;
        }

        // Ensure LinkedList is empty
        if(!l.isEmpty())
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

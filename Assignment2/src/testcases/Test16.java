package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test16 {

    /*
        General simple test case.
     */
    public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        l.addLeft("that");
        l.addLeft("ship");
        l.addRight("sails");
        l.addRight("by");
        l.addLeft("a");
        l.addLeft("there's");
        l.addRight("my");
        l.addRight("window");

        if(!(l.size() == 8))
            return false;

        int removed = 0;
        while(!l.isEmpty()){
            l.removeRight();
            removed++;
        }
        if (removed != 8)
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

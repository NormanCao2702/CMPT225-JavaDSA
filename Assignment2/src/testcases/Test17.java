package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test17 {

    /*
        General test case.
     */
    public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        int N = 10000;
        String[] strings = new String[N];

        String cur = "*";
        for(int i = 0; i < N; i++){
            l.addRight(cur);
            strings[i] = cur;
            cur = cur + "*";
        }

        if(!(l.size() == N))
            return false;

        for(int i = N-1; i >= 0; i--){
            if(!l.removeRight().equals(strings[i]))
                return false;
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

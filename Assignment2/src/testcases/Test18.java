package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyLinkedList;

public class Test18 {

    /*
        General test case.
     */
    public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        int N = 5000000;
        String[] strings = new String[N];

        String[] type = {"*#\n\n\t*#", "\brt2@@%", "@AA#125\t", "TJAWQ#4"};
        for(int i = 0; i < N; i++){
            strings[i] = type[i%4];
            l.addRight(strings[i]);
        }

        if(!(l.size() == N))
            return false;

        for(int i = 0; i < N/2; i++){
            if(!l.removeLeft().equals(strings[i]))
                return false;
        }

        if(!(l.size() == N/2))
            return false;

        if(!(l.getMiddle().equals(type[0])))
            return false;

        l.reverse();

        if(!(l.getMiddle().equals(type[3])))
            return false;

        for(int i = N/2-1; i >= 0; i--){

            if(!l.removeLeft().equals(type[i%4]))
                return false;
        }

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

package testcases;

import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

import assignment2.MyLinkedList;

public class Test12 {

    /*
        Tests noSuchElementException on all methods
     */
    public static boolean test() {
        MyLinkedList<String> l = new MyLinkedList<String>();

        if(!l.isEmpty())
            return false;

        try {
            l.removeRight();
            //If no exception is thrown, behaviour is incorrect.
            return false;
        } catch (NoSuchElementException e){
            //Correct behaviour, do nothing.
        } catch (Exception e){
            //Wrong exception was thrown.
            return false;
        }

        try {
            l.removeLeft();
            return false;
        } catch (NoSuchElementException e){

        } catch (Exception e){
            return false;
        }

        try {
            l.getMiddle();
            return false;
        } catch (NoSuchElementException e){

        } catch (Exception e){
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

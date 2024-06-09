package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test33 {

    public static Queue<Integer> createQueueFromArray(Integer[] a) {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();
        for (int i = 0; i < a.length; i++)
            q.enqueue(a[i]);

        return q;
    }

    public static <T> boolean checkQueue(Queue<T> q, T[] a) {
        Queue<T> hold = new QueueLinkedListBased<T>();
        boolean flag = true;

        if(q.isEmpty() && a.length!=0)
            return false;

        int i = 0;
        while(!q.isEmpty()){
            T temp = q.dequeue();
            hold.enqueue(temp);
            if(i >= a.length || !temp.equals(a[i]))
                flag = false;
            i++;
        }

        for(;i>0;i--){
            q.enqueue(hold.dequeue());
        }

        return flag;
    }

    public static Integer[] catalanNumbers(int n) {
        Integer[] catalan = new Integer[n];
        catalan[0] = 1;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                catalan[i] = 0;
                for (int j = 0; j < i; j++) {
                    catalan[i] += catalan[j] * catalan[i - j - 1];
                }
            }
        }
        return catalan;
    }

    public static final int LEN = 10;
    /*
        Reverse and check, re-reverse to make sure it's the same as the original.
     */

    public static boolean test() {
        Integer[] cat = catalanNumbers(LEN);
        Integer[] reversedCat = new Integer[LEN];
        for (int i = 0; i < LEN; i++)
            reversedCat[i] = cat[LEN - i - 1];


        Queue<Integer> q = createQueueFromArray(cat);

        if(!checkQueue(q, cat))
            return false;

        MyQueueOperations.reverse(q);

        if(!checkQueue(q, reversedCat))
            return false;

        MyQueueOperations.reverse(q);

        if(!checkQueue(q, cat))
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

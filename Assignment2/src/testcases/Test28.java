package testcases;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test28 {


    public static Queue<Integer> createQueueFromArray( int[] a) {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();
        for (int i = 0; i < a.length; i++)
            q.enqueue(a[i]);

        return q;
    }

    public static boolean checkQueueAndEmpty(Queue<Integer> q, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (q.isEmpty() || q.dequeue() != a[i])
                return false;
        if (!q.isEmpty())
            return false;

        return true;
    }

    public static final int N = 10000;
    public static final int M = 1000;

    public static boolean test() {
        int a[] = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;

        Queue<Integer> q = createQueueFromArray(a);
        ArrayList<Queue<Integer>> copies = new ArrayList<Queue<Integer>>();

        for(int i =0; i < M; i++){
            copies.add(MyQueueOperations.clone(q));
        }

        // check that the content of q is correct
        if(!checkQueueAndEmpty(q, a))
            return false;

        for(Queue<Integer> copy : copies){
            // check that the content of each copy is correct
            if(!checkQueueAndEmpty(copy, a))
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

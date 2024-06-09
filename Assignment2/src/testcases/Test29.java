package testcases;

import java.lang.invoke.MethodHandles; 
import java.util.ArrayList;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test29 {


    public static Queue<Integer> createQueueFromArray( Integer[] a) {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();
        for (int i = 0; i < a.length; i++)
            q.enqueue(a[i]);

        return q;
    }

    public static boolean checkQueueAndEmpty(Queue<Integer> q, Integer[] a) {
        for (int i = 0; i < a.length; i++)
            if (q.isEmpty() || q.dequeue() != a[i])
                return false;
        if (!q.isEmpty())
            return false;

        return true;
    }

    public static Integer[] fib(int n){
        Integer[] f = new Integer[n];
        f[0] = 0;
        if(n>1){
            f[1] = 1;
            for(int i=2; i<n; i++)
                f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    public static final int N = 25;
    public static final int M = 100000;

    /*
        Create many copies of copies
     */
    public static boolean test() {
        Integer[] f = fib(N);

        Queue<Integer> original = createQueueFromArray(f);
        ArrayList<Queue<Integer>> chain = new ArrayList<Queue<Integer>>();

        chain.add(original);
        for(int i =1; i < M; i++){
        	Queue<Integer> q = MyQueueOperations.clone(chain.get(i-1)); 	
            chain.add(q);
        }

        for(Queue<Integer> q : chain){
            // check that the content of each copy is correct
            if(!checkQueueAndEmpty(q, f))
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
            System.out.println(className + " EXCEPTION" + e);
            e.printStackTrace();
        }
    }
}

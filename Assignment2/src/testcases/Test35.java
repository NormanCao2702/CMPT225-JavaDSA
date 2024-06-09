package testcases;

import java.lang.invoke.MethodHandles; 
import java.util.Arrays;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test35 {

    public static Queue<Double> createQueueFromArray(Double[] a) {
        Queue<Double> q = new QueueLinkedListBased<Double>();
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

    public static Double[] roots(int n) {
        Double[] r = new Double[n];

        for (int i = 0; i < n; i++) {
            r[i] = Math.sqrt(i);
        }

        return r;
    }

    public static final int LEN = 1000;
    /*
        Reverse q, checks if q is correct, re-reverse q and dequeues an element.
        Repeats this process until q is empty. Ensures reverse runs in reasonable time.
     */
    public static boolean test() {
        Double[] roots = roots(LEN);
        Double[] revRoots = new Double[LEN];

        for (int i = 0; i < LEN; i++)
            revRoots[i] = roots[LEN - i - 1];

        Queue<Double> q = createQueueFromArray(roots);

        if(!checkQueue(q, roots))
            return false;

        int i=0;
        while(!q.isEmpty()){
            MyQueueOperations.reverse(q);

            if(!checkQueue(q, Arrays.copyOfRange(revRoots,0,LEN-i)))
                return false;

            MyQueueOperations.reverse(q);

            q.dequeue();
            i++;

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

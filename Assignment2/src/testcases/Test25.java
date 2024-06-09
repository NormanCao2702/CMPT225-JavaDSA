package testcases;

import java.lang.invoke.MethodHandles;

import java.util.Arrays;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test25 {


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

    public static final int LEN = 25;

    /*
        Checks size preserves elements in queue (queue is in the same state).
     */
    public static boolean test() {

        Integer[] f = fib(LEN);

        Queue<Integer> q = createQueueFromArray(f);

        for(int i = LEN; i > 0; i--){
            if (MyQueueOperations.size(q) != i)
                return false;
            if(!checkQueue(q, Arrays.copyOfRange(f,LEN-i, LEN)))
                return false;
            q.dequeue();
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

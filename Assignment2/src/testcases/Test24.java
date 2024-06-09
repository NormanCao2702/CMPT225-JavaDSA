package testcases;

import java.lang.invoke.MethodHandles;

import java.util.Arrays;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;


public class Test24 {


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

    public static final int LEN = 10000;

    /*
        Checks size preserves elements in queue (queue is in the same state).
        Ensures size runs in a reasonable amount of time.
     */
    public static boolean test() {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();
        Integer[] compare = new Integer[LEN];

        for (int i = 0; i < LEN; i++){
            if (MyQueueOperations.size(q) != i)
                return false;
            q.enqueue(i);
            compare[i] = i;
            if(!checkQueue(q, Arrays.copyOfRange(compare,0, i+1)))
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

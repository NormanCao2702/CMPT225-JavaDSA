package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test23 {

    public static final int LEN = 10000;

    /*
        Checks size on a large queue.
     */
    public static boolean test() {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();

        for (int i = 0; i < LEN; i++){
            if (MyQueueOperations.size(q) != i)
                return false;
            q.enqueue(i);
        }

        if (MyQueueOperations.size(q) != LEN)
            return false;
        
        for (int i = LEN-1; i >= 0; i--){
            q.dequeue();
            if (MyQueueOperations.size(q) != i)
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

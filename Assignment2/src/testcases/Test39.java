package testcases;

import java.lang.invoke.MethodHandles; 

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test39 {

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

    public static final int N = 1000;

    public static boolean test() {
        Double[] r = roots(N);

        Queue<Double> q1 = new QueueLinkedListBased<Double>();
        Queue<Double> q2 = new QueueLinkedListBased<Double>();

        for(int i = 0; i < N; i++){
            q1.enqueue(r[i]);
            q2.enqueue(r[i]);

            if(!MyQueueOperations.areEqual(q1,q2))
                return false;
        }

        //Check that function is not just returning true
        Queue<Double> differentQ = new QueueLinkedListBased<Double>();
        differentQ.enqueue(-1.0);
        if(MyQueueOperations.areEqual(differentQ,q1) || MyQueueOperations.areEqual(differentQ,q2))
            return false;

        //Currently, both queues should have all elements in r
        if(!checkQueue(q1, r) || !checkQueue(q2,r))
            return false;

        while(!q1.isEmpty()){
            q1.dequeue();
            q2.dequeue();
            if(!MyQueueOperations.areEqual(q1,q2))
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

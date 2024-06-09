package testcases;

import java.lang.invoke.MethodHandles; 

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test30 {


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

    public static Integer[] squaredNumbers(int start, int finish){
        Integer[] s = new Integer[finish-start];
        for (int i = start; i < finish; i++)
            s[i-start] = (i+1)*(i+1);
        return s;
    }

    public static final int LEN = 2000;

    public static boolean test() {
        Queue<Integer> q = new QueueLinkedListBased<Integer>();
        Integer[] squares = squaredNumbers(0,LEN);

        for (int i = 0; i < LEN; i++){
            q.enqueue(squares[i]);
            Queue<Integer> copy = MyQueueOperations.clone(q);

            if(!checkQueue(copy, squaredNumbers(0,i+1) ))
                return false;
        }


        for (int i = LEN-1; i >= 0; i--){
            q.dequeue();
            Queue<Integer> copy = MyQueueOperations.clone(q);

            if(!checkQueue(copy, squaredNumbers(LEN-i,LEN) ))
                return false;

        }

        //return q.isEmpty();
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

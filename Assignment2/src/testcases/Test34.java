package testcases;

import java.lang.invoke.MethodHandles;
import java.util.Random;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test34 {

    public static Queue<String> createQueueFromArray(String[] a) {
        Queue<String> q = new QueueLinkedListBased<String>();
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

    public static String[] randomStrings(int n) {
        String[] strings = new String[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            char[] chars = new char[5];
            for (int j = 0; j < 5; j++) {
                chars[j] = (char) (random.nextInt(26) + 'A');
            }
            strings[i] = new String(chars);
        }

        return strings;
    }

    public static final int LEN = 100000;
    /*
        Generates many random strings (of length 5) and checks reverse,
        then re-reverse to make sure it's the same as the original.
        Ensures reverse runs in a reasonable amount of time.
     */

    public static boolean test() {
        String[] randomStrings = randomStrings(LEN);
        String[] revRandomStrings = new String[LEN];
        for (int i = 0; i < LEN; i++)
            revRandomStrings[i] = randomStrings[LEN - i - 1];


        Queue<String> q = createQueueFromArray(randomStrings);

        if(!checkQueue(q, randomStrings))
            return false;

        MyQueueOperations.reverse(q);

        if(!checkQueue(q, revRandomStrings))
            return false;

        MyQueueOperations.reverse(q);

        if(!checkQueue(q, randomStrings))
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

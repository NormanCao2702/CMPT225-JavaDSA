package testcases;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Random;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;

public class Test38 {

    public static Queue<String> createQueueFromArray(String[] a) {
        Queue<String> q = new QueueLinkedListBased<String>();
        for (int i = 0; i < a.length; i++)
            q.enqueue(a[i]);

        return q;
    }

    public static boolean checkQueueAndEmpty(Queue<String> q, String[] a) {
        for (int i = 0; i < a.length; i++)
            if (q.isEmpty() || !q.dequeue().equals(a[i]))
                return false;
        if (!q.isEmpty())
            return false;

        return true;
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

    public static final int N = 3000;
    public static final int M = 40;

    public static boolean test() {
        String[] strings = randomStrings(N);

        ArrayList<Queue<String>> q = new ArrayList<Queue<String>>();

        for(int m = 0; m < M; m++)
            q.add(createQueueFromArray(strings));

        for(int i = 0; i < M; i++){
            for(int j = i+1; j < M; j++){
                if(!MyQueueOperations.areEqual(q.get(i),q.get(j)))
                    return false;
            }
        }

        //Check that function is not just returning true
        Queue<String> differentQ = createQueueFromArray(new String[]{"NOT", "EQUAL"});
        for(int m = 0; m < M; m++){
            if(MyQueueOperations.areEqual(differentQ,q.get(m)))
                return false;
        }

        //Check all queues were not modified
        for(int m = 0; m < M; m++)
            if(!checkQueueAndEmpty(q.get(m), strings))
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

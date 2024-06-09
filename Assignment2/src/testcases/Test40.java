package testcases;

import java.lang.invoke.MethodHandles;

import assignment2.MyQueueOperations;
import basicdatastructures.queue.*;
import geomerticshapes.*;

public class Test40 {

    public static <T> Queue<T> createQueueFromArray(T[] a) {
        Queue<T> q = new QueueLinkedListBased<T>();
        for (int i = 0; i < a.length; i++)
            q.enqueue(a[i]);

        return q;
    }

    public static final int N = 1000;
    /*
        Test that starts with two unequal queues, but after
        dequeuing N elements, they become equal.
     */
    public static boolean test() {
        GeometricShape[] shapes1 = new GeometricShape[N*2];
        GeometricShape[] shapes2 = new GeometricShape[N*2];

        for (int i = 0; i < N; i++) {
            switch(i%3){
                case 0:
                    shapes1[i] = new Rectangle(5*i, 0, i, 2*i);
                    shapes2[i] = new Rectangle(5*i+5, 5, i+5, 2*i+5);
                    break;
                case 1:
                    shapes1[i] = new Circle(34*i, i-5, 7*i);
                    shapes2[i] = new Circle(34*i+1, i-4, 7*i+1);
                    break;
                default:
                    shapes1[i] = new Square(61*i, 0, 6*i);
                    shapes2[i] = new Square(61*i+1, 1, 6*i+1);

            }
        }
        for (int i = N; i < N*2; i++) {
            switch(i%3){
                case 0:
                    Rectangle rect = new Rectangle(2*i, 4, 5*i, 8*i);
                    shapes1[i] = rect;
                    shapes2[i] = rect;
                    break;
                case 1:
                    Circle circ = new Circle(i-1, i+5, 5*i);
                    shapes1[i] = circ;
                    shapes2[i] = circ;
                    break;
                default:
                    Square square = new Square(2*i, 4, 3*i*i);
                    shapes1[i] = square;
                    shapes2[i] = square;

            }
        }

        Queue<GeometricShape> q1 = createQueueFromArray(shapes1);
        Queue<GeometricShape> q2 = createQueueFromArray(shapes2);

        for (int i = 0; i < N; i++) {
            if (MyQueueOperations.areEqual(q1,q2))
                return false;
            q1.dequeue();
            q2.dequeue();
        }

        for (int i = 0; i < N; i++) {
            if (!MyQueueOperations.areEqual(q1,q2))
                return false;
            q1.dequeue();
            q2.dequeue();
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

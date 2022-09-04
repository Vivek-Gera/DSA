package dsa.apps;

import dsa.structures.queue.Queue;

public class QueueApp {
    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        queue.enqueue(100);
        queue.print();
        System.out.println();

        System.out.println(queue.isEmpty());
        System.out.println();
        System.out.println(queue.front());
        System.out.println();
        System.out.println(queue.rear());
        System.out.println();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();

    }
}

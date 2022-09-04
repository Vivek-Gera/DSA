package dsa.structures.queue;

public class Queue {
    // data members
    Node front,rear;
    int data;
    int length;

    // constructor
    public Queue(){
        this.front = null;
        this.rear = null;
        this.data = Integer.MIN_VALUE;
        this.length = 0;
    }

    // member methods
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(this.length == 0) {
            this.rear = newNode;
            this.front = newNode;
        } else {
            newNode.setNext(this.rear);
            this.rear = newNode;
        }
        this.length++;
    }

    public int dequeue() {
        Node currentRear = this.rear;
        Node currentFront;
        while(currentRear.getNext() != this.front) {
            currentRear = currentRear.getNext();
        }
        currentFront = currentRear.getNext();
         this.front = currentRear;
        this.length--;

        return currentFront.getData();
    }

    public int front() {
        return this.front.getData();
    }

    public int rear() {
        return this.rear.getData();
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void print() {
        Node currentRear = this.rear;

        while (currentRear != null) {
            System.out.println(currentRear.getData());
            currentRear = currentRear.getNext();
        }
    }

}

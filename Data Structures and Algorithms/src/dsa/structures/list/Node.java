package dsa.structures.list;

public class Node {

    // data members
    private int data;
    private Node next;

    // constructors
    public Node() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // member methods
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

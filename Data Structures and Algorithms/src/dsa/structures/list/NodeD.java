package dsa.structures.list;

public class NodeD {

    // Data members
    private int data;
    private NodeD next, prev;

    // constructors
    public NodeD() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
        this.prev = null;
    }

    public NodeD(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    //member methods
    public void setPrev(NodeD prev) {
        this.prev = prev;
    }

    public NodeD getPrev() {
        return this.prev;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD getNext() {
        return this.next;
    }

}

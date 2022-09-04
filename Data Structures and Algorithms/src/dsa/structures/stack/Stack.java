package dsa.structures.stack;

public class Stack {
    // data members
    private Node top;

    // Constructor
    public Stack() {
        this.top = null;
    }

    // member methods
    public void push(int data) {
        Node newNode = new Node(data);

        newNode.setNext(top);
        top = newNode;
    }

    public int pop() {
        if(top == null){
            throw new RuntimeException("Empty Stack");
        }

        Node currentTop = top;

        top = top.getNext();
        return currentTop.getData();
    }

    public int peek() {
        return top.getData();
    }

    public Boolean isEmpty() {
        return (top == null );
    }

    public void print() {
        Node currentTop = top;

        while (currentTop != null) {
            System.out.println(currentTop.getData());
            currentTop = currentTop.getNext();
        }
    }

}

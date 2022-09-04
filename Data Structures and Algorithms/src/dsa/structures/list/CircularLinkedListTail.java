package dsa.structures.list;

public class CircularLinkedListTail {

    // data members
    private Node tail;
    private int length;

    // constructor
    public CircularLinkedListTail() {
        this.tail = null;
        this.length = 0;
    }

    // member methods
    public void append(int data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.tail = newNode;
            newNode.setNext(this.tail);
        } else {
            newNode.setNext(this.tail.getNext());
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.length++;
    }

    public void insert(int position, int data) {
        if (position < 0 || position >= this.length) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);

        if (position == 0) {
            newNode.setNext(this.tail.getNext());
            this.tail.setNext(newNode);
        } else {
            int currentIndex = 0;
            Node currentNode = this.tail;
            while (currentNode.getNext() != this.tail) {
                if (currentIndex == position - 1) {
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);
                }
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }
        this.length++;
    }

    public void delete(int data) {

        if (this.length == 0) return;

        Node previousNode = this.tail;
        Node currentNode = previousNode.getNext();

        do {
            if (currentNode.getData() == data) {
                previousNode.setNext(currentNode.getNext());
                if (currentNode == this.tail) this.tail = previousNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        } while (previousNode != this.tail);

        this.length--;
    }

    public void deleteAt(int position) {
        if (position < 0 || position > this.length || this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = this.tail.getNext();
        Node previousNode = this.tail;
        int currentIndex = 0;

        do {
            if(position-1 == currentIndex) {
                previousNode.setNext(currentNode.getNext());
                if(currentNode == this.tail) {this.tail = previousNode;}
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }while (previousNode != this.tail);
        this.length--;
    }

    public boolean contains(int data) {
        Node currentNode = this.tail;

        do {
            if (currentNode.getData() == data) return true;
            currentNode = currentNode.getNext();
        } while (currentNode != this.tail);
        return false;
    }

    public int search(int data) {
        int currentIndex = 0;
        int length = this.length;
        Node currentNode = this.tail.getNext();

        if (this.tail.getData() == data) {
            return length;
        }

        do {
            if (currentNode.getData() == data) return currentIndex;

            currentNode = currentNode.getNext();
            currentIndex++;
        } while (currentNode != this.tail);

        return -1;
    }

    public void print() {
        if (this.length == 0) return;

        Node currentNode = this.tail;
        Node firstNode = this.tail.getNext();

        do {
            System.out.println(firstNode.getData());
            firstNode = firstNode.getNext();
        } while (currentNode.getNext() != firstNode);
    }
}

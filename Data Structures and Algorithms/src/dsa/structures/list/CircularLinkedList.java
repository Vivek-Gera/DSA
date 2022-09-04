package dsa.structures.list;

public class CircularLinkedList {
    // data members
    private Node head;
    private int length;

    // constructor
    public CircularLinkedList() {
        this.head = null;
        this.length = 0;
    }

    // member methods
    public void append(int data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.head = newNode;
            newNode.setNext(this.head);
        } else {
            Node currentNode = this.head;

            while (currentNode.getNext() != this.head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setNext(this.head);
        }
        this.length++;
    }

    public void insert(int position, int data) {
        if (position < 0 || position > this.length || this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);

        Node currentNode = this.head;
        int currentIndex = 0;

        if (position == 0) {
            newNode.setNext(this.head);
            while (currentNode.getNext() != this.head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            this.head = newNode;
        } else {
            while (currentNode.getNext() != this.head) {
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
        Node currentNode = this.head;
        Node previousNode = null;

        if (this.head.getData() == data) {
            while (currentNode.getNext() != this.head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(this.head.getNext());
            this.head = currentNode.getNext();
        }

        do {
            if (currentNode.getData() == data) {
                previousNode.setNext(currentNode.getNext());
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);

        this.length--;
    }

    public void deleteAt(int position) {
        if (position < 0 || position >= this.length || this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = this.head;
        int currentIndex = 0;

        if (position == 0) {
            while (currentNode.getNext() != this.head) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(this.head.getNext());
            this.head = currentNode.getNext();
        } else {
            do {
                if (currentIndex == position - 2) {
                    currentNode.setNext(currentNode.getNext().getNext());
                }
                currentNode = currentNode.getNext();
                currentIndex++;
            } while (currentNode.getNext() != this.head);
        }
        this.length--;

    }


    public boolean contains(int data) {
        Node currentNode = this.head;

        do {
            if (currentNode.getData() == data) return true;
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);
        return false;
    }

    public int search(int data) {
        int currentIndex = 0;
        Node currentNode = this.head;

        do {
            if (currentNode.getData() == data) return currentIndex;

            currentNode = currentNode.getNext();
            currentIndex++;
        } while (currentNode != this.head);
        return -1;
    }

    public void print() {
        if (this.length == 0) return;

        Node currentNode = this.head;

        do {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);

    }


}

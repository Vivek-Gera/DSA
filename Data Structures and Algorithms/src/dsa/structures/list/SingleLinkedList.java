package dsa.structures.list;

public class SingleLinkedList {
    // data members
    private Node head;
    private int length;

    // constructors
    public SingleLinkedList() {
        this.head = null;
        this.length = 0;
    }

    // member methods
    public void append(int data) {
        Node newNode = new Node(data);

        if(this.length == 0) {
            this.head = newNode;
        } else {
            Node currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        this.length++;
    }

    public void insert(int position, int data) {
        if(position < 0 || position > this.length) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);

        if(position == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node currentNode = this.head;
            int currentIndex = 0;

            while (currentNode != null) {
                if(currentIndex == position-1) {
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

        while (currentNode != null) {
            if(currentNode.getData() == data) {
                previousNode.setNext(currentNode.getNext().getNext());
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        this.length--;
    }

    public void deleteAt(int position) {
        if(position < 0 || position >= this.length || this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        if (position == 0 ) {
            Node currentNode = this.head;
            this.head = currentNode.getNext();
        } else {
            int currentIndex = 0;
            Node currentNode = this.head;

            while (currentNode != null) {
                if(currentIndex == position-2) {
                    currentNode.setNext(currentNode.getNext().getNext());
                }
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }
        this.length--;
    }

    public boolean contains(int data) {
        Node currentNode = this.head;

        while (currentNode != null) {
            if(currentNode.getData() == data) return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int search(int data) {
        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentNode != null) {
            if(currentNode.getData() == data) {
                return currentIndex;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return -1;
    }

    public void print() {
        Node currentNode = this.head;

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

}

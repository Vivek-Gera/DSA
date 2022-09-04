package dsa.structures.list;

public class DoubleLinkedList {
    // data members
    private NodeD head;
    private NodeD tail;
    private int length;

    // constructors
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Member methods
    public void append(int data) {
        NodeD newNode = new NodeD(data);

        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.length++;
    }

    public void insert( int position, int data) {
        if(position < 0 || position > this.length) {
            throw new IndexOutOfBoundsException();
        }

        NodeD newNode = new NodeD(data);

        if(position == 0) {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            int length = this.length;

            if (position < length/2) {
                NodeD currentNode = this.head;
                int currentIndex = 0;

                while(currentNode != null) {
                    if(currentIndex == position) {
                        newNode.setNext(currentNode.getNext());
                        newNode.setPrev(currentNode);
                        currentNode.getNext().setPrev(newNode);
                        currentNode.setNext(newNode);
                    }
                    currentNode = currentNode.getNext();
                    currentIndex++;
                }
            } else {
                NodeD currentNode = this.tail;
                int currentIndex = this.length;

                while(currentNode != null) {
                    if(currentIndex == position) {
                        newNode.setPrev(currentNode.getPrev());
                        newNode.setNext(currentNode);
                        currentNode.getPrev().setNext(newNode);
                        currentNode.setPrev(newNode);
                    }
                    currentNode = currentNode.getPrev();
                    currentIndex--;
                }
            }

        }
        this.length++;

    }

    public void delete(int data) {
        NodeD currentNode = this.head;

        while(currentNode != null) {
            if(currentNode.getData() == data) {
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
            }
            currentNode = currentNode.getNext();
        }
        this.length--;
    }

    public void deleteAt(int position) {
        if(position < 0 || position >= this.length || this.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        if(position == 0) {
            this.head = this.head.getNext();
            this.head.setPrev(null);

        } else {
            int length = this.length;
            if(position < length/2) {
                NodeD currentNode = this.head;
                int currentIndex = 0;

                while (currentNode != null) {
                    if(currentIndex == position) {
                        currentNode.getNext().setPrev(currentNode.getPrev());
                        currentNode.getPrev().setNext(currentNode.getNext());
                    }
                    currentNode = currentNode.getNext();
                    currentIndex++;
                }
            } else {
                NodeD currentNode = this.tail;
                int currentIndex = this.length;

                while(currentNode != null) {
                    if(currentIndex == position) {
                        currentNode.getNext().setPrev(currentNode.getPrev());
                        currentNode.getPrev().setNext(currentNode.getNext());
                    }
                    currentNode = currentNode.getPrev();
                    currentIndex--;
                }
            }
        }
        this.length--;
    }

    public boolean contains(int data) {
        NodeD currentNode = this.head;

        while (currentNode != null) {
            if(currentNode.getData() == data) return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int search(int data) {
        int currentIndex = 0;
        NodeD currentNode = this.head;

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
        NodeD currentNode = this.head;

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}

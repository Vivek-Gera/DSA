package dsa.structures.list;

public class CircularDoubleLinkedList {
    // data members
    private NodeD head;
    private int length;

    // constructor
    public CircularDoubleLinkedList() {
        this.head = null;
        this.length = 0;
    }

    // member methods
    public void append(int data) {
        NodeD newNode = new NodeD(data);

        if (this.length == 0) {
            this.head = newNode;
            newNode.setNext(this.head);
            newNode.setPrev(this.head);
        } else {
            newNode.setPrev(this.head.getPrev());
            this.head.getPrev().setNext(newNode);
            this.head.setPrev(newNode);
            newNode.setNext(this.head);

        }
        this.length++;
    }

    public void insert(int position, int data) {
        if (position < 0 || position > this.length) {
            throw new IndexOutOfBoundsException();
        }

        NodeD newNode = new NodeD(data);

        if (position == 0) {
            if(this.length !=0){
                this.head.getPrev().setNext(newNode);
                newNode.setPrev(this.head.getPrev());
                newNode.setNext(this.head);
                this.head.setPrev(newNode);
            } else if (this.length == 0) {
                this.head = newNode;
                newNode.setNext(this.head);
                newNode.setPrev(this.head);
            }
            this.head = newNode;

        } else {
            NodeD currentNode = this.head;
            int currentIndex = 0;
            int length = this.length;

            if (position < length / 2) {
                do {
                    if (currentIndex == position) {
                        currentNode.getNext().setPrev(newNode);
                        newNode.setNext(currentNode.getNext());
                        currentNode.setNext(newNode);
                        newNode.setPrev(currentNode);
                        break;
                    }
                    currentIndex++;
                    currentNode = currentNode.getNext();
                } while (currentNode != this.head);
            } else {
                currentIndex = this.length;
                currentNode = currentNode.getPrev();

                do {
                    if (currentIndex == position) {
                        currentNode.getPrev().setNext(newNode);
                        newNode.setPrev(currentNode.getPrev());
                        currentNode.setPrev(newNode);
                        newNode.setNext(currentNode);
                        break;
                    }
                    currentIndex--;
                    currentNode = currentNode.getPrev();
                } while (currentNode != this.head);
            }
        }
        this.length++;
    }

    public void delete(int data) {
        NodeD currentNode = this.head;
        do {
            if (currentNode.getData() == data) {

                if (this.head.getData() == data) {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                    this.head = currentNode.getNext();
                    break;
                }
                if (currentNode.getData() == currentNode.getPrev().getData()) {
                    currentNode.setPrev(currentNode.getPrev().getPrev());
                    currentNode.getPrev().setNext(this.head);
                }
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
            }
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);
        this.length--;
    }

    public void deleteAt(int position) {
        if (position < 0 || position >= this.length) {
            throw new IndexOutOfBoundsException();
        }

        NodeD currentNode = this.head;
        int currentIndex = 0;
        int length = this.length;

        if (position < length / 2) {

            do {
                if (currentIndex == position) {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                    if (position == 0) {
                        this.head = this.head.getNext();
                    }
                    break;
                }
                currentIndex++;
                currentNode = currentNode.getNext();
            } while (currentNode != this.head);
        } else {
            currentIndex = this.length;
            currentNode = currentNode.getPrev();

            do {
                if (currentIndex == position) {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                    break;
                }
                currentIndex--;
                currentNode = currentNode.getPrev();
            } while (currentNode != this.head);
        }
        this.length--;
    }

    public boolean contains(int data) {
        NodeD currentNode = this.head;

        while (currentNode.getNext() != this.head) {
            if (currentNode.getData() == data) return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int search(int data) {
        int currentIndex = 0;
        NodeD currentNode = this.head;

        while (currentNode.getNext() != this.head) {
            if (currentNode.getData() == data) {
                return currentIndex + 1;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return -1;
    }

    public void print() {
        if (this.length == 0) return;

        NodeD currentNode = this.head;

        do {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        } while (currentNode != this.head);
    }


}

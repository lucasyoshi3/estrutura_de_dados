class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void addToEnd(int value) {
        Node newNode = new Node(value);
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public Integer removeFromFront() {
        if (head == null) {
            return null;
        }

        int removedValue = head.value;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        return removedValue;
    }

    public Integer removeFromEnd() {
        if (tail == null) {
            return null;
        }

        int removedValue = tail.value;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        return removedValue;
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.addToFront(10);
        linkedList.addToFront(25);
        linkedList.addToFront(30);

        linkedList.addToEnd(5);
        linkedList.addToEnd(2);

        System.out.println(linkedList.removeFromFront()); // Output: 30
        System.out.println(linkedList.removeFromEnd());   // Output: 2
    }
}

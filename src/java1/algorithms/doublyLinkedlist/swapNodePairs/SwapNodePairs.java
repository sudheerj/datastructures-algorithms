package java1.algorithms.doublyLinkedlist.swapNodePairs;

class Node {
    public int value;
    public Node next;
    public Node prev;

    Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedlist {
    
    private Node head;
    private Node tail;
    private int length;

    DoublyLinkedlist(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }
    
    public void swapNodePairs(){
        if(this.length < 2) return;
        Node current = this.head;
        Node newHead = this.head.next;

        while (current != null && current.next != null) {
            Node firstNext = current.next;
            Node secondNext = current.next.next;
            Node prev = current.prev;

            if(prev != null) prev.next = firstNext;
            firstNext.next = current;
            current.next = secondNext;

            if(secondNext != null) secondNext.prev = current;
            current.prev = firstNext;
            firstNext.prev = prev;

            current = current.next;
        }

        this.head = newHead;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}


public class SwapNodePairs {
    public static void main(String[] args) {
        DoublyLinkedlist myDoublyLinkedList1 = new DoublyLinkedlist();
        myDoublyLinkedList1.push(1);
        myDoublyLinkedList1.push(2);
        myDoublyLinkedList1.push(3);
        myDoublyLinkedList1.push(4);
        myDoublyLinkedList1.push(5);
        myDoublyLinkedList1.push(6);

        System.out.println("Before swap node pairs:");
        myDoublyLinkedList1.printList();
        System.out.println("After swap  node pairs:");
        myDoublyLinkedList1.swapNodePairs();
        myDoublyLinkedList1.printList();

        DoublyLinkedlist myDoublyLinkedList2 = new DoublyLinkedlist();
        myDoublyLinkedList2.push(1);
        myDoublyLinkedList2.push(2);
        myDoublyLinkedList2.push(3);
        myDoublyLinkedList2.push(4);
        myDoublyLinkedList2.push(5);

        System.out.println("Before swap node pairs:");
        myDoublyLinkedList2.printList();
        System.out.println("After swap  node pairs:");
        myDoublyLinkedList2.swapNodePairs();
        myDoublyLinkedList2.printList();
    }
}

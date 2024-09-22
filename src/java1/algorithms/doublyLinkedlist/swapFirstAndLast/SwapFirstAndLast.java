package java1.algorithms.doublyLinkedlist.swapFirstAndLast;

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
    
    public void swapFirstAndLast(){
        if(this.length <= 1) return;
        int temp = this.head.value;
        this.head.value = this.tail.value;
        this.tail.value = temp;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

public class SwapFirstAndLast {

    public static void main(String[] args) {
        DoublyLinkedlist myDoublyLinkedList = new DoublyLinkedlist();
        myDoublyLinkedList.push(1);
        myDoublyLinkedList.push(2);
        myDoublyLinkedList.push(3);
        myDoublyLinkedList.push(4);
        myDoublyLinkedList.push(5);

        System.out.println("Before swap:");
        myDoublyLinkedList.printList();
        System.out.println("After swap:");
        myDoublyLinkedList.swapFirstAndLast();
        myDoublyLinkedList.printList();
    }
    
}

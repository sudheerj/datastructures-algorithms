package java1.algorithms.doublyLinkedlist.palindromeCheck;

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
    
    public boolean isPalindrome(){
        if(this.length < 2) return true;
        Node forwardNode = this.head;
        Node backwardNode = this.tail;

        for (int i = 0; i < Math.floor(this.length/2); i++) {
            if(forwardNode.value != backwardNode.value) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }

        return true;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

public class PalindromeCheck {
    public static void main(String[] args) {
        DoublyLinkedlist myDoublyLinkedList1 = new DoublyLinkedlist();
        myDoublyLinkedList1.push(1);
        myDoublyLinkedList1.push(2);
        myDoublyLinkedList1.push(3);
        myDoublyLinkedList1.push(2);
        myDoublyLinkedList1.push(1);

        DoublyLinkedlist myDoublyLinkedList2 = new DoublyLinkedlist();
        myDoublyLinkedList2.push(1);
        myDoublyLinkedList2.push(2);
        myDoublyLinkedList2.push(3);
        myDoublyLinkedList2.push(4);
        myDoublyLinkedList2.push(5);

        System.out.println(myDoublyLinkedList1.isPalindrome());
        System.out.println(myDoublyLinkedList2.isPalindrome());
    }
}

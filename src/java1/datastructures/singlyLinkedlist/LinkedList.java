package java1.datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(this.length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node current = head;
        Node newTail = head;
        while(current.next != null) {
            newTail = current;
            current = current.next;
        }
        tail = newTail;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return current;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        Node currentHead = head;
        head = head.next;
        currentHead.next = null;
        this.length--;
        if(length == 0) {
            tail = null;
        }
        return currentHead;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;
        Node current = head;
        for(int i=1; i<= index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean set(int index, int value) {
        Node foundNode = get(index); 
        if(foundNode != null) {
            foundNode.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node prevNode = get(index-1);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length -1) return removeLast();

        Node prevNode = get(index-1);
        Node removedNode = prevNode.next;
        prevNode.next = removedNode.next;
        removedNode.next = null;
        length--;
        return removedNode;
    }

    //TC: O(n) SC: O(1)
    public void reverse() {
        if(length == 0) return;
        Node temp = head;
        head = tail;
        tail = temp;
        Node next = temp.next;
        Node prev = null;
        
        for(int i=0; i< length; i++){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }

    //Recursion: TC: O(n) SC: O(n)
    public Node reverseLL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node rest = reverseLL(head.next);

        head.next.next = head;
        head.next = null;
        return rest;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        return head;
    }
}

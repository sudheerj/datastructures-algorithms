package java1.datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        Node temp = head;
        Node prev = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
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
        Node temp = head;
        head = head.next;
        temp.next = null;
        this.length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for(int i=1; i<= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index); 
        if(temp != null) {
            temp.value = value;
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
        Node after = temp.next;
        Node before = null;
        
        for(int i=0; i< length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //Recursion: TC: O(n) SC: O(n)
    public Node reverseLL() {
        if(head == null || head.next == null) {
            return head;
        }
        return reverseRec(head, null);
    }

    public Node reverseRec(Node head, Node newHead) {
        if(head == null) {
            return newHead;
        }
        Node next = head.next;
        head.next = newHead;
        return reverseRec(next, head);
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

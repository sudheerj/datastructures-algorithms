package java1.datastructures.doublyLinkedlist;

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

public class DoublyLinkedlist {

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

    public Node pop(){
        if(this.head == null) return null;
        Node temp = this.tail;
        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public void unshift(int value){
        Node newNode = new Node(value);
        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public Node shift(){
        if(this.head == null) return null;
        Node temp = this.head;

        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            temp.next = null;
            this.head.prev = null;
        }
        this.length--;
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= this.length) return null;
        if(index == 0) return this.head;
        if(index == this.length-1) return this.tail;

        Node temp = this.head;

        if(index < this.length/2){
            for(int i= 0; i < this.length/2; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length-1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value){
        if(index < 0 || index >= this.length) return false;

        Node temp = this.get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > this.length) return false;
        if(index == 0) {
            this.unshift(value);
            return true;
        }
        if(index == this.length) {
            this.push(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = this.get(index-1);
        Node after = before.next;

        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;

        this.length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index > this.length) return null;
        if(index == 0) return this.shift();
        if(index == this.length) return this.pop();

        Node removedNode = this.get(index);
        Node before = removedNode.prev;
        Node after = removedNode.next;

        before.next = after;
        after.prev = before;
        removedNode.next = null;
        removedNode.prev = null;

        this.length--;
        return removedNode;
    }

    public void reverse(){
        if(this.length <=1) return;

        Node current = this.head;
        Node prev = null;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }

        prev = this.head;
        this.head = this.tail;
        this.tail = prev;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}


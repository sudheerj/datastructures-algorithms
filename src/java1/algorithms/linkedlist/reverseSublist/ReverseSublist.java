package java1.algorithms.linkedlist.reverseSublist;

class Node {
    public int value;
    public Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class ReverseSublist {
    private Node head;
    private Node tail;
    private int length;

    ReverseSublist() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = tail;
            tail = newNode;
        }

        length++;
    }

    public Node reverseBetween(int left, int right) {
        if(head == null || head.next == null || left == right) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node leftPrev = dummy;
        Node current = head;

        for (int i = 0; i < left-1; i++) {
            leftPrev = current;
            current = current.next;
        }

        Node prev = null;

        for (int i = 0; i < right-left+1; i++) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        leftPrev.next.next = current;
        leftPrev.next = prev;

        head = dummy.next;

        return head;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReverseSublist myReverseSublist = new ReverseSublist();
        myReverseSublist.append(1);
        myReverseSublist.append(2);
        myReverseSublist.append(3);
        myReverseSublist.append(4);
        myReverseSublist.append(5);
        myReverseSublist.append(6);

        myReverseSublist.reverseBetween(2, 5);

        myReverseSublist.printList();
    }
}



package java1.algorithms.linkedlist.basics.detectLoop;

import java1.algorithms.linkedlist.Node;

public class DetectLoop {
    //TC: O(n) SC: O(1)
    private static boolean hasLoop(Node head) {
        if(head == null) {
            return false;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // Build linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        // Create loop: 6 -> 3
        node6.setNext(node3);

        boolean containsLoop = hasLoop(head);

        System.out.println("Contains loop: " + containsLoop);
    }
}

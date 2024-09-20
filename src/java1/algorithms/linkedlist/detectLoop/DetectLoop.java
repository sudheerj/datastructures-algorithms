package java1.algorithms.linkedlist.detectLoop;

import java1.algorithms.linkedlist.Node;

public class DetectLoop {
    private static boolean hasLoop(Node head) {
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
        Node headNode = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        headNode.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(headNode);

        System.out.println(hasLoop(headNode));
    }
}

package java1.algorithms.linkedlist.removeKthNodeFromEnd;

import java1.algorithms.linkedlist.Node;

public class RemoveKthNodeFromEnd {
    // Using Two pointers:- TC: O(n) SC: O(1)
    private static Node removeKthNode(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy;
        Node second = head;

        while(n > 0 && second != null) {
            second = second.next;
            n--;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    private static void printLinkedlist(Node head) {
        while(head != null) {
            System.out.println(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node headNode1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node headNode2 = new Node(3);
        
        headNode1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        printLinkedlist(removeKthNode(headNode1, 2));
        printLinkedlist(removeKthNode(headNode2, 1));
    }
}

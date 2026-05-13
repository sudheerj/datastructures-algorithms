package java1.algorithms.linkedlist.rearrangement.reorderList;

import java1.algorithms.linkedlist.Node;

public class ReorderList {
    // TC: O(n) SC: O(1)
    private static void reorderList(Node head) {
        if(head == null) return;

        //Step1: Find middle node
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step2: Split and Reverse the second partition
        Node secondHalf = slow.next;
        Node prev = slow.next = null;

        while(secondHalf != null) {
            Node temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }

        //Step3: Re-order the list
        Node firstHalf = head;
        secondHalf = prev;

        while(secondHalf != null) {
            Node temp1 = firstHalf.next, temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            secondHalf = temp2;
            firstHalf = temp1;
        }

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

        headNode1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        Node headNode2 = null;
        
        reorderList(headNode1);
        reorderList(headNode2);
        printLinkedlist(headNode1);
        printLinkedlist(headNode2);
    }
}

package java1.algorithms.linkedlist.mergeTwoSortedLists;

import java1.algorithms.linkedlist.Node;

public class MergeTwoSortedLists {
    //TC: O(m+n) SC:O(1)
    private static Node mergeSortedLists(Node l1, Node l2) {
        Node dummyNewHead = new Node(-1);
        Node current = dummyNewHead;
        while(l1 != null & l2 != null) {
            if(l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 == null) {
            current.next = l2;
        }
        if(l2 == null) {
            current.next = l1;
        }
        return dummyNewHead.next;
    }

    //Recursive approach
    private static Node mergeSortedListsRecursion(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.value < l2.value) {
            l1.next = mergeSortedListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSortedListsRecursion(l1, l2.next);
            return l2;
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
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        Node headNode2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(6);

        Node headNode3 = new Node(10);
        Node node6 = new Node(20);
        Node node7 = new Node(30);

        Node headNode4 = new Node(5);
        Node node8 = new Node(15);
        Node node9 = new Node(25);
        Node node10 = new Node(35);
        Node node11 = new Node(45);

        headNode1.setNext(node2);
        node2.setNext(node3);

        headNode2.setNext(node4);
        node4.setNext(node5);

        headNode3.setNext(node6);
        node6.setNext(node7);

        headNode4.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);

        printLinkedlist(mergeSortedLists(headNode1, headNode2));
        System.out.println("---------------------");
        printLinkedlist(mergeSortedListsRecursion(headNode3, headNode4));
    }
}

package java1.algorithms.linkedlist.removeDuplicates;

import java.util.HashSet;

import java1.algorithms.linkedlist.Node;

public class RemoveDuplicates {
    private static Node removeDuplicates(Node head){
        HashSet<Integer> noDuplicates = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if(noDuplicates.contains(current.value)) {
                prev.next = current.next;
            } else {
                noDuplicates.add(current.value);
                prev = current;
            }

            current = current.next;
        }

        return head;
    }

    private static void printLinkedlist(Node head) {
        while(head != null) {
            System.out.println(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node headNode = new Node(4);
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(4);

        headNode.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        printLinkedlist(removeDuplicates(headNode));
    }
}

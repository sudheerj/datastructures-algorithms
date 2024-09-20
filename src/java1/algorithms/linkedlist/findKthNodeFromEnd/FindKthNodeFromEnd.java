package java1.algorithms.linkedlist.findKthNodeFromEnd;

import java1.algorithms.linkedlist.Node;

public class FindKthNodeFromEnd {
    private static Node findKthNodeFromEnd(Node head, int k) {
        Node first = head;
        Node second = head;

        for(int i=0; i<k; i++){
            if(first == null) return null;
            first = first.next;
        }

        while (first != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }

    public static void main(String[] args) {
        Node headNode = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        headNode.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println(findKthNodeFromEnd(headNode, 2).value);
        System.out.println(findKthNodeFromEnd(headNode, 5).value);
    }
}

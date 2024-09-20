package java1.algorithms.linkedlist.binaryToDecimal;

import java1.algorithms.linkedlist.Node;

public class BinaryToDecimal {
    private static int binaryToDecimal(Node head, int length){
        Node current = head;
        int decimal = 0;

        for (int i= length-1; i>=0; i--) {
            decimal += Math.pow(2, i) * current.value;
            current = current.next;
        }

        return decimal;
    }

    private static int binaryToDecimalDoubling(Node head){
        Node current = head;
        int decimal = 0;

        while(current != null) {
            decimal = decimal * 2 + current.value;
            current = current.next;
        }

        return decimal;
    }

    public static void main(String[] args) {
        Node headNode1 = new Node(1);
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        Node node3 = new Node(1);

        headNode1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node headNode2 = new Node(1);
        Node node4 = new Node(0);
        Node node5 = new Node(1);
        Node node6 = new Node(1);

        headNode2.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        System.out.println(binaryToDecimalDoubling(headNode1));
        System.out.println(binaryToDecimalDoubling(headNode2));

        System.out.println(binaryToDecimal(headNode1, 4));
        System.out.println(binaryToDecimal(headNode2, 4));
    }
}

package java1.algorithms.linkedlist.basics.findMiddleNode;

import java1.algorithms.linkedlist.Node;

public class FindMiddleNode {

    //Floyd's Tortoise and Hare algorithm
    private static Node findMiddleNode(Node head) {
        if(head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {

        // Odd length list
        //
        // 1 -> 2 -> 3 -> 4 -> 5
        //
        Node headNode1 = new Node(1);

        headNode1.setNext(new Node(2));
        headNode1.next.setNext(new Node(3));
        headNode1.next.next.setNext(new Node(4));
        headNode1.next.next.next.setNext(new Node(5));

        // Even length list
        //
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //
        Node headNode2 = new Node(1);

        headNode2.setNext(new Node(2));
        headNode2.next.setNext(new Node(3));
        headNode2.next.next.setNext(new Node(4));
        headNode2.next.next.next.setNext(new Node(5));
        headNode2.next.next.next.next.setNext(
                new Node(6));

        printMiddleNode(headNode1);

        printMiddleNode(headNode2);
    }

    private static void printMiddleNode(Node head) {

        Node middleNode = findMiddleNode(head);

        if (middleNode != null) {

            System.out.println(
                    "Middle node value: "
                            + middleNode.value);
        }
    }
}


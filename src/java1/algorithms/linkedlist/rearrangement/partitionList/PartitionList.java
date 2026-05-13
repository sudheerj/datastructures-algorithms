package java1.algorithms.linkedlist.rearrangement.partitionList;

import java1.algorithms.linkedlist.Node;

public class PartitionList {
    //Split into 2 separate lists(smaller and greater), then join them. TC:O(n), SC: O(1)
    private static Node partitionList(Node head, int x){
        //dummy nodes
        Node smallerDummy = new Node(0);
        Node greaterDummy = new Node(0);

        //pointers
        Node smallerTrail = smallerDummy;
        Node greaterTrail = greaterDummy;

        Node current = head;

        while (current != null) {
            if(current.value < x){
                smallerTrail.next = current;
                smallerTrail = current;
            } else {
                greaterTrail.next = current;
                greaterTrail = current;
            }
            current = current.next;
        }

        //connect lists
        smallerTrail.next = greaterDummy.next;
        //avoid cycle
        greaterTrail.next = null;

        return smallerDummy.next;
    }

    private static void printLinkedlist(Node head) {
        while(head != null) {
            System.out.println(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node headNode1 = new Node(7);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(3);
        Node node4 = new Node(5);
        Node node5 = new Node(4);
        Node node6 = new Node(8);

        headNode1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        Node headNode2 = new Node(3);
        Node node7 = new Node(2);

        headNode2.setNext(node7);

        printLinkedlist(partitionList(headNode1, 5));
        printLinkedlist(partitionList(headNode2, 3));
    }
}

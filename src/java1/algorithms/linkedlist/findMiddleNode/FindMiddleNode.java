package java1.algorithms.linkedlist.findMiddleNode;

import java1.algorithms.linkedlist.Node;

public class FindMiddleNode {

    //Floyd's Tortoise and Hare algorithm
    private static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
          Node headNode1 = new Node(1);
          Node node2 = new Node(2);
          Node node3 = new Node(3);
          Node node4 = new Node(4);
          Node node5 = new Node(5);

          Node headNode2 = new Node(1);
          Node node6 = new Node(2);
          Node node7 = new Node(3);
          Node node8 = new Node(4);
          Node node9 = new Node(5);
          Node node10 = new Node(6);


          headNode1.setNext(node2);
          node2.setNext(node3);
          node3.setNext(node4);
          node4.setNext(node5);

          headNode2.setNext(node6);
          node6.setNext(node7);
          node7.setNext(node8);
          node8.setNext(node9);
          node9.setNext(node10);

          System.out.println(findMiddleNode(headNode1).value);
          System.out.println(findMiddleNode(headNode2).value);
    }
}


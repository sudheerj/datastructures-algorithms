package java1.algorithms.linkedlist.basics.removeKthNodeFromEnd;

import java1.algorithms.linkedlist.Node;

public class RemoveKthNodeFromEnd {
    // Using Two pointers:- TC: O(n) SC: O(1)
    private static Node removeKthNode(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for(int i=0; i<=n; i++) {
            if(fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    private static void printLinkedlist(Node head) {
        System.out.println("---------");
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

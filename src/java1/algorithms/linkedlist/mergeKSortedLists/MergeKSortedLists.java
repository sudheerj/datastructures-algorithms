package java1.algorithms.linkedlist.mergeKSortedLists;

import java1.algorithms.linkedlist.Node;

public class MergeKSortedLists {
    // TC: O(n log k) SC: O(1)
    private static Node mergeKLists(Node[] lists) {
        int length = lists.length;
        if(length == 0) return null;

        int interval = 1;

        while (interval < length) {
            for(int i= 0; i+interval < length; i= i+ interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval = 2 * interval;
        }
        return lists[0];
    }

    private static Node mergeTwoLists(Node l1, Node l2) {
        Node newHead = new Node(-1);
        Node currNode = newHead;

        while(l1 != null && l2 != null) {
            if(l1.value < l2.value) {
                currNode.next = l1;
                l1 = l1.next; 
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        if(l1 == null) currNode.next = l2;
        if(l2 == null) currNode.next = l1;

        return newHead.next;
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

        Node headNode2 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
 
        Node headNode3 = new Node(7);
        Node node6 = new Node(8);
        Node node7 = new Node(9);

        Node headNode4 = new Node(10);
        Node node8 = new Node(11);
        Node node9 = new Node(12);

        headNode1.setNext(node2);
        node2.setNext(node3);

        headNode2.setNext(node4);
        node4.setNext(node5);

        headNode3.setNext(node6);
        node6.setNext(node7);

        headNode4.setNext(node8);
        node8.setNext(node9);

        Node[] lists = new Node[4];
        lists[0] = headNode1;
        lists[1] = headNode2;
        lists[2] = headNode3;
        lists[3] = headNode4;

        printLinkedlist(mergeKLists(lists));
    }
}

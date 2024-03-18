package java1.algorithms.linkedlist;

public class MergeTwoSortedLists {
    //TC: O(m+n) SC:O(1)
    private static Node mergeSortedLists(Node l1, Node l2) {
        Node newHead = new Node(-1);
        Node p1 = l1, p2 = l2, currNode = newHead;
        while(p1 != null & p2 != null) {
            if(p1.value < p2.value) {
                currNode.next = p1;
                p1 = p1.next;
            } else {
                currNode.next = p2;
                p2 = p2.next;
            }
            currNode = currNode.next;
        }
        if(p1 == null) {
            currNode.next = p2;
        }
        if(p2 == null) {
            currNode.next = p1;
        }
        return newHead.next;
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
        Node headNode1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);

        Node headNode2 = new Node(5);
        Node node7 = new Node(15);
        Node node8 = new Node(25);
        Node node9 = new Node(35);
        Node node10 = new Node(45);
        Node node11 = new Node(55);
 

        headNode1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        headNode2.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);

        printLinkedlist(mergeSortedLists(headNode1, headNode2));
        printLinkedlist(mergeSortedListsRecursion(headNode1, headNode2));
    }
}

package java1.algorithms.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    //TC: O(n * logk) SC: O(k)
    private Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.value - node2.value;
            }
        });
        for(Node head: lists) {
            if(head != null) {
                queue.offer(head);
            }
        }

        Node dummyHead = new Node(0);
        Node curr = dummyHead;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return dummyHead.next;
    }

    private void printLinkedlist(Node head) {
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
 
        Node headNode3 = new Node(7);
        Node node12 = new Node(18);
        Node node13 = new Node(22);
        Node node14 = new Node(33);
        Node node15 = new Node(44);
        Node node16 = new Node(55);

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

        headNode3.setNext(node12);
        node12.setNext(node13);
        node13.setNext(node14);
        node14.setNext(node15);
        node15.setNext(node16);

        Node[] lists = new Node[3];
        lists[0] = headNode1;
        lists[1] = headNode2;
        lists[2] = headNode3;

        MergeKSortedLists mergedSortedLists = new MergeKSortedLists();
        mergedSortedLists.printLinkedlist(mergedSortedLists.mergeKLists(lists));
    }
}

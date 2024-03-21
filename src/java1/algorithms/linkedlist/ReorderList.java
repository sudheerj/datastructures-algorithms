package java1.algorithms.linkedlist;

public class ReorderList {
    // TC: O(n) SC: O(1)
    private static Node reorderList(Node head) {
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        Node prev = slow.next = null;
        //Reverse the second partition
        while(secondHalf != null) {
            Node temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }

        Node firstHalf = head;
        secondHalf = prev;
        //Re-order the list
        while(secondHalf != null) {
            Node temp1 = firstHalf.next, temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            secondHalf = temp2;
            firstHalf = temp1;
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
        Node headNode1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);

        headNode1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        
        printLinkedlist(reorderList(headNode1));
    }
}

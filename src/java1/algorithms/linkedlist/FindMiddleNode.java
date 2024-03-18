package java1.algorithms.linkedlist;


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
          Node headNode = new Node(10);
          Node node2 = new Node(20);
          Node node3 = new Node(30);
          Node node4 = new Node(40);
          Node node5 = new Node(50);
          Node node6 = new Node(60);
          Node node7 = new Node(70);
          Node node8 = new Node(80);

          headNode.setNext(node2);
          node2.setNext(node3);
          node3.setNext(node4);
          node4.setNext(node5);
          node5.setNext(node6);
          node6.setNext(node7);
          node7.setNext(node8);

          System.out.println(findMiddleNode(headNode).value);
    }
}


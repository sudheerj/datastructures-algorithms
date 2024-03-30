package java1.algorithms.heap;

public class Node {

    public Node next;
    public int value;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
  
}

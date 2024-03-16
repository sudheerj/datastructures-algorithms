package java1.datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        //Append
        myLinkedList.append(2);
        myLinkedList.append(3);

        myLinkedList.printList();
        //RemoveLast
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast());
        //Prepend
        //RemoveFirst
    }
}

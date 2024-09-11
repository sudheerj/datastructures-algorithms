package java1.datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        //Append
        myLinkedList.append(3);
        myLinkedList.append(4);

        myLinkedList.printList();
        //RemoveLast
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast());
        //Prepend
        myLinkedList.prepend(1);
        myLinkedList.prepend(0);
        //Get
        System.out.println(myLinkedList.get(1).value);
        System.out.println(myLinkedList.get(-1));
        //Set
        System.out.println(myLinkedList.set(1, 2));
        System.out.println(myLinkedList.set(0, 1));
        System.out.println(myLinkedList.set(2, 3));
        myLinkedList.printList();
        //RemoveFirst
        System.out.println(myLinkedList.removeFirst().value);
        System.out.println(myLinkedList.removeFirst().value);
        System.out.println(myLinkedList.removeFirst());
        //Insert at index
        myLinkedList.append(1);
        myLinkedList.append(3);
        System.out.println(myLinkedList.insert(1, 2));
        System.out.println(myLinkedList.insert(3, 4));
        myLinkedList.printList();
        //Remove at index
        System.out.println(myLinkedList.remove(2).value);
        myLinkedList.printList();
        //Reverse
        System.out.println("Reversed linkedlist");
        myLinkedList.reverse();
        myLinkedList.printList();
        //Reverse recursively
        System.out.println("Reversed linkedlist");
        myLinkedList.reverseLL(myLinkedList.getHead());
        myLinkedList.printList();
    }
}

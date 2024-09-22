package java1.datastructures.doublyLinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedlist myDoublyLinkedList = new DoublyLinkedlist();
        System.out.println("Push elements:");
        myDoublyLinkedList.push(1);
        myDoublyLinkedList.push(2);
        myDoublyLinkedList.push(3);
        myDoublyLinkedList.push(4);

        myDoublyLinkedList.printList();

        System.out.println("Pop elements:");

        System.out.println(myDoublyLinkedList.pop().value); 
        System.out.println(myDoublyLinkedList.pop().value);
        
        System.out.println("Elements after Unshift:");

        myDoublyLinkedList.unshift(0);
        myDoublyLinkedList.unshift(-1);

        myDoublyLinkedList.printList();

        System.out.println("Shift elements:");

        System.out.println(myDoublyLinkedList.shift().value); 
        System.out.println(myDoublyLinkedList.shift().value);

        System.out.println("Get elements:");

        System.out.println(myDoublyLinkedList.get(1).value);
        System.out.println(myDoublyLinkedList.get(0).value); 

        System.out.println("Set elements:");

        System.out.println(myDoublyLinkedList.set(0, 100));
        System.out.println(myDoublyLinkedList.set(10, 200));

        System.out.println("Insert elements:");
        
        System.out.println(myDoublyLinkedList.insert(0, 100));
        System.out.println(myDoublyLinkedList.insert(2, 300));
        System.out.println(myDoublyLinkedList.insert(-1, 50));

        System.out.println("Remove elements:");

        System.out.println(myDoublyLinkedList.remove(2).value);
        System.out.println(myDoublyLinkedList.remove(-10));

        System.out.println("Reverse elements:");

        myDoublyLinkedList.reverse();
        myDoublyLinkedList.printList();

        myDoublyLinkedList.reverse();
        myDoublyLinkedList.printList();
    }
}

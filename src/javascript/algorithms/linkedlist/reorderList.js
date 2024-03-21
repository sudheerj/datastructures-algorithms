 // TC: O(n) SC: O(1)

function reorderList(head) {
    let slow = head, fast = head.next;
    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let secondHalf = slow.next;
    let prev = slow.next = null;
    //Reverse the second half of linkedlist
    while(secondHalf != null) {
        let temp = secondHalf.next;
        secondHalf.next = prev;
        prev = secondHalf;
        secondHalf = temp;
    }

    let firstHalf = head;
    secondHalf = prev;
    //Re-order the full list
    while(secondHalf != null) {
        let temp1 = firstHalf.next, temp2 = secondHalf.next;
        firstHalf.next = secondHalf;
        secondHalf.next = temp1;
        firstHalf = temp1;
        secondHalf = temp2;
    }
    return head;
}

function printLinkedList(head) {
    let temp = head;
    while(temp != null) {
        console.log(temp.value + " ");
        temp = temp.next;
    }
}

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }

    setNext(next) {
        this.next = next;
    }
}

let headNode1 = new Node(10);
let node2 = new Node(20);
let node3 = new Node(30);
let node4 = new Node(40);
let node5 = new Node(50);
let node6 = new Node(60);

headNode1.setNext(node2);
node2.setNext(node3);
node3.setNext(node4);
node4.setNext(node5);
node5.setNext(node6);

printLinkedList(reorderList(headNode1));
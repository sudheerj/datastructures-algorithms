 // TC: O(n) SC: O(1)

function reorderList(head) {
    if(head === null) return;
    
    //Find middle
    let slow = head, fast = head;
    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    //Reverse the second half of linkedlist
    let secondHalf = slow.next;
    let prev = slow.next = null;
    while(secondHalf != null) {
        let temp = secondHalf.next;
        secondHalf.next = prev;
        prev = secondHalf;
        secondHalf = temp;
    }

    //Re-order the full list
    let firstHalf = head;
    secondHalf = prev;
    while(secondHalf != null) {
        let temp1 = firstHalf.next, temp2 = secondHalf.next;
        firstHalf.next = secondHalf;
        secondHalf.next = temp1;
        firstHalf = temp1;
        secondHalf = temp2;
    }
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

let headNode1 = new Node(1);
let node2 = new Node(2);
let node3 = new Node(3);
let node4 = new Node(4);
let node5 = new Node(5);
let node6 = new Node(6);

headNode1.setNext(node2);
node2.setNext(node3);
node3.setNext(node4);
node4.setNext(node5);
node5.setNext(node6);

let headNode2 = null;

reorderList(headNode1)
printLinkedList(headNode1);

reorderList(headNode2)
printLinkedList(headNode2);
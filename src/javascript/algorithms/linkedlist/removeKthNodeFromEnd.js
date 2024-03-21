// Using Two pointers:- TC: O(n) SC: O(1)

function removeKthNode(head, n) {
    let dummy = new Node(-1);
    dummy.next = head;
    let first = dummy, second = head;

    while(n >0 && second != null) {
        second = second.next;
        n--;
    }

    while(first != null && second != null) {
        first = first.next;
        second = second.next;
    }

    first.next = first.next.next;
    return dummy.next;
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

printLinkedList(removeKthNode(headNode1, 2));
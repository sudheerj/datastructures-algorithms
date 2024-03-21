// TC: O(n log k) SC: O(1)

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }

    setNext(next) {
        this.next = next;
    }
}

function mergeKLists(list) {
    let length = list.length;
    let interval = 1;

    while(interval < length) {
        for(let i=0; i+interval < length; i += 2* interval) {
            list[i] = mergeTwoSortedLists(list[i], list[i+interval]);
        }
        interval *= 2;
    }
    return list[0];
}

function mergeTwoSortedLists(l1, l2) {
    let newHead = new Node(-1);
    let currNode = newHead;

    while(l1 != null && l2 != null) {
        if(l1.value < l2.value) {
            currNode.next = l1;
            l1 = l1.next;
        } else {
            currNode.next = l2;
            l2 = l2.next;
        }
        currNode = currNode.next;
    }
    if(l1 === null) currNode.next = l2;
    if(l2 === null) currNode.next = l1;

    return newHead.next;
}

function printLinkedList(head) {
    let temp = head;
    while(temp != null) {
        console.log(temp.value + " ");
        temp = temp.next;
    }
}

let headNode1 = new Node(10);
let node2 = new Node(20);
let node3 = new Node(30);
let node4 = new Node(40);
let node5 = new Node(50);
let node6 = new Node(60);

let headNode2 = new Node(5);
let node7 = new Node(15);
let node8 = new Node(25);
let node9 = new Node(35);
let node10 = new Node(45);
let node11 = new Node(55);

let headNode3 = new Node(7);
let node12 = new Node(18);
let node13 = new Node(22);
let node14 = new Node(33);
let node15 = new Node(44);
let node16 = new Node(55);

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

let lists = [];
lists[0] = headNode1;
lists[1] = headNode2;
lists[2] = headNode3;

printLinkedList(mergeKLists(lists));
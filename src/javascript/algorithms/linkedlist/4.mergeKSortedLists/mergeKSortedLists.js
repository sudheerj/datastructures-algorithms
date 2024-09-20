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

function mergeKLists(lists) {
    let length = lists.length;
    let interval = 1;

    while(interval < length) {
        for(let i=0; i+interval < length; i += 2* interval) {
            lists[i] = mergeTwoSortedLists(lists[i], lists[i+interval]);
        }
        interval *= 2;
    }
    return lists[0];
}

function mergeTwoSortedLists(l1, l2) {
    let dummyNewHead = new Node(-1);
    let current = dummyNewHead;

    while(l1 != null && l2 != null) {
        if(l1.value < l2.value) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    
    current.next = l1 || l2;

    return dummyNewHead.next;
}

function printLinkedList(head) {
    let temp = head;
    while(temp != null) {
        console.log(temp.value + " ");
        temp = temp.next;
    }
}

let headNode1 = new Node(1);
let node2 = new Node(2);
let node3 = new Node(3);

let headNode2 = new Node(4);
let node4 = new Node(5);
let node5 = new Node(6);


let headNode3 = new Node(7);
let node6 = new Node(8);
let node7 = new Node(9);

let headNode4 = new Node(10);
let node8 = new Node(11);
let node9 = new Node(12);

headNode1.setNext(node2);
node2.setNext(node3);

headNode2.setNext(node4);
node4.setNext(node5);

headNode3.setNext(node6);
node6.setNext(node7);

headNode4.setNext(node8);
node8.setNext(node9);


let lists = [];
lists[0] = headNode1;
lists[1] = headNode2;
lists[2] = headNode3;
lists[3] = headNode4;

printLinkedList(mergeKLists(lists));
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }

    setNext(next) {
        this.next = next;
    }
}

//TC: O(m+n) SC:O(1)
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
    return newHead.next;
}

//Recursion approach: TC: O(m+n) SC:O(m+n)
function mergeTwoSortedListsRecursion(l1, l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if(l1.value < l2.value) {
        l1.next = mergeTwoSortedListsRecursion(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoSortedListsRecursion(l1, l2.next);
        return l2;
    }
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

printLinkedList(mergeTwoSortedLists(headNode1, headNode2));
printLinkedList(mergeTwoSortedListsRecursion(headNode1, headNode2));

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    constructor(value) {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    push(value) {
        const newNode = new Node(value);
        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    swapPairs() {
        if(this.length < 2) return;
        let current = this.head;
        let newHead = this.head.next;
        
        while(current !== null && current.next !== null) {
            let firstNext = current.next;
            let secondNext = current.next.next;
            let prev = current.prev;
            
            if(prev) prev.next = firstNext;
            firstNext.next = current;
            current.next = secondNext;
            
            if(secondNext) secondNext.prev = current;
            current.prev = firstNext;
            firstNext.prev = prev;
            
            current = current.next;
        }
        this.head = newHead;
    }

}

let myDoublyLinkedList1 = new DoublyLinkedList();
myDoublyLinkedList1.push(1);
myDoublyLinkedList1.push(2);
myDoublyLinkedList1.push(3);
myDoublyLinkedList1.push(4);
myDoublyLinkedList1.push(5);
myDoublyLinkedList1.push(6);

let myDoublyLinkedList2 = new DoublyLinkedList();
myDoublyLinkedList2.push(1);
myDoublyLinkedList2.push(2);
myDoublyLinkedList2.push(3);
myDoublyLinkedList2.push(4);
myDoublyLinkedList2.push(5);

console.log("Before swap node pairs")
console.dir(myDoublyLinkedList1, {depth: null});
console.log("After swap node pairs")
myDoublyLinkedList1.swapPairs();
console.dir(myDoublyLinkedList1, {depth: null});

console.log("Before swap node pairs")
console.dir(myDoublyLinkedList2, {depth: null});
console.log("After swap node pairs")
myDoublyLinkedList2.swapPairs();
console.dir(myDoublyLinkedList2, {depth: null});
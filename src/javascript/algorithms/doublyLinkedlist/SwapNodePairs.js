class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    constructor(value) {
        const newNode = new Node(value);
        this.head = newNode;
        this.tail = this.head;
        this.length = 1;
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

let myDoublyLinkedList = new DoublyLinkedList(1);
myDoublyLinkedList.push(2);
myDoublyLinkedList.push(3);
myDoublyLinkedList.push(4);
myDoublyLinkedList.push(5);
myDoublyLinkedList.push(6);

myDoublyLinkedList.swapNodePairs();
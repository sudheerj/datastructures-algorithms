class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
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
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    findKthNodeFromEnd(k) {
        let first = this.head;
        let second = this.head;
        for (let i = 0; i < k; i++) {
            if (first === null) return null;
            first = first.next;
        }

        while(first != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }
}

const myLinkedList = new LinkedList();
myLinkedList.push(1);
myLinkedList.push(2);
myLinkedList.push(3);
myLinkedList.push(4);
myLinkedList.push(5);

console.dir(myLinkedList.findKthNodeFromEnd(2),{depth: null});
console.dir(myLinkedList.findKthNodeFromEnd(5),{depth: null});

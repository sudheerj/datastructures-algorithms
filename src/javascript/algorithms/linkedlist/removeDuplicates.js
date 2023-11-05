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

    removeDuplicates() {
        const noDuplicates = new Set();
        let current = this.head;
        let prev = null;
        
        while(current !== null) {
            if(noDuplicates.has(current.value)) {
                prev.next = current.next;
                this.length--;
            } else {
                noDuplicates.add(current.value);
                prev = current;
            }
        }
        current = current.next;
    }

}

const myLinkedList = new LinkedList();
myLinkedList.push(4);
myLinkedList.push(5);
myLinkedList.push(4);
myLinkedList.push(1);
myLinkedList.push(2);
myLinkedList.push(3);
myLinkedList.push(2);
myLinkedList.push(4);


myLinkedList.removeDuplicates();

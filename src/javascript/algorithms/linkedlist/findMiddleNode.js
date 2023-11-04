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

    findMiddleNodeWithLength() {
        let temp = this.head;
        for(let i = 0; i < Math.floor(this.length/2); i++) {
            temp = temp.next;
        }
        return temp;
    }

    findMiddleNode() {
        let slow = this.head;
        let fast = this.head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

const myLinkedList = new LinkedList();
myLinkedList.push(1);
myLinkedList.push(2);
myLinkedList.push(3);
myLinkedList.push(4);
myLinkedList.push(5);

myLinkedList.findMiddleNode();
myLinkedList.findMiddleNodeWithLength();
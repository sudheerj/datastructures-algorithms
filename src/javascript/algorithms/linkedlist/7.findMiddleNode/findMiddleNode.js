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

    findMiddleNode() {
        let slow = this.head;
        let fast = this.head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    findMiddleNodeWithLength() {
        let temp = this.head;
        for(let i = 0; i < Math.floor(this.length/2); i++) {
            temp = temp.next;
        }
        return temp;
    }
}

const myLinkedList1 = new LinkedList();
myLinkedList1.push(1);
myLinkedList1.push(2);
myLinkedList1.push(3);
myLinkedList1.push(4);
myLinkedList1.push(5);

const myLinkedList2 = new LinkedList();
myLinkedList2.push(1);
myLinkedList2.push(2);
myLinkedList2.push(3);
myLinkedList2.push(4);
myLinkedList2.push(5);
myLinkedList2.push(6);

console.log(myLinkedList1.findMiddleNode());
console.log(myLinkedList1.findMiddleNodeWithLength());

console.log(myLinkedList2.findMiddleNode());
console.log(myLinkedList2.findMiddleNodeWithLength());
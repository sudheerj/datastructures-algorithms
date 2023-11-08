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

    binaryToDecimal() {
        let current = this.head;
        let decimal = 0;
        for (let i = this.length -1; i >=0; i--) {
            decimal += Math.pow(2, i) * current.value;
            current = current.next;
        }
        return decimal;
    }
    
    binaryToDecimalDoublingMethod() {
        let current = this.head;
        let decimal = 0;
        while(current !== null) {
            decimal = decimal * 2 + current.value;
            current = current.next;
        }
        return decimal;
    }
}

const myLinkedList = new LinkedList();
myLinkedList.push(1);
myLinkedList.push(0);
myLinkedList.push(0);
myLinkedList.push(1);

myLinkedList.binaryToDecimalDoublingMethod();

const myLinkedList1 = new LinkedList();
myLinkedList1.push(1);
myLinkedList1.push(0);
myLinkedList1.push(1);
myLinkedList1.push(1);

myLinkedList1.binaryToDecimal();


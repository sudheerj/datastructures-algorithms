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

    isPalindrome() {
        if(this.length < 2) return true;
        let forwardNode = this.head;
        let backwardNode = this.tail;
        
        for(let i=0; i < Math.floor(this.length/2); i++) {
            if (forwardNode.value !== backwardNode.value) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        
        return true; 
    }

}

let myDoublyLinkedList = new DoublyLinkedList(1);
myDoublyLinkedList.push(2);
myDoublyLinkedList.push(3);
myDoublyLinkedList.push(2);
myDoublyLinkedList.push(1);

let myDoublyLinkedList1 = new DoublyLinkedList(1);
myDoublyLinkedList1.push(2);
myDoublyLinkedList1.push(3);
myDoublyLinkedList1.push(4);
myDoublyLinkedList1.push(5);

myDoublyLinkedList.isPalindrome();
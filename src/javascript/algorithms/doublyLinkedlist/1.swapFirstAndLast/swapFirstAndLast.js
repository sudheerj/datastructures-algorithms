class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    constructor() {
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

    swapFirstLast() {
        if(this.length <=1) return;
        const temp = this.head.value;
        this.head.value = this.tail.value;
        this.tail.value = temp;
    }

}

let myDoublyLinkedList = new DoublyLinkedList();
myDoublyLinkedList.push(1);
myDoublyLinkedList.push(2);
myDoublyLinkedList.push(3);
myDoublyLinkedList.push(4);
myDoublyLinkedList.push(5);

console.log("Before swap elements");
console.dir(myDoublyLinkedList, {depth: null});

console.log("After swap elements");
myDoublyLinkedList.swapFirstLast();
console.dir(myDoublyLinkedList, {depth: null});
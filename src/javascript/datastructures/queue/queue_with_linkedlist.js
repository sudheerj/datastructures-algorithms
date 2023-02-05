class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class MyQueue {
    constructor() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    enqueue(value) {
        const newNode = new Node(value);
        if(this.length === 0) {
            this.first = newNode;
            this.last = newNode; 
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
        return this;
    }

    dequeue() {
        if(this.length === 0) {
            return null;
        }
        const nextQueueNode = this.first;
        this.first = this.first.next;
        this.length--;
        return nextQueueNode;
    }

    peek() {
        return this.first;
    }

    isEmpty() {
        return this.length === 0;
    }
}

const myQueue = new MyQueue();
myQueue.enqueue("One");
myQueue.enqueue("Two");
myQueue.enqueue("Three");
myQueue.peek();
myQueue.dequeue();
myQueue.dequeue();
myQueue.isEmpty();
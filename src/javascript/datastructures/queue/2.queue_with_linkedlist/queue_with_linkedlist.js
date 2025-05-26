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

    // Core queue operations
    enqueue(value) {
        const newNode = new Node(value);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }

        const temp = this.first;
        if (this.length === 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }

        this.length--;
        return temp.value;
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        return this.first.value;
    }

    // Helper functions
    isEmpty() {
        return this.length === 0;
    }

    size() {
        return this.length;
    }

    printQueue() {
        let current = this.first;
        const values = [];
        while (current) {
            values.push(current.value);
            current = current.next;
        }
        return values.join(' ');
    }
}

// Usage example
function useQueue() {
    const queue = new MyQueue();

    console.log("Is empty?", queue.isEmpty()); // true

    try {
        queue.dequeue(); // Should throw
    } catch (e) {
        console.error(e.message);
    }

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    console.log("Queue contents:", queue.printQueue()); // 1 2 3
    console.log("Front element:", queue.peek()); // 1
    console.log("Dequeued element:", queue.dequeue()); // 1
    console.log("Queue after dequeue:", queue.printQueue()); // 2 3
}

useQueue();

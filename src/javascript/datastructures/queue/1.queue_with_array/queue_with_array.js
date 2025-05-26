class MyQueue {
    constructor() {
        this.items = []; // Array is used to implement a Queue
    }

    // Core queue operations
    enqueue(value) {
        this.items.push(value); // adds an item to the queue
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        return this.items.shift(); // Removes an item from the front of a queue and returns the removed item
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        return this.items[0]; // returns the front item of the queue without removing it
    }

    // Helper functions
    isEmpty() {
        return this.items.length === 0; // returns true if the queue is empty
    }

    size() {
        return this.items.length; // returns the number of elements in the queue
    }

    printQueue() {
        return this.items.join(" ");
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

class MyStack {
    constructor() {
        this.items = [];
    }

    // Core stack operations
    push(value) {
        this.items.push(value);
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot pop from an empty stack.");
        }
        return this.items.pop();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot peek from an empty stack.");
        }
        return this.items[this.items.length - 1];
    }

    // Helper functions
    isEmpty() {
        return this.items.length === 0;
    }

    size() {
        return this.items.length;
    }

    printStack() {
        return this.items.join(' ');
    }
}

class MyQueue {
    constructor() {
        this.stackNewest = new MyStack(); // for enqueue
        this.stackOldest = new MyStack(); // for dequeue
    }

    // Core queue operations
    enqueue(value) {
        this.stackNewest.push(value);
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        
        // If stackOldest is empty, transfer all elements from stackNewest
        this.shiftStacks();
        
        return this.stackOldest.pop();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        
        // If stackOldest is empty, transfer all elements from stackNewest
        this.shiftStacks();
        
        return this.stackOldest.peek();
    }

    // Helper functions
    isEmpty() {
        return this.stackNewest.isEmpty() && this.stackOldest.isEmpty();
    }

    size() {
        return this.stackNewest.size() + this.stackOldest.size();
    }

    // Transfer all elements from stackNewest to stackOldest
    shiftStacks() {
        if (this.stackOldest.isEmpty()) {
            while (!this.stackNewest.isEmpty()) {
                this.stackOldest.push(this.stackNewest.pop());
            }
        }
    }

    printQueue() {
        // Create a temporary array to hold all values in queue order
        const values = [];
        
        // Add all values from stackOldest (these are in queue order)
        const oldestItems = [...this.stackOldest.items];
        values.push(...oldestItems);
        
        // Add all values from stackNewest (these need to be reversed)
        const newestItems = [...this.stackNewest.items].reverse();
        values.push(...newestItems);
        
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
    
    // Add more elements to test the two-stack implementation
    queue.enqueue(4);
    queue.enqueue(5);
    console.log("Queue after more enqueues:", queue.printQueue()); // 2 3 4 5
    console.log("Dequeued element:", queue.dequeue()); // 2
    console.log("Queue after another dequeue:", queue.printQueue()); // 3 4 5
}

useQueue();
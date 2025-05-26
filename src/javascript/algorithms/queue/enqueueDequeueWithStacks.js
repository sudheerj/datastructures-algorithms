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
        this.stack1 = new MyStack();
        this.stack2 = new MyStack();
    }
    
    peek() {
        return this.stack1.peek();
    }

    isEmpty() {
        return this.stack1.isEmpty();
    }

    enqueue(value) {
        while(!this.stack1.isEmpty()) {
            this.stack2.push(this.stack1.pop());
        }
        
        this.stack2.push(value);
        
        while(!this.stack2.isEmpty()) {
            this.stack1.push(this.stack2.pop());
        }
    }

    dequeue() {
        if(this.stack1.isEmpty()) return null;
        return this.stack1.pop();
    }
}



const queue = new MyQueue();

queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
console.log("Top element: ", queue.peek()); // 3 

queue.dequeue(3);

console.log("Top element: ", queue.peek()); // 2
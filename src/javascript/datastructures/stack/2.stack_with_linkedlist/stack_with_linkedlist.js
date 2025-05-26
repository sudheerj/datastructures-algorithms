class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class MyStack {
    constructor() {
        this.top = null;
        this.length = 0;
    }

    // Core stack operations
    push(value) {
        const newNode = new Node(value);
        if(this.length === 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.length++;
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot pop from an empty stack.");
        }
        const temp = this.top;
        this.top = this.top.next;
        temp.next = null;

        this.length--;
        return temp.value;
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot peek from an empty stack.");
        }
        return this.top.value;
    }

    // Helper functions
    isEmpty() {
        return this.length === 0;
    }

    size() {
        return this.length;
    }

    printStack() {
        let current = this.top;
        const values = [];
        while (current) {
            values.unshift(current.value);
            current = current.next;
        }
        return values.join(' ');
    }
}

// Usage example
function useStack() {
    const stack = new MyStack();

    console.log("Is empty?", stack.isEmpty()); // true

    try {
        stack.pop(); // Should throw
    } catch (e) {
        console.error(e.message);
    }

    stack.push(1);
    stack.push(2);
    stack.push(3);

    console.log("Stack contents:", stack.printStack()); // One Two Three
    console.log("Top element:", stack.peek()); // Three
    console.log("Popped element:", stack.pop()); // Three
    console.log("Stack after pop:", stack.printStack()); // One Two
}

useStack();

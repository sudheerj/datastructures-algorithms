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

    push(value) {
        let newNode = new Node(value);
        if(this.length === 0) {
            this.top = newNode;
        } else {
            const topNode = this.top;
            this.top = newNode;
            this.top.next = topNode;
        }
        this.length++;
        return this;
    }

    pop() {
        if (this.length === 0) {
            return null;
        }
        const topNode = this.top;
        this.top = this.top.next;
        this.length--;
        return topNode;
    }

    peek() {
        return this.top;
    }

    isEmpty() {
        return this.length === 0;
    }
}

const myStack = new MyStack();
myStack.push("One");
myStack.push("Second");
myStack.push("Third");
myStack.peek();
myStack.isEmpty();
myStack.pop();
myStack.pop();
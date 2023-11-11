class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    constructor(value) {
        const newNode = new Node(value);
        this.top = newNode;
        this.length = 1;
    }

    push(value) {
        const newNode = new Node(value);
        if(this.length === 0) {
            this.top = newNode;
        } else {
            newNode.next = newNode;
            this.top = newNode;
        }
        this.length++;
        return this;
    }

    pop() {
        if (this.length === 0) return undefined;
        const temp = this.top;
        this.top = this.top.next;
        temp.next = null;

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

const myStack = new Stack("Zero");
myStack.push("One");
myStack.push("Second");
myStack.push("Third");
myStack.peek();
myStack.isEmpty();
myStack.pop();
myStack.pop();
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    constructor() {
        this.top = null;
        this.length = 0;
    }

    push(value) {
        const newNode = new Node(value);
        if(this.length === 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
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
        return temp;
    }

    peek() {
        return this.top;
    }

    isEmpty() {
        return this.length === 0;
    }
}

const myStack = new Stack();
console.log(myStack.isEmpty());
myStack.push("One");
myStack.push("Second");
myStack.push("Third");
console.log(myStack.peek());
console.log(myStack.isEmpty());
console.log(myStack.pop());
console.log(myStack.pop());
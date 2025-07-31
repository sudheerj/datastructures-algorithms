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

//TC: O(n^2), SC: O(n)
//Sorts a stack in ascending order using an auxiliary stack
function sortStack(stack) {
    if(stack.size() <= 1) return;
    let tempStack = new MyStack();
    while(stack.size() > 0) { 
        let temp = stack.pop();
        while(tempStack.size() > 0 && tempStack.peek() > temp) {
            let top = tempStack.pop();
            stack.push(top);
        }
        tempStack.push(temp);
    }

    // Use a buffer to reverse the order for ascending stack
    const buffer = [];
    while (tempStack.size() > 0) {
        buffer.push(tempStack.pop());
    }
    while (buffer.length > 0) {
        stack.push(buffer.pop());
    }
}


let myStack1 = new MyStack();
myStack1.push(8);
myStack1.push(2);
myStack1.push(4);
myStack1.push(1);
myStack1.push(5);
myStack1.push(3);

let myStack2 = new MyStack();
myStack2.push(6);
myStack2.push(5);
myStack2.push(4);
myStack2.push(3);
myStack2.push(2);
myStack2.push(1);


console.log(myStack1.printStack());
sortStack(myStack1);
console.log(myStack1.printStack());

console.log(myStack2.printStack());
sortStack(myStack2);
console.log(myStack2.printStack());




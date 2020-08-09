class Stack {

    constructor() {
        this.items = []; // Array is used to implement stack
    }

    // List of main functions of stack data structure

    push(item) {
        // push item into the items
        this.items.push(item);
    }

    pop() {
        // Underflow if stack is empty
        if (this.isEmpty()) {
            return "Underflow";
        }

        return this.items.pop(); // return top most item from the stack and removes the same item
    }

    peek() {
        return this.items[this.items.length - 1]; // return top most item from the stack without removing the  item
    }

    // List of helper functions

    isEmpty() {
        return this.items.length === 0; // return true if stack is empty
    }

    printStack() {
        let data = "";
        for (let i = 0; i < this.items.length; i++)
            data += this.items[i] + " ";
        return data;
    }

}

function useStack() {
    let stack = new Stack();

    console.log(stack.isEmpty()); // false
    console.log(stack.pop()); // Underflow

    stack.push(1);
    stack.push(2);
    stack.push(3);

    console.log(stack.printStack()); // 1 2 3
    console.log(stack.peek()); // 3

    console.log(stack.pop()); // 3

    console.log(stack.printStack()); // 1 2
}

useStack();



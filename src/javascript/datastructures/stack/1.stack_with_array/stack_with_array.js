class MyStack {

    constructor() {
        this.array = []; // Array is used to implement stack
    }

    // List of main functions of stack data structure

    push(value) {
        // push an element into the array
        this.array.push(value);
    }

    pop() {
        // Underflow if stack is empty
        if (this.isEmpty()) {
            return "Underflow";
        }

        return this.array.pop(); // return top most element from the stack and removes the same element
    }

    peek() {
        // Underflow if stack is empty
        if (this.isEmpty()) {
            return "Underflow";
        }
        return this.array.at(-1); // return top most element from the stack without removing the element
    }

    // List of helper functions

    isEmpty() {
        return this.array.length === 0; // return true if stack is empty
    }

    printStack() {
        let data = "";
        for (let num of this.array)
            data += num + " ";
        return data;
    }

}

function useStack() {
    let myStack = new MyStack();

    console.log(myStack.isEmpty()); // true
    console.log(myStack.pop()); // Underflow

    myStack.push(1);
    myStack.push(2);
    myStack.push(3);

    console.log(myStack.printStack()); // 1 2 3
    console.log(myStack.peek()); // 3

    console.log(myStack.pop()); // 3

    console.log(myStack.printStack()); // 1 2
}

useStack();



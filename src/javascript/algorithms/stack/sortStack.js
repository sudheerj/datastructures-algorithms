class Stack {

    constructor() {
        this.array = []; // Array is used to implement stack
    }

    // List of main functions of stack data structure

    push(value) {
        // push an element into the array
        this.array.push(value);
    }

    pop() {
        // Return null if stack is empty
        if (this.isEmpty()) {
            return null;
        }

        return this.array.pop(); // return top most element from the stack and removes the same element
    }

    peek() {
        // Return null if stack is empty
        if (this.isEmpty()) {
            return null;
        }
    
        return this.array[this.array.length - 1]; // return top most element from the stack without removing the element
    }

    // List of helper functions

    isEmpty() {
        return this.array.length === 0; // return true if stack is empty
    }

    size() {
        return this.array.length;
    }

    printStack() {
        let data = "";
        for (let i = 0; i < this.array.length; i++)
            data += this.array[i] + " ";
        return data;
    }

}

function sortStack(stack) {
    if(stack.size() < 1) return;
    let tempStack = new Stack();
    while(stack.size() > 0) {
        let temp = stack.pop();
        while(tempStack.size() > 0 && tempStack.peek() < temp) {
            let top = tempStack.pop();
            stack.push(top);
        }
        tempStack.push(temp);
    }
    stack.array = tempStack.array;
}


    let myStack = new Stack();

    myStack.push(4);
    myStack.push(2);
    myStack.push(3);
    myStack.push(5);
    myStack.push(1);

    console.log(myStack.printStack()); // 4 2 3 5 1
    sortStack(myStack);  
    console.log(myStack.printStack()); // 5 4 3 2 1




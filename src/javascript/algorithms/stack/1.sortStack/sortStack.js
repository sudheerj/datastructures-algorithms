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
    let tempStack = new MyStack();
    while(stack.size() > 0) { 
        let temp = stack.pop();
        while(tempStack.size() > 0 && tempStack.peek() > temp) {
            let top = tempStack.pop();
            stack.push(top);
        }
        tempStack.push(temp); 
    }
    stack.array = tempStack.array;
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




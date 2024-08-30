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
        return this.array[this.array.length - 1]; // return top most element from the stack without removing the element
    }

    // List of helper functions

    isEmpty() {
        return this.array.length === 0; // return true if stack is empty
    }

    printStack() {
        let data = "";
        for (let el of this.array)
            data += el + " ";
        return data;
    }

}


function reversePolishNotation(tokens){
    let myStack = new MyStack();
    for (const token of tokens) {
        switch (token) {
            case '+': {
                let secondPrev = myStack.pop();
                let firstPrev = myStack.pop();
                myStack.push(firstPrev+secondPrev);
                break;
            }
            case '-': {
                let secondPrev = myStack.pop();
                let firstPrev = myStack.pop();
                myStack.push(firstPrev-secondPrev);
                break; 
            }
            case '*': {
                let secondPrev = myStack.pop();
                let firstPrev = myStack.pop();
                myStack.push(firstPrev*secondPrev);
                break;
            }
            case '/': {
                let secondPrev = myStack.pop();
                let firstPrev = myStack.pop();
                myStack.push(Number.parseInt(firstPrev/secondPrev));
                break; 
            }
            default:
                myStack.push(Number.parseInt(token));
                break;
        }
    }
    return myStack.pop();
}

let tokens1 = ["1","3","+","4","*"];
let tokens2 = ["5","4","3","2","+","-10","*","/","*","10","+","4","+"];
console.log(reversePolishNotation(tokens1));
console.log(reversePolishNotation(tokens2));
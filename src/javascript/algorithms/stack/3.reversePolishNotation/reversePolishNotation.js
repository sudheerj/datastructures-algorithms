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


function reversePolishNotation1(tokens){
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
            default: {
                myStack.push(Number.parseInt(token));
                break;
            }
        }
    }
    return myStack.pop();
}

function reversePolishNotation2(tokens) {
    const myStack = new MyStack();
    const operators = new Set(['+', '-', '*', '/']);

    for (const token of tokens) {
        if (!operators.has(token)) {
            myStack.push(Number(token));
        } else {
            const b = myStack.pop();
            const a = myStack.pop();
            let result;
            switch (token) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/': result = Math.trunc(a / b); break; // Truncate toward zero
                default: throw new Error(`Unknown operator: ${token}`);
            }
            myStack.push(result);
        }
    }
    if (myStack.isEmpty()) {
        throw new Error("Invalid RPN expression.");
    }
    return myStack.pop();
}

let tokens1 = ["1","3","+","4","*"];
let tokens2 = ["5","4","3","2","+","-10","*","/","*","10","+","4","+"];
console.log(reversePolishNotation1(tokens1));
console.log(reversePolishNotation1(tokens2));

console.log("--------------------------------");

console.log(reversePolishNotation2(tokens1));
console.log(reversePolishNotation2(tokens2));


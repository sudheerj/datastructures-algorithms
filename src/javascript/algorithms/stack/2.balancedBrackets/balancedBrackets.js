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

function hasBalancedParentheses(characters) {
    const myStack = new MyStack();
    if(characters.length === 0) return true;
    if(characters.length === 1 || characters.length % 2 !== 0) return false;
    
    for(const ch of characters) {
        switch(ch) {
            case '{':
            case '(':
            case '<':
            case '[':
                myStack.push(ch);
                break;
            case '}':
                if(myStack.peek() === '{') {
                    myStack.pop();
                } else {
                    return false;
                }
                break;
            case ')':
                if(myStack.peek() === '(') {
                    myStack.pop();
                } else {
                    return false;
                }
                break;
            case '>':
                if(myStack.peek() === '<') {
                    myStack.pop();
                } else {
                    return false;
                }
                break;
            case ']':
                if(myStack.peek() === '[') {
                    myStack.pop();
                } else {
                    return false;
                }
                break;
        }
    }
    if(myStack.isEmpty()) return true;
}

let str1 = '()[]{}<>';
let str2 = '[({<>})]';
let str3 = '([)]';

console.log(hasBalancedParentheses(str1));
console.log(hasBalancedParentheses(str2));
console.log(hasBalancedParentheses(str3));





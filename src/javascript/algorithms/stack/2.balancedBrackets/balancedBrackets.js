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

function hasBalancedParentheses1(characters) {
    const myStack = new MyStack();
    if(characters.length === 0) return true;
    if(characters.length % 2 !== 0) return false;
    
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

function hasBalancedParentheses2(input) {
    const stack = new MyStack();
    const bracketMap = {
        ')': '(',
        '}': '{',
        ']': '[',
        '>': '<'
    };
    const openBrackets = new Set(['(', '{', '[', '<']);

    for (const ch of input) {
        if (openBrackets.has(ch)) {
            stack.push(ch);
        } else if (ch in bracketMap) {
            if (stack.pop() !== bracketMap[ch]) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}

// Test cases
const testCases = [
    { input: '()[]{}<>', expected: true },
    { input: '[({<>})]', expected: true },
    { input: '([)]', expected: false },
    { input: '', expected: true },
    { input: '(', expected: false },
];

for (const { input, expected } of testCases) {
    const result = hasBalancedParentheses1(input);
    console.log(`Input: "${input}" => ${result} (Expected: ${expected})`);
}

console.log("--------------------------------");

for (const { input, expected } of testCases) {
    const result = hasBalancedParentheses2(input);
    console.log(`Input: "${input}" => ${result} (Expected: ${expected})`);
}





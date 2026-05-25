// Approach 1: Two Stacks — O(1) all operations, O(n) space
class MinStack {
    constructor() {
        this.stack = [];
        this.minStack = [];
    }

    push(val) {
        this.stack.push(val);
        if (this.minStack.length === 0) {
            this.minStack.push(val);
        } else {
            this.minStack.push(Math.min(val, this.minStack[this.minStack.length - 1]));
        }
    }

    pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    top() {
        return this.stack[this.stack.length - 1];
    }

    getMin() {
        return this.minStack[this.minStack.length - 1];
    }
}

// Approach 2: Single Stack with [value, currentMin] pairs — O(1) all operations, O(n) space
class MinStack1 {
    constructor() {
        this.stack = []; // stores [val, currentMin]
    }

    push(val) {
        const currentMin = this.stack.length === 0 ? val : Math.min(val, this.stack[this.stack.length - 1][1]);
        this.stack.push([val, currentMin]);
    }

    pop() {
        return this.stack.pop()[0];
    }

    top() {
        return this.stack[this.stack.length - 1][0];
    }

    getMin() {
        return this.stack[this.stack.length - 1][1];
    }
}

console.log("--- Approach 1: Two Stacks ---");
const ms1 = new MinStack();

ms1.push(5);
const r1 = ms1.getMin();
console.log(`Test 1 - push(5) getMin(): ${r1 === 5 ? '[PASS]' : '[FAIL]'} result=${r1} expected=5`);

ms1.push(3);
const r2 = ms1.getMin();
console.log(`Test 2 - push(3) getMin(): ${r2 === 3 ? '[PASS]' : '[FAIL]'} result=${r2} expected=3`);

ms1.push(7);
const r3 = ms1.getMin();
console.log(`Test 3 - push(7) getMin(): ${r3 === 3 ? '[PASS]' : '[FAIL]'} result=${r3} expected=3`);

ms1.push(2);
const r4 = ms1.getMin();
console.log(`Test 4 - push(2) getMin(): ${r4 === 2 ? '[PASS]' : '[FAIL]'} result=${r4} expected=2`);

const r5 = ms1.top();
console.log(`Test 5 - top(): ${r5 === 2 ? '[PASS]' : '[FAIL]'} result=${r5} expected=2`);

ms1.pop();
const r6 = ms1.getMin();
console.log(`Test 6 - pop() 2, getMin(): ${r6 === 3 ? '[PASS]' : '[FAIL]'} result=${r6} expected=3`);

ms1.pop();
const r7 = ms1.getMin();
console.log(`Test 7 - pop() 7, getMin(): ${r7 === 3 ? '[PASS]' : '[FAIL]'} result=${r7} expected=3`);

ms1.pop();
const r8 = ms1.getMin();
console.log(`Test 8 - pop() 3, getMin(): ${r8 === 5 ? '[PASS]' : '[FAIL]'} result=${r8} expected=5`);

console.log("\n--- Approach 2: Single Stack with [value, min] pairs ---");
const ms2 = new MinStack1();

ms2.push(5);
const r9 = ms2.getMin();
console.log(`Test 1 - push(5) getMin(): ${r9 === 5 ? '[PASS]' : '[FAIL]'} result=${r9} expected=5`);

ms2.push(3);
const r10 = ms2.getMin();
console.log(`Test 2 - push(3) getMin(): ${r10 === 3 ? '[PASS]' : '[FAIL]'} result=${r10} expected=3`);

ms2.push(7);
const r11 = ms2.getMin();
console.log(`Test 3 - push(7) getMin(): ${r11 === 3 ? '[PASS]' : '[FAIL]'} result=${r11} expected=3`);

ms2.push(2);
const r12 = ms2.getMin();
console.log(`Test 4 - push(2) getMin(): ${r12 === 2 ? '[PASS]' : '[FAIL]'} result=${r12} expected=2`);

const r13 = ms2.top();
console.log(`Test 5 - top(): ${r13 === 2 ? '[PASS]' : '[FAIL]'} result=${r13} expected=2`);

ms2.pop();
const r14 = ms2.getMin();
console.log(`Test 6 - pop() 2, getMin(): ${r14 === 3 ? '[PASS]' : '[FAIL]'} result=${r14} expected=3`);

ms2.pop();
const r15 = ms2.getMin();
console.log(`Test 7 - pop() 7, getMin(): ${r15 === 3 ? '[PASS]' : '[FAIL]'} result=${r15} expected=3`);

ms2.pop();
const r16 = ms2.getMin();
console.log(`Test 8 - pop() 3, getMin(): ${r16 === 5 ? '[PASS]' : '[FAIL]'} result=${r16} expected=5`);

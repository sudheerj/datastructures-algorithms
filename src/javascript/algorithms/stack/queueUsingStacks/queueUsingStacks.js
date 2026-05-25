// Approach 1: push O(1), pop/peek O(n)
class QueueUsingStacks1 {
    constructor() {
        this.stack1 = [];
        this.stack2 = [];
    }

    // O(1)
    push(x) {
        this.stack1.push(x);
    }

    // O(n)
    pop() {
        while (this.stack1.length > 1) {
            this.stack2.push(this.stack1.pop());
        }
        const res = this.stack1.pop();
        while (this.stack2.length > 0) {
            this.stack1.push(this.stack2.pop());
        }
        return res;
    }

    // O(n)
    peek() {
        while (this.stack1.length > 1) {
            this.stack2.push(this.stack1.pop());
        }
        const res = this.stack1[this.stack1.length - 1];
        while (this.stack2.length > 0) {
            this.stack1.push(this.stack2.pop());
        }
        return res;
    }

    // O(1)
    isEmpty() {
        return this.stack1.length === 0;
    }
}

// Approach 2: push O(1), pop/peek amortized O(1)
class QueueUsingStacks2 {
    constructor() {
        this.stack1 = []; // input
        this.stack2 = []; // output
    }

    // O(1)
    push(x) {
        this.stack1.push(x);
    }

    // O(1) amortized
    pop() {
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.pop();
    }

    // O(1) amortized
    peek() {
        if (this.stack2.length === 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2[this.stack2.length - 1];
    }

    // O(1)
    isEmpty() {
        return this.stack1.length === 0 && this.stack2.length === 0;
    }
}

console.log("--- Approach 1: push O(1), pop/peek O(n) ---");

// Test 1 & 2: pop() returns elements in FIFO order
const q1a = new QueueUsingStacks1();
q1a.push(1); q1a.push(2); q1a.push(3);
const r1 = q1a.pop();
console.log(`Test 1 - pop() first (FIFO): ${r1 === 1 ? '[PASS]' : '[FAIL]'} result=${r1} expected=1`);
const r2 = q1a.pop();
console.log(`Test 2 - pop() second (FIFO): ${r2 === 2 ? '[PASS]' : '[FAIL]'} result=${r2} expected=2`);

// Test 3 & 4: peek() returns front without removing
const q1b = new QueueUsingStacks1();
q1b.push(10); q1b.push(20);
const r3 = q1b.peek();
console.log(`Test 3 - peek() returns front: ${r3 === 10 ? '[PASS]' : '[FAIL]'} result=${r3} expected=10`);
const r4 = q1b.pop();
console.log(`Test 4 - pop() after peek() still returns front: ${r4 === 10 ? '[PASS]' : '[FAIL]'} result=${r4} expected=10`);

// Test 5: isEmpty() on new queue
const q1c = new QueueUsingStacks1();
const r5 = q1c.isEmpty();
console.log(`Test 5 - isEmpty() on new queue: ${r5 === true ? '[PASS]' : '[FAIL]'} result=${r5} expected=true`);

// Test 6: isEmpty() after push returns false
q1c.push(5);
const r6 = q1c.isEmpty();
console.log(`Test 6 - isEmpty() after push: ${r6 === false ? '[PASS]' : '[FAIL]'} result=${r6} expected=false`);

// Test 7: interleaved push/pop/peek
const q1d = new QueueUsingStacks1();
q1d.push(1); q1d.push(2); q1d.pop(); q1d.push(3);
const r7 = q1d.peek();
console.log(`Test 7 - interleaved push/pop/peek: ${r7 === 2 ? '[PASS]' : '[FAIL]'} result=${r7} expected=2`);

console.log("\n--- Approach 2: push O(1), pop/peek amortized O(1) ---");

// Test 1 & 2: pop() returns elements in FIFO order
const q2a = new QueueUsingStacks2();
q2a.push(1); q2a.push(2); q2a.push(3);
const r8 = q2a.pop();
console.log(`Test 1 - pop() first (FIFO): ${r8 === 1 ? '[PASS]' : '[FAIL]'} result=${r8} expected=1`);
const r9 = q2a.pop();
console.log(`Test 2 - pop() second (FIFO): ${r9 === 2 ? '[PASS]' : '[FAIL]'} result=${r9} expected=2`);

// Test 3 & 4: peek() returns front without removing
const q2b = new QueueUsingStacks2();
q2b.push(10); q2b.push(20);
const r10 = q2b.peek();
console.log(`Test 3 - peek() returns front: ${r10 === 10 ? '[PASS]' : '[FAIL]'} result=${r10} expected=10`);
const r11 = q2b.pop();
console.log(`Test 4 - pop() after peek() still returns front: ${r11 === 10 ? '[PASS]' : '[FAIL]'} result=${r11} expected=10`);

// Test 5: isEmpty() on new queue
const q2c = new QueueUsingStacks2();
const r12 = q2c.isEmpty();
console.log(`Test 5 - isEmpty() on new queue: ${r12 === true ? '[PASS]' : '[FAIL]'} result=${r12} expected=true`);

// Test 6: isEmpty() after push returns false
q2c.push(5);
const r13 = q2c.isEmpty();
console.log(`Test 6 - isEmpty() after push: ${r13 === false ? '[PASS]' : '[FAIL]'} result=${r13} expected=false`);

// Test 7: interleaved push/pop/peek
const q2d = new QueueUsingStacks2();
q2d.push(1); q2d.push(2); q2d.pop(); q2d.push(3);
const r14 = q2d.peek();
console.log(`Test 7 - interleaved push/pop/peek: ${r14 === 2 ? '[PASS]' : '[FAIL]'} result=${r14} expected=2`);

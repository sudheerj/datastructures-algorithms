/**
 * Implement Stack using Queues
 *
 * Implement a LIFO stack using a single queue.
 * After each push, rotate all previous elements to the back so the
 * newest element stays at the front.
 *
 * push:    TC: O(n), SC: O(1)
 * pop:     TC: O(1), SC: O(1)
 * top:     TC: O(1), SC: O(1)
 * isEmpty: TC: O(1), SC: O(1)
 */

class MyStack {
  constructor() {
    this.queue = [];
  }

  push(x) {
    this.queue.push(x);
    for (let i = 0; i < this.queue.length - 1; i++) {
      this.queue.push(this.queue.shift());
    }
  }

  pop() {
    return this.queue.shift();
  }

  top() {
    return this.queue[0];
  }

  isEmpty() {
    return this.queue.length === 0;
  }
}

const stack = new MyStack();

// Test push and top
stack.push(1);
stack.push(2);
stack.push(3);
console.log(stack.top()); // 3
console.log(stack.isEmpty()); // false

// Test pop
console.log(stack.pop()); // 3
console.log(stack.top()); // 2

console.log(stack.pop()); // 2
console.log(stack.pop()); // 1
console.log(stack.isEmpty()); // true

// Test push after pop
stack.push(10);
stack.push(20);
console.log(stack.top()); // 20
console.log(stack.pop()); // 20
console.log(stack.top()); // 10

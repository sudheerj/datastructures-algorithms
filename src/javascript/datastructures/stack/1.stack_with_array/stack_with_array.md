A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. In a stack, the most recently added element is the first one to be removed. This implementation uses a JavaScript array to store stack elements.

Unlike arrays, stacks restrict access to only the top element, making them useful for scenarios like undo operations, expression evaluation, and backtracking algorithms.

The structure of a stack with an array looks like below:

   ![Screenshot](stack_with_array.png)

The stack can have the following functionalities:

1. **Push:** Adds a new element to the top of the stack. The value is appended to the end of the internal array.

2. **Pop:** Removes and returns the top element from the stack. If the stack is empty, an error is thrown indicating stack underflow.

3. **Peek:** Returns the top element of the stack without removing it. If the stack is empty, an error is thrown indicating stack underflow.

4. **isEmpty:** Checks whether the stack is empty. Returns `true` if there are no elements, otherwise `false`.

5. **Size:** Returns the number of elements in the stack.

6. **PrintStack:** Returns a string representation of the stack elements, from bottom to top.

## Usage Example

```js
const stack = new MyStack();

console.log("Is empty?", stack.isEmpty()); // true

try {
    stack.pop(); // Should throw
} catch (e) {
    console.error(e.message);
}

stack.push(1);
stack.push(2);
stack.push(3);

console.log("Stack contents:", stack.printStack()); // 1 2 3
console.log("Top element:", stack.peek()); // 3
console.log("Popped element:", stack.pop()); // 3
console.log("Stack after pop:", stack.printStack()); // 1 2
```

## Complexity

| Access | Search | Insertion | Deletion | Space (Memory) |
| :----: | :----: | :-------: | :------: | :------------: |
|  O(1)  |  O(n)  |   O(1)    |   O(1)   |      O(n)      |

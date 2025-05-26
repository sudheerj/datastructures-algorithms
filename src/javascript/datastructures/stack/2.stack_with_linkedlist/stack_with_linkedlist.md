A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. In this implementation, a singly linked list is used to store stack elements, where each node contains a value and a reference to the next node.

Stacks are useful for scenarios like undo operations, expression evaluation, and backtracking algorithms. Using a linked list allows the stack to grow dynamically without worrying about array resizing.

The structure of a stack with a linked list looks like below:

   ![Screenshot](stack_with_linkedlist.png)

The stack can have the following functionalities:

1. **Push:** Adds a new element to the top of the stack. A new node is created and set as the new top, pointing to the previous top node.

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
|  O(n)  |  O(n)  |   O(1)    |   O(1)   |      O(n)      |

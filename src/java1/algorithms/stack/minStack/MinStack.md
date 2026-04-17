# Min Stack

## Problem
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- `push(x)`: Push element x onto stack.
- `pop()`: Removes the element on top of the stack.
- `top()`: Get the top element.
- `getMin()`: Retrieve the minimum element in the stack.

## Approach
Use two stacks:
- Main stack for all values
- Min stack for current minimums

On push: push to main, and if new value <= minStack top, push to minStack.
On pop: pop from main, and if popped value == minStack top, pop minStack.

## Complexity
- **Time:** O(1) for all operations
- **Space:** O(n) for n elements

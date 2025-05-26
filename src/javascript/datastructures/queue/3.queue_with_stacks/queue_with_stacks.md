# Queue Implementation Using Two Stacks

A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. A queue can be visualized as a line of people waiting for a service, where new people join at the back and are served from the front.

## Overview

This implementation uses two stacks to represent a queue. While this might seem counterintuitive since stacks follow the Last In, First Out (LIFO) principle, we can leverage two stacks to achieve the FIFO behavior required for a queue. This approach demonstrates how one data structure can be built using another.

## Operations

### Core Queue Operations

1. **Enqueue**: Adds an element to the back of the queue.
   - Time Complexity: O(1)
   - Implementation: Pushes the element onto the "newest" stack

2. **Dequeue**: Removes and returns the element from the front of the queue.
   - Time Complexity: O(n) amortized, but O(1) for most operations
   - Implementation: Pops from the "oldest" stack; if it's empty, transfers all elements from the "newest" stack

3. **Peek**: Returns the element at the front of the queue without removing it.
   - Time Complexity: O(n) amortized, but O(1) for most operations
   - Implementation: Peeks at the "oldest" stack; if it's empty, transfers all elements from the "newest" stack

### Helper Operations

1. **isEmpty**: Checks if the queue is empty.
   - Time Complexity: O(1)
   - Implementation: Checks if both stacks are empty

2. **Size**: Returns the number of elements in the queue.
   - Time Complexity: O(1)
   - Implementation: Returns the sum of the sizes of both stacks

3. **ShiftStacks**: Transfers elements from the "newest" stack to the "oldest" stack.
   - Time Complexity: O(n)
   - Implementation: Pops each element from the "newest" stack and pushes it onto the "oldest" stack

4. **PrintQueue**: Returns a string representation of the queue.
   - Time Complexity: O(n)
   - Implementation: Combines elements from both stacks in the correct order

## Implementation Details

```javascript
class MyQueue {
    constructor() {
        this.stackNewest = new MyStack(); // for enqueue
        this.stackOldest = new MyStack(); // for dequeue
    }

    // Core queue operations
    enqueue(value) {
        this.stackNewest.push(value);
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        
        // If stackOldest is empty, transfer all elements from stackNewest
        this.shiftStacks();
        
        return this.stackOldest.pop();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        
        // If stackOldest is empty, transfer all elements from stackNewest
        this.shiftStacks();
        
        return this.stackOldest.peek();
    }

    // Helper functions
    isEmpty() {
        return this.stackNewest.isEmpty() && this.stackOldest.isEmpty();
    }

    size() {
        return this.stackNewest.size() + this.stackOldest.size();
    }

    // Transfer all elements from stackNewest to stackOldest
    shiftStacks() {
        if (this.stackOldest.isEmpty()) {
            while (!this.stackNewest.isEmpty()) {
                this.stackOldest.push(this.stackNewest.pop());
            }
        }
    }

    printQueue() {
        // Create a temporary array to hold all values in queue order
        const values = [];
        
        // Add all values from stackOldest (these are in queue order)
        const oldestItems = [...this.stackOldest.items];
        values.push(...oldestItems);
        
        // Add all values from stackNewest (these need to be reversed)
        const newestItems = [...this.stackNewest.items].reverse();
        values.push(...newestItems);
        
        return values.join(' ');
    }
}
```

## How It Works

1. We maintain two stacks:
   - `stackNewest`: Elements are pushed here when enqueued
   - `stackOldest`: Elements are popped from here when dequeued

2. When we need to dequeue or peek and `stackOldest` is empty:
   - We transfer all elements from `stackNewest` to `stackOldest`
   - This reverses their order, converting LIFO to FIFO

3. This approach ensures that the oldest elements (first enqueued) are at the top of `stackOldest`, ready to be dequeued first.

## Advantages and Disadvantages

### Advantages
- Demonstrates how to build one data structure using another
- Can be useful in certain programming environments where stacks are readily available but queues are not
- Amortized time complexity for dequeue operations is still efficient

### Disadvantages
- More complex implementation than direct array or linked list approaches
- Requires more memory for maintaining two stacks
- Some operations may have occasional O(n) time complexity when stack transfer is needed

## Complexity Analysis

- **Enqueue**: O(1) time complexity
- **Dequeue**: O(n) worst-case time complexity, but O(1) amortized
- **Peek**: O(n) worst-case time complexity, but O(1) amortized
- **Space Complexity**: O(n) where n is the number of elements in the queue
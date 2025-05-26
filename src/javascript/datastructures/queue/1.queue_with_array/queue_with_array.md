# Queue Implementation Using Array

A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. A queue can be visualized as a line of people waiting for a service, where new people join at the back and are served from the front.

## Overview

This implementation uses a JavaScript array to represent a queue. While arrays in JavaScript provide methods that make queue operations straightforward, it's important to understand the underlying concepts.

## Operations

### Core Queue Operations

1. **Enqueue**: Adds an element to the back of the queue.
   - Time Complexity: O(1) amortized
   - Implementation: Uses the array's `push()` method

2. **Dequeue**: Removes and returns the element from the front of the queue.
   - Time Complexity: O(n) - because shifting all elements is required
   - Implementation: Uses the array's `shift()` method

3. **Peek**: Returns the element at the front of the queue without removing it.
   - Time Complexity: O(1)
   - Implementation: Accesses the first element of the array

### Helper Operations

1. **isEmpty**: Checks if the queue is empty.
   - Time Complexity: O(1)
   - Implementation: Checks if the array's length is 0

2. **Size**: Returns the number of elements in the queue.
   - Time Complexity: O(1)
   - Implementation: Returns the array's length

3. **PrintQueue**: Returns a string representation of the queue.
   - Time Complexity: O(n)
   - Implementation: Joins all elements of the array with spaces

## Implementation Details

```javascript
class MyQueue {
    constructor() {
        this.items = []; // Array is used to implement a Queue
    }

    // Core queue operations
    enqueue(value) {
        this.items.push(value); // adds an item to the queue
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        return this.items.shift(); // Removes an item from the front of a queue
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        return this.items[0]; // returns the front item without removing it
    }

    // Helper functions
    isEmpty() {
        return this.items.length === 0;
    }

    size() {
        return this.items.length;
    }

    printQueue() {
        return this.items.join(" ");
    }
}
```

## Advantages and Disadvantages

### Advantages
- Simple implementation
- Dynamic size (no need to specify capacity)
- Easy to understand and use

### Disadvantages
- The `dequeue` operation has O(n) time complexity because it uses `shift()`, which requires moving all remaining elements
- Not as efficient for large queues compared to linked list implementation

## Complexity Analysis

- **Enqueue**: O(1) amortized time complexity
- **Dequeue**: O(n) time complexity
- **Peek**: O(1) time complexity
- **Space Complexity**: O(n) where n is the number of elements in the queue
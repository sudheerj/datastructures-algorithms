# Queue Implementation Using Linked List

A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. A queue can be visualized as a line of people waiting for a service, where new people join at the back and are served from the front.

## Overview

This implementation uses a singly linked list to represent a queue. A linked list is particularly well-suited for queue operations because it allows efficient insertions and deletions at both ends, which is exactly what we need for a queue.

## Operations

### Core Queue Operations

1. **Enqueue**: Adds an element to the back of the queue.
   - Time Complexity: O(1)
   - Implementation: Creates a new node and adds it to the end of the linked list

2. **Dequeue**: Removes and returns the element from the front of the queue.
   - Time Complexity: O(1)
   - Implementation: Removes the first node from the linked list and returns its value

3. **Peek**: Returns the element at the front of the queue without removing it.
   - Time Complexity: O(1)
   - Implementation: Returns the value of the first node without removing it

### Helper Operations

1. **isEmpty**: Checks if the queue is empty.
   - Time Complexity: O(1)
   - Implementation: Checks if the length is 0 or if the first node is null

2. **Size**: Returns the number of elements in the queue.
   - Time Complexity: O(1)
   - Implementation: Returns the length counter

3. **PrintQueue**: Returns a string representation of the queue.
   - Time Complexity: O(n)
   - Implementation: Traverses the linked list and joins all values with spaces

## Implementation Details

```javascript
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class MyQueue {
    constructor() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    // Core queue operations
    enqueue(value) {
        const newNode = new Node(value);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    dequeue() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        
        const temp = this.first;
        if (this.length === 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }
        
        this.length--;
        return temp.value;
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue Underflow: Cannot peek from an empty queue.");
        }
        return this.first.value;
    }

    // Helper functions
    isEmpty() {
        return this.length === 0;
    }

    size() {
        return this.length;
    }

    printQueue() {
        let current = this.first;
        const values = [];
        while (current) {
            values.push(current.value);
            current = current.next;
        }
        return values.join(' ');
    }
}
```

## Advantages and Disadvantages

### Advantages
- Both enqueue and dequeue operations have O(1) time complexity
- More efficient for large queues compared to array implementation
- No need to shift elements during dequeue operations

### Disadvantages
- Slightly more complex implementation than array-based queue
- Additional memory overhead for storing node pointers
- No random access to elements (must traverse from the beginning)

## Complexity Analysis

- **Enqueue**: O(1) time complexity
- **Dequeue**: O(1) time complexity
- **Peek**: O(1) time complexity
- **Space Complexity**: O(n) where n is the number of elements in the queue
# **Enqueue/Dequeue with Stacks**

## **Problem Statement**
Implement a queue using two stacks. The queue should support enqueue (push) and dequeue (pop) operations.

---

## **Examples**

### Example 1:
```
queue = QueueWithStacks()
queue.enqueue(1)
queue.enqueue(2)
queue.dequeue()  # Returns 1
queue.enqueue(3)
queue.dequeue()  # Returns 2
```

---

## **Algorithmic Approach**

Use two stacks: `stack1` for enqueue, `stack2` for dequeue.

### Enqueue:
- Push to stack1.

### Dequeue:
- If stack2 is empty: Move all elements from stack1 to stack2.
- Pop from stack2.

This reverses the order, giving FIFO behavior.

---

## **Time and Space Complexity**

- **Enqueue**: `O(1)`
- **Dequeue**: Amortized `O(1)`, worst case `O(n)`
- **Space Complexity**: `O(n)` for storing n elements.

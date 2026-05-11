# Implement Stack using Queues

## Problem
Implement a last-in-first-out (LIFO) stack using only a single queue. The stack must support `push`, `pop`, `top`, and `isEmpty` operations.

LeetCode: https://leetcode.com/problems/implement-stack-using-queues/

---

## Approach — Single Queue (rotation)

After each `push`, rotate all previously enqueued elements to the back so the newest element is always at the front. Uses a plain array as a queue (`push` to enqueue, `shift` to dequeue).

| Operation | Time | Space |
| --------- | ---- | ----- |
| `push`    | O(n) | O(1)  |
| `pop`     | O(1) | O(1)  |
| `top`     | O(1) | O(1)  |
| `isEmpty` | O(1) | O(1)  |

---

## Steps

1. `push(x)`: `queue.push(x)`, then loop `size - 1` times doing `queue.push(queue.shift())`.
2. `pop()`: `queue.shift()`.
3. `top()`: `queue[0]`.
4. `isEmpty()`: `queue.length === 0`.

### Rotation explained
```
push(1): queue = [1]
push(2): push 2 → [1, 2], rotate 1 → [2, 1]
push(3): push 3 → [2, 1, 3], rotate 2 → [3, 2, 1]

pop() → shift() = 3  (LIFO ✓)
top() → [0]     = 2  (LIFO ✓)
```

---

## Test Cases

| Operations                              | Expected Output |
| --------------------------------------- | --------------- |
| push(1), push(2), push(3), top()        | 3               |
| push(1), push(2), push(3), isEmpty()    | false           |
| push(1), push(2), push(3), pop()        | 3               |
| push(1), push(2), push(3), pop(), top() | 2               |
| push(1), pop(), isEmpty()               | true            |
| push(10), push(20), top()               | 20              |
| push(10), push(20), pop(), top()        | 10              |

### Walkthrough

```
stack = new MyStack()

push(1)   → queue: [1]
push(2)   → queue: [2, 1]
push(3)   → queue: [3, 2, 1]

top()     → 3
pop()     → 3   queue: [2, 1]
top()     → 2
pop()     → 2   queue: [1]
pop()     → 1   queue: []
isEmpty() → true

push(10)  → queue: [10]
push(20)  → queue: [20, 10]
top()     → 20
pop()     → 20  queue: [10]
top()     → 10
```

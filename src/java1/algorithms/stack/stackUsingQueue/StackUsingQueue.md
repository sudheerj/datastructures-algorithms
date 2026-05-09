# Implement Stack using Queues

## Problem
Implement a last-in-first-out (LIFO) stack using only a single queue. The stack must support `push`, `pop`, `top`, and `isEmpty` operations.

LeetCode: https://leetcode.com/problems/implement-stack-using-queues/

---

## Approach — Single Queue (rotation)

After each `push`, rotate all previously enqueued elements to the back so the newest element is always at the front of the queue. This makes `pop` and `top` O(1) at the cost of O(n) per `push`.

| Operation | Time  | Space |
|-----------|-------|-------|
| `push`    | O(n)  | O(1)  |
| `pop`     | O(1)  | O(1)  |
| `top`     | O(1)  | O(1)  |
| `isEmpty` | O(1)  | O(1)  |

---

## Steps

1. `push(x)`: Add `x` to the queue, then rotate all previous elements (`size - 1` times) to the back.
2. `pop()`: Remove and return the front of the queue.
3. `top()`: Peek the front of the queue.
4. `isEmpty()`: Return whether the queue is empty.

### Rotation explained
```
push(1): queue = [1]
push(2): add 2 → [1, 2], rotate 1 → [2, 1]
push(3): add 3 → [2, 1, 3], rotate 2 → [3, 2, 1]

pop() → removes 3  (LIFO ✓)
top() → peeks  2   (LIFO ✓)
```

---

## Test Cases

| Operations                                  | Expected Output       |
|---------------------------------------------|-----------------------|
| push(1), push(2), push(3), top()            | 3                     |
| push(1), push(2), push(3), isEmpty()        | false                 |
| push(1), push(2), push(3), pop()            | 3                     |
| push(1), push(2), push(3), pop(), top()     | 2                     |
| push(1), pop(), isEmpty()                   | true                  |
| push(10), push(20), top()                   | 20                    |
| push(10), push(20), pop(), top()            | 10                    |

### Walkthrough

```
stack = new MyStack()

push(1) → queue: [1]
push(2) → queue: [2, 1]          (rotated 1 old element)
push(3) → queue: [3, 2, 1]       (rotated 2 old elements)

top()   → 3   (front of queue)
pop()   → 3   queue: [2, 1]
top()   → 2
pop()   → 2   queue: [1]
pop()   → 1   queue: []
isEmpty() → true

push(10) → queue: [10]
push(20) → queue: [20, 10]
top()    → 20
pop()    → 20  queue: [10]
top()    → 10
```

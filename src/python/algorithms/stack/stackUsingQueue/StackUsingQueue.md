# Implement Stack using Queues

## Problem
Implement a last-in-first-out (LIFO) stack using only a single queue. The stack must support `push`, `pop`, `top`, and `is_empty` operations.

LeetCode: https://leetcode.com/problems/implement-stack-using-queues/

---

## Approach — Single Queue (rotation)

After each `push`, rotate all previously enqueued elements to the back so the newest element is always at the front of the queue. This makes `pop` and `top` O(1) at the cost of O(n) per `push`.

Uses Python's `collections.deque` for efficient O(1) `append` and `popleft`.

| Operation  | Time | Space |
| ---------- | ---- | ----- |
| `push`     | O(n) | O(1)  |
| `pop`      | O(1) | O(1)  |
| `top`      | O(1) | O(1)  |
| `is_empty` | O(1) | O(1)  |

---

## Steps

1. `push(x)`: Append `x` to the deque, then rotate all previous elements (`size - 1` times) to the back.
2. `pop()`: `popleft()` from the deque.
3. `top()`: Return `queue[0]`.
4. `is_empty()`: Return `len(queue) == 0`.

### Rotation explained
```
push(1): queue = [1]
push(2): append 2 → [1, 2], rotate 1 → [2, 1]
push(3): append 3 → [2, 1, 3], rotate 2 → [3, 2, 1]

pop() → popleft() = 3  (LIFO ✓)
top() → queue[0]  = 2  (LIFO ✓)
```

---

## Test Cases

| Operations                              | Expected Output |
| --------------------------------------- | --------------- |
| push(1), push(2), push(3), top()        | 3               |
| push(1), push(2), push(3), is_empty()   | False           |
| push(1), push(2), push(3), pop()        | 3               |
| push(1), push(2), push(3), pop(), top() | 2               |
| push(1), pop(), is_empty()              | True            |
| push(10), push(20), top()               | 20              |
| push(10), push(20), pop(), top()        | 10              |

### Walkthrough

```
stack = MyStack()

push(1) → queue: [1]
push(2) → queue: [2, 1]
push(3) → queue: [3, 2, 1]

top()      → 3
pop()      → 3   queue: [2, 1]
top()      → 2
pop()      → 2   queue: [1]
pop()      → 1   queue: []
is_empty() → True

push(10)   → queue: [10]
push(20)   → queue: [20, 10]
top()      → 20
pop()      → 20  queue: [10]
top()      → 10
```

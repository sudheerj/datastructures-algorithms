**Problem statement:** Implement a first-in-first-out (FIFO) queue using only two stacks. The implemented queue should support `push(x)`, `pop()`, `peek()`, and `isEmpty()` operations. (LeetCode 232)

## Examples:

```
push(1), push(2), push(3)
pop()  → 1   // FIFO: first in, first out
pop()  → 2
peek() → 3   // returns front without removing

push(10), push(20)
peek() → 10
pop()  → 10  // peek did not remove the element
isEmpty() → false
```

**Algorithmic Steps - Approach 1 (push O(1), pop/peek O(n)):**

1. Use `stack1` as primary storage and `stack2` as a temporary buffer.
2. **push(x):** Push directly onto `stack1`.
3. **pop():** Move all elements except the bottom-most from `stack1` to `stack2`, pop the bottom (front of queue) from `stack1`, then move all back from `stack2` to `stack1`.
4. **peek():** Same as pop() but use `stack1.peek()` instead of `stack1.pop()` at the bottom.
5. **isEmpty():** Return `stack1.isEmpty()`.

**Algorithmic Steps - Approach 2 (push O(1), pop/peek amortized O(1)):**

1. Use `stack1` as the input stack and `stack2` as the output stack.
2. **push(x):** Push onto `stack1`.
3. **pop():** If `stack2` is empty, transfer all elements from `stack1` to `stack2` (reversing order). Then pop from `stack2`.
4. **peek():** Same as pop() but use `stack2.peek()` instead of `stack2.pop()`.
5. **isEmpty():** Return `true` only when both stacks are empty.

**Time and Space complexity:**

| Approach | push | pop | peek | isEmpty | Space |
|---|---|---|---|---|---|
| Approach 1 (eager reversal) | O(1) | O(n) | O(n) | O(1) | O(n) |
| Approach 2 (lazy transfer) | O(1) | O(1) amortized | O(1) amortized | O(1) | O(n) |

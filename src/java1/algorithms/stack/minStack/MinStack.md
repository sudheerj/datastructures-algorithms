**Problem statement:** Design a stack that supports `push(val)`, `pop()`, `top()`, and `getMin()` — all in O(1) time. `getMin` must return the minimum element in the stack at any time. (LeetCode 155)

## Examples:

```
push(5) → getMin() = 5
push(3) → getMin() = 3
push(7) → getMin() = 3   // 7 > 3, min unchanged
push(2) → getMin() = 2
top()   = 2
pop()   → getMin() = 3   // 2 removed, prev min restored
pop()   → getMin() = 3   // 7 removed, min still 3
pop()   → getMin() = 5   // 3 removed, min is now 5
```

**Algorithmic Steps - Approach 1 (Two Stacks):**

1. Maintain `stack` (main) and `minStack` (tracks running minimum).
2. **push(val):** Push val onto stack. Push `min(val, minStack.peek())` onto minStack (or val if minStack is empty).
3. **pop():** Pop from both stack and minStack simultaneously.
4. **top():** Return `stack.peek()`.
5. **getMin():** Return `minStack.peek()`.

**Algorithmic Steps - Approach 2 (Single Stack with Pairs):**

1. Each entry in the stack stores `[value, currentMin]` as a pair.
2. **push(val):** Compute `min = stack.isEmpty() ? val : min(val, stack.peek()[1])`. Push `[val, min]`.
3. **pop():** Pop the top pair.
4. **top():** Return `stack.peek()[0]`.
5. **getMin():** Return `stack.peek()[1]`.

**Time and Space complexity:**

| Approach | push | pop | top | getMin | Space |
|---|---|---|---|---|---|
| Approach 1 (two stacks) | O(1) | O(1) | O(1) | O(1) | O(n) |
| Approach 2 (pair stack) | O(1) | O(1) | O(1) | O(1) | O(n) |

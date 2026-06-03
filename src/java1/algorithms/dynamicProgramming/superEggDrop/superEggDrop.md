**Problem statement:** You are given `k` eggs and a building with `n` floors. Find the **minimum number of moves** to determine the highest floor from which a dropped egg does not break (the critical floor). An egg that survives a drop can be reused; a broken egg cannot.

LeetCode #887

### Examples

```
Input:  n=6, k=2
Output: 3
Explanation: Try floor 3. If breaks → check 1,2 (2 moves). If survives → try floor 5, then 6. Worst case = 3.
```

```
Input:  n=10, k=2
Output: 4
Explanation: With t=4 moves and 2 eggs, we can check C(4,1)+C(4,2) = 4+6 = 10 floors.
```

```
Input:  n=14, k=3
Output: 4
Explanation: With t=4 moves and 3 eggs, we can check C(4,1)+C(4,2)+C(4,3) = 4+6+4 = 14 floors.
```

**Algorithmic Steps (DP + Binary Search)**

1. Define `dfs(floors, eggs)` = minimum moves to check `floors` floors with `eggs` eggs.
2. Base cases:
   - `floors == 0` → 0 moves; `floors == 1` → 1 move.
   - `eggs == 1` → must try every floor linearly → return `floors`.
3. For each candidate floor `mid` (binary search over `[1, floors]`):
   - **Egg breaks** at `mid`: check `mid-1` floors below with `eggs-1` → `dfs(mid-1, eggs-1)`.
   - **Egg survives** at `mid`: check `floors-mid` floors above with `eggs` → `dfs(floors-mid, eggs)`.
   - Cost = `1 + max(breakCase, surviveCase)`.
4. Binary search direction: if `breakCase < surviveCase`, move `mid` higher; otherwise move lower — converges where both are equal.
5. Memoize result in `dp[eggs][floors]`.

| Complexity | Value             |
|------------|-------------------|
| Time       | O(k · n · log n)  |
| Space      | O(k · n)          |

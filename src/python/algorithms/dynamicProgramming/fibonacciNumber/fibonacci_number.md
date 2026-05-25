**Problem statement:**
Given `n`, return the `n`-th Fibonacci number. The Fibonacci sequence is defined as:

- `F(0) = 0`
- `F(1) = 1`
- `F(n) = F(n-1) + F(n-2)` for `n > 1`

## Examples:
Input: n = 0 → Output: 0
Input: n = 1 → Output: 1
Input: n = 2 → Output: 1
Input: n = 5 → Output: 5
Input: n = 10 → Output: 55

**Algorithmic Steps**

### Approach 1 — Recursion (Brute Force) `fibonacci1`
1. Base case: if `n <= 1`, return `n`.
2. Return `fibonacci1(n-1) + fibonacci1(n-2)`.

### Approach 2 — Memoization (Top-down DP) `fibonacci2`
1. Use a `memo` dict to cache results.
2. Base case: if `n <= 1`, return `n`; if `n in memo`, return cached.
3. Compute `memo[n] = fibonacci2(n-1) + fibonacci2(n-2)` and return.

### Approach 3 — Tabulation (Bottom-up DP) `fibonacci3`
1. Base case: if `n <= 1`, return `n`.
2. Build `dp[0..n]` with `dp[0]=0`, `dp[1]=1`.
3. Fill `dp[i] = dp[i-1] + dp[i-2]` for `i` from `2` to `n`.
4. Return `dp[n]`.

### Approach 4 — Space-Optimized DP `fibonacci4`
1. Base case: if `n <= 1`, return `n`.
2. Track `first=0`, `second=1`; at each step: `first, second = second, first+second`.
3. Return `second`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Recursion | O(2ⁿ) | O(n) stack |
| Memoization | O(n) | O(n) |
| Tabulation | O(n) | O(n) |
| Space-Optimized | O(n) | O(1) |

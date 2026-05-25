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
2. Return `fibonacci(n-1) + fibonacci(n-2)`.
- Recomputes the same subproblems repeatedly.

### Approach 2 — Memoization (Top-down DP) `fibonacci2`
1. Create a `dp` array of size `n+1`, fill with `-1`.
2. Call `calc(n, dp)` recursively.
3. In `calc`: if `n <= 1` return `n`; if `dp[n] != -1` return cached value.
4. Compute `dp[n] = calc(n-1) + calc(n-2)`, cache and return it.

### Approach 3 — Tabulation (Bottom-up DP) `fibonacci3`
1. Base case: if `n <= 1`, return `n`.
2. Create `dp[0..n]`, set `dp[0]=0`, `dp[1]=1`.
3. For `i` from `2` to `n`: `dp[i] = dp[i-1] + dp[i-2]`.
4. Return `dp[n]`.

### Approach 4 — Space-Optimized DP `fibonacci4`
1. Base case: if `n <= 1`, return `n`.
2. Track only the last two values: `first=0`, `second=1`.
3. For `i` from `2` to `n`: `curr = first + second; first = second; second = curr`.
4. Return `second`.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Recursion | O(2ⁿ) | O(n) stack |
| Memoization | O(n) | O(n) |
| Tabulation | O(n) | O(n) |
| Space-Optimized | O(n) | O(1) |

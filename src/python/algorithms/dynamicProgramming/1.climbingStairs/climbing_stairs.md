# Climbing Stairs

**Description:**
Given a staircase with `n` steps, each time you can climb either 1 or 2 steps. Return the number of distinct ways to reach the top.

**Constraints:**
- `0 <= n <= 100`
- Input must be a non-negative integer.

#### Examples
| n   | Output | Explanation           |
| --- | ------ | --------------------- |
| 0   | 0      | No steps to climb     |
| 1   | 1      | Only one way (1)      |
| 2   | 2      | (1+1), (2)            |
| 3   | 3      | (1+1+1), (1+2), (2+1) |
| 5   | 8      |                       |
| 6   | 13     |                       |

### Approaches

#### 1. Recursive with Memoization
- Recursively compute the number of ways for `n-1` and `n-2` steps, memoizing results to avoid recomputation.

**Steps:**
1. If `n` is 0 or 1 or 2, return `n` (base cases: 0 ways for 0 steps, 1 way for 1 step, 2 ways for 2 steps).
2. Use a memoization dictionary to store results for each value of `n` to avoid redundant calculations.
3. For each call, check if the result for `n` is already in the memo. If so, return it.
4. Otherwise, recursively calculate the number of ways for `n-1` and `n-2` steps.
5. Store the result in the memo and return the sum.

#### 2. Dynamic Programming (Bottom-Up Array)
- Build up the solution from 0 to n using an array.

**Steps:**
1. If `n` is 0 or 1 or 2, return `n` (base cases).
2. Create an array `dp` of size `n+1` to store the number of ways to reach each step.
3. Initialize `dp[0] = 1` (1 way to stay at the bottom) and `dp[1] = 1` (1 way to reach the first step).
4. Iterate from step 2 to `n`:
    - For each step `i`, set `dp[i] = dp[i-1] + dp[i-2]` (ways to reach current step is sum of ways to reach previous step and two steps before).
5. Return `dp[n]` as the answer.

#### 3. Optimized Dynamic Programming (Fibonacci)
- Only keep track of the last two results, reducing space to O(1).

**Steps:**
1. If `n` is 0 or 1 or 2, return `n` (base cases).
2. Initialize two variables: `first = 1` (ways to reach step 0), `second = 1` (ways to reach step 1).
3. Iterate from step 2 to `n`:
    - For each step, calculate the new number of ways as `first + second`.
    - Update `first` to `second`, and `second` to the new value.
4. After the loop, `second` contains the number of ways to reach the top.

| Approach       | Time Complexity | Space Complexity | Notes                |
| -------------- | --------------- | ---------------- | -------------------- |
| Recursive+Memo | O(n)            | O(n)             | Elegant, not fastest |
| DP Array       | O(n)            | O(n)             | Simple, clear        |
| Optimized DP   | O(n)            | O(1)             | Best for large n     |

### Edge Cases
- `n = 0`: Return 0.
- `n = 1`: Return 1.
- Large `n`: Use optimized DP to avoid stack overflow.

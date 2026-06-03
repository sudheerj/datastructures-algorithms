# Regular Expression Matching

**Problem statement:** Given an input string `s` and a pattern `p`, implement regular expression matching with support for `.` and `*` where `.` matches any single character and `*` matches zero or more of the preceding element. The matching should cover the entire input string.

## Examples:

```
Input: s = "aa", p = "a"
Output: false  (pattern must match entire string)

Input: s = "aa", p = "a*"
Output: true  (a* means zero or more 'a')

Input: s = "ab", p = ".*"
Output: true  (.* matches any sequence)

Input: s = "aab", p = "c*a*b"
Output: true  (c* matches "", a* matches "aa", b matches "b")
```

## Approach 1: Top-Down Memoization (DFS)

Recurse over positions `(i, j)` in `s` and `p`. At each step, decide whether the current pattern character matches and whether to consume a `x*` pair (skip it or use it). Cache results in a 2D memo table.

**Algorithmic Steps**

1. If `j == n` (pattern exhausted), return `i == m` (valid only if string also exhausted).
2. Compute `match = (i < m) && (p[j] == s[i] || p[j] == '.')`.
3. If `p[j+1] == '*'`: result is `dfs(i, j+2)` (skip `x*`) OR (`match` AND `dfs(i+1, j)`) (consume one char).
4. Otherwise: result is `match && dfs(i+1, j+1)`.
5. Store result in `memo[i][j]` and return.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(m × n) |
| Space | O(m × n) |

## Approach 2: Bottom-Up DP

Fill a `(m+1) × (n+1)` DP table bottom-up. `dp[i][j]` is `true` if `s[i:]` matches `p[j:]`. Initialize `dp[m][n] = true` and iterate from end to start.

**Algorithmic Steps**

1. Create `dp[m+1][n+1]`, set `dp[m][n] = true`.
2. Iterate `i` from `m` down to `0`, `j` from `n-1` down to `0`.
3. Compute `match = (i < m) && (p[j] == s[i] || p[j] == '.')`.
4. If `p[j+1] == '*'`: `dp[i][j] = dp[i][j+2]` (skip) OR (`match && dp[i+1][j]`) (use).
5. Else: `dp[i][j] = match && dp[i+1][j+1]`.
6. Return `dp[0][0]`.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(m × n) |
| Space | O(m × n) |

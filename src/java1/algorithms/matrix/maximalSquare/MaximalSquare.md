# Maximal Square

## Problem
Given an `m x n` binary matrix filled with `'0'`s and `'1'`s, find the **largest square** containing only `'1'`s and return its area.

LeetCode: https://leetcode.com/problems/maximal-square/

---

## Approach

**Dynamic Programming — O(m×n) / O(m×n)**

`dp[r][c]` = side length of the largest square whose **bottom-right corner** is `(r, c)`.

- If `matrix[r][c] == '0'`: `dp[r][c] = 0`.
- If on the first row or column: `dp[r][c] = 1`.
- Otherwise: `dp[r][c] = 1 + min(dp[r-1][c], dp[r][c-1], dp[r-1][c-1])`.

Track `maxSide` and return `maxSide²`.

---

## Steps

1. Create `dp[rows][cols]`, `maxSide = 0`.
2. For each cell `(r, c)`:
   - Skip if `'0'`.
   - Edge cell: `dp[r][c] = 1`.
   - Inner cell: `dp[r][c] = 1 + min(top, left, top-left)`.
   - Update `maxSide`.
3. Return `maxSide * maxSide`.

---

## Example

```
matrix:
  1 0 1 0 0
  1 0 1 1 1
  1 1 1 1 1
  1 0 0 1 0

dp:
  1 0 1 0 0
  1 0 1 1 1
  1 1 1 2 2
  1 0 0 1 0

maxSide = 2  →  area = 4
```

---

## Test Cases

| matrix                                | output |
|---------------------------------------|--------|
| [[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]] | 4 |
| [[0,1],[1,0]]                         | 1      |
| [[0]]                                 | 0      |
| [[1,1,1],[1,1,1],[1,1,1]]             | 9      |
| [[1]]                                 | 1      |

---

## Complexity

| | Time | Space |
|-|------|-------|
| DP | O(m×n) | O(m×n) |

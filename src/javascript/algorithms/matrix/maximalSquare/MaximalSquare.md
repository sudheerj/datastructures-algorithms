# Maximal Square

## Problem
Given an `m x n` binary matrix filled with `'0'`s and `'1'`s, find the **largest square** containing only `'1'`s and return its area.

LeetCode: https://leetcode.com/problems/maximal-square/

---

## Approach

**Dynamic Programming — O(m×n) / O(m×n)**

`dp[r][c]` = side length of the largest all-1 square with bottom-right corner at `(r, c)`.

- `matrix[r][c] === '0'`: `dp[r][c] = 0`.
- Edge cell: `dp[r][c] = 1`.
- Inner cell: `dp[r][c] = 1 + Math.min(top, left, top-left)`.

---

## Steps

1. `dp = zeros(rows, cols)`, `maxSide = 0`.
2. For each cell: if `'1'`, compute `dp[r][c]`, update `maxSide`.
3. Return `maxSide * maxSide`.

---

## Example

```
matrix:              dp:
1 0 1 0 0            1 0 1 0 0
1 0 1 1 1            1 0 1 1 1
1 1 1 1 1            1 1 1 2 2
1 0 0 1 0            1 0 0 1 0

maxSide=2 → area=4
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

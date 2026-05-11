# Transpose of a Matrix

## Problem
Given a 2D integer array `matrix`, return the **transpose** of `matrix`.

The transpose of a matrix is the matrix flipped over its main diagonal, swapping `matrix[r][c]` with `matrix[c][r]`.

LeetCode: https://leetcode.com/problems/transpose-matrix/

---

## Approach

Create a new `cols × rows` result matrix and assign `result[c][r] = matrix[r][c]` for every element.

**TC: O(m × n) — SC: O(m × n)**

---

## Steps

1. Read `rows = matrix.length`, `cols = matrix[0].length`.
2. Allocate `result[cols][rows]`.
3. For each `r` in `[0, rows)` and `c` in `[0, cols)`: `result[c][r] = matrix[r][c]`.
4. Return `result`.

---

## Example

```
Input:
  [[1, 2, 3],
   [4, 5, 6]]

Swap indices:
  result[0][0]=matrix[0][0]=1   result[1][0]=matrix[0][1]=2   result[2][0]=matrix[0][2]=3
  result[0][1]=matrix[1][0]=4   result[1][1]=matrix[1][1]=5   result[2][1]=matrix[1][2]=6

Output:
  [[1, 4],
   [2, 5],
   [3, 6]]
```

---

## Test Cases

| input                     | output                    | notes          |
| ------------------------- | ------------------------- | -------------- |
| [[1,2,3],[4,5,6]]         | [[1,4],[2,5],[3,6]]       | 2×3 → 3×2      |
| [[1,2,3],[4,5,6],[7,8,9]] | [[1,4,7],[2,5,8],[3,6,9]] | 3×3 square     |
| [[42]]                    | [[42]]                    | 1×1            |
| [[1,2,3]]                 | [[1],[2],[3]]             | 1×3 row vector |

### Walkthrough — 3×3

```
Input:
  [1, 2, 3]
  [4, 5, 6]
  [7, 8, 9]

After transpose (swap [r][c] ↔ [c][r]):
  [1, 4, 7]
  [2, 5, 8]
  [3, 6, 9]
```

---

## Complexity

|           | Time     | Space    |
| --------- | -------- | -------- |
| Iterative | O(m × n) | O(m × n) |

> `m` = rows, `n` = columns of the input matrix.

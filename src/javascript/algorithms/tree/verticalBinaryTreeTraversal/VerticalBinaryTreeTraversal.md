# Vertical Order Traversal of a Binary Tree

## Problem
Given the `root` of a binary tree, calculate the **vertical order traversal**.

For each node at `(row, col)`: root = `(0,0)`, left child = `(row+1, col-1)`, right child = `(row+1, col+1)`.
Group results by column (left to right). Within the same column, sort by row; ties broken by node value.

LeetCode: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

---

## Approach

**BFS + Map sorted by column — O(n log n) / O(n)**

BFS assigns `(row, col)` to every node. A Map holds `col → [[row, val]]`. After BFS, sort the column keys and sort each group by `[row, val]`.

---

## Steps

1. Return `[]` if root is `null`.
2. BFS with `[root, 0, 0]`. Push `[row, val]` into `colMap.get(col)`.
3. Enqueue children with `[row+1, col±1]`.
4. Sort column keys; for each col sort entries by `(row, val)` and extract values.

---

## Example

```
         1          (0,0)
        / \
       2   3        (1,-1) and (1,1)
      / \ / \
     4  5 6  7      (2,-2),(2,0),(2,0),(2,2)

col=-2: [[2,4]]        → [4]
col=-1: [[1,2]]        → [2]
col= 0: [[0,1],[2,5],[2,6]] → sort → [1,5,6]
col= 1: [[1,3]]        → [3]
col= 2: [[2,7]]        → [7]

Result: [[4],[2],[1,5,6],[3],[7]]
```

---

## Test Cases

| tree (level-order)       | output                      |
|--------------------------|-----------------------------|
| [3,9,20,null,null,15,7]  | [[9],[3,15],[20],[7]]       |
| [1,2,3,4,5,6,7]          | [[4],[2],[1,5,6],[3],[7]]   |
| [1,2,3,4,6,5,7]          | [[4],[2],[1,5,6],[3],[7]]   |
| [1]                      | [[1]]                       |
| null                     | []                          |

---

## Complexity

| | Time | Space |
|-|------|-------|
| BFS + Map sort | O(n log n) | O(n) |

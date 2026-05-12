# Vertical Order Traversal of a Binary Tree

## Problem
Given the `root` of a binary tree, calculate the **vertical order traversal**.

For each node at `(row, col)`: root = `(0,0)`, left child = `(row+1, col-1)`, right child = `(row+1, col+1)`.
Group results by column (left to right). Within the same column, sort by row; ties broken by node value.

LeetCode: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

---

## Approach

**BFS + defaultdict sorted by column — O(n log n) / O(n)**

BFS assigns `(row, col)` to every node. A dict maps `col → [(row, val)]`. After BFS, iterate over sorted column keys and sort each group by `(row, val)`.

---

## Steps

1. Return `[]` if root is `None`.
2. BFS with `(root, 0, 0)`. Append `(row, val)` to `col_map[col]`.
3. Enqueue children with `(row+1, col±1)`.
4. For each `col` in `sorted(col_map)`: sort entries by `(row, val)`, extract values.

---

## Example

```
         1          (0,0)
        / \
       2   3        (1,-1) and (1,1)
      / \ / \
     4  5 6  7      (2,-2),(2,0),(2,0),(2,2)

col=-2: [(2,4)]      → [4]
col=-1: [(1,2)]      → [2]
col= 0: [(0,1),(2,5),(2,6)] → sort → [1,5,6]
col= 1: [(1,3)]      → [3]
col= 2: [(2,7)]      → [7]

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
| BFS + sorted dict | O(n log n) | O(n) |

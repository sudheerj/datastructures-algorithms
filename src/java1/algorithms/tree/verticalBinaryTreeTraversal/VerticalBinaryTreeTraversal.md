# Vertical Order Traversal of a Binary Tree

## Problem
Given the `root` of a binary tree, calculate the **vertical order traversal**.

For each node at position `(row, col)`:
- Root is `(0, 0)`.
- Left child is `(row+1, col-1)`, right child is `(row+1, col+1)`.

Results are grouped by column (left to right). Within the same column, nodes are sorted by row; within the same row and column, sorted by value.

LeetCode: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

---

## Approach

**BFS + TreeMap (sorted by col) — O(n log n) / O(n)**

BFS assigns each node `(row, col)`. A `TreeMap<col, List<[row, val]>>` keeps columns sorted automatically. After BFS, sort each column's list by `(row, val)` and extract values.

---

## Steps

1. Return `[]` if root is `null`.
2. BFS with `(root, row=0, col=0)`. For each node store `[row, val]` in `TreeMap[col]`.
3. Enqueue left child at `(row+1, col-1)` and right child at `(row+1, col+1)`.
4. For each column in the TreeMap, sort entries by `(row, val)`, extract values, add to result.

---

## Example

```
         1          (0,0)
        / \
       2   3        (-1,1) → (1,-1) and (1,1)
      / \ / \
     4  5 6  7      (2,-2),(2,0),(2,0),(2,2)

col=-2: [4]
col=-1: [2]
col= 0: 1(row0), 5(row2), 6(row2) → sort by row then val → [1,5,6]
col= 1: [3]
col= 2: [7]

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
| BFS + TreeMap + sort | O(n log n) | O(n) |

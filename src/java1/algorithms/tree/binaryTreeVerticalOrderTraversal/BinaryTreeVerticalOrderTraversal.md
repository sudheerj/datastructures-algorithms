# Binary Tree Vertical Order Traversal

## Problem
Given the `root` of a binary tree, return the **vertical order traversal** of its nodes' values (from top to bottom, column by column). For nodes in the same row and column, return them in the order they appear (left to right).

LeetCode: https://leetcode.com/problems/binary-tree-vertical-order-traversal/

---

## Approach

**BFS + Column Map — O(n) / O(n)**

Assign each node a column index: root = 0, left child = parent − 1, right child = parent + 1.
Use BFS (level-order) so that nodes at the same column are visited top-to-bottom.
Track `minCol` and `maxCol` to iterate columns in order at the end.

---

## Steps

1. Edge case: return `[]` if root is `null`.
2. Push `(root, col=0)` onto a BFS queue. Track `minCol = maxCol = 0`.
3. While queue is not empty:
   - Poll `(node, col)`.
   - Append `node.value` to `map[col]`.
   - Update `minCol = min(minCol, col)`, `maxCol = max(maxCol, col)`.
   - Enqueue `(node.left, col-1)` and `(node.right, col+1)` if not null.
4. Collect `map[minCol]` … `map[maxCol]` into the result list.

---

## Example

```
        3          (col 0)
       / \
      9  20        (cols -1, 1)
         / \
        15   7     (cols 0, 2)

BFS order: 3(0) → 9(-1) → 20(1) → 15(0) → 7(2)

map = { -1:[9], 0:[3,15], 1:[20], 2:[7] }

Result: [[9], [3,15], [20], [7]]
```

---

## Test Cases

| tree (level-order)          | output                    |
|-----------------------------|---------------------------|
| [3,9,20,null,null,15,7]     | [[9],[3,15],[20],[7]]     |
| [3,9,8,4,0,1,7]             | [[4],[9],[3,0,1],[8],[7]] |
| [1]                         | [[1]]                     |
| null                        | []                        |
| [1,2,3]                     | [[2],[1],[3]]             |

---

## Complexity

| | Time | Space |
|-|------|-------|
| BFS + Column Map | O(n) | O(n) |

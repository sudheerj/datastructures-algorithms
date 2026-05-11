# Binary Tree Vertical Order Traversal

## Problem
Given the `root` of a binary tree, return the **vertical order traversal** of its nodes' values (from top to bottom, column by column).

LeetCode: https://leetcode.com/problems/binary-tree-vertical-order-traversal/

---

## Approach

**BFS + Column Map — O(n) / O(n)**

Assign column indices during BFS. Root = 0, left child = parent − 1, right child = parent + 1.
BFS guarantees top-to-bottom order within each column naturally.

---

## Steps

1. Return `[]` if root is `null`.
2. Push `[root, 0]` onto a queue. Track `minCol = maxCol = 0`.
3. While queue is non-empty:
   - Shift `[node, col]`.
   - Push `node.val` into `colMap[col]`.
   - Update `minCol`, `maxCol`.
   - Enqueue children with adjusted columns.
4. Collect `colMap[c]` for `c` from `minCol` to `maxCol` (inclusive).

---

## Example

```
        3          (col 0)
       / \
      9  20        (cols -1, 1)
         / \
        15   7     (cols 0, 2)

BFS: 3(0) → 9(-1) → 20(1) → 15(0) → 7(2)

colMap = { -1:[9], 0:[3,15], 1:[20], 2:[7] }

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

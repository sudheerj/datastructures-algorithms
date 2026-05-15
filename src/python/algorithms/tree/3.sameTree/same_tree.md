# **Same Tree**

## **Problem Statement**
Given roots of two binary trees, check if they are the same (structurally identical with same node values).

---

## **Examples**

### Example 1:
- **Input**: `p = [0,1,2,3,4,5,6], q = [0,1,2,3,4,5,6]`
- **Output**: `true`

### Example 2:
- **Input**: `p = [1,2,3], q = [1,3,2]`
- **Output**: `false`

### Example 3:
- **Input**: `p = [1,2], q = [1,null,2]`
- **Output**: `false`

---

## **Approaches**

### 1. Recursive DFS (`is_same_tree_recursive`) — TC: O(n), SC: O(h)
1. If both null: return `True`.
2. If one null or values differ: return `False`.
3. Recursively check left and right subtrees.

### 2. Iterative BFS (`is_same_tree_iterative`) — TC: O(n), SC: O(w)
1. Enqueue the root pair `(p, q)`.
2. Pop a pair; if both `None`, `continue`. If one is `None` or values differ, return `False`.
3. Enqueue all four children (including `None`s to detect structural mismatches).
4. Return `True` when the queue is empty.

### 3. Iterative DFS (`is_same_tree_iterative_dfs`) — TC: O(n), SC: O(h)
1. Push the root pair `(p, q)` onto a stack.
2. Pop a pair; if both `None`, `continue`. If one is `None` or values differ, return `False`.
3. Push left children pair and right children pair.
4. Return `True` when the stack is empty.

---

## **Test Examples**

| # | Tree p | Tree q | Expected |
|---|--------|--------|----------|
| 1 | `[0,1,2,3,4,5,6]` | `[0,1,2,3,4,5,6]` | `True` |
| 2 | `[1,2,3]` | `[1,3,2]` | `False` |
| 3 | `[1,2]` | `[1,null,2]` | `False` |
| 4 | `None` | `None` | `True` |
| 5 | `[1]` | `None` | `False` |
| 6 | `[5]` | `[5]` | `True` |
| 7 | `[1]` | `[2]` | `False` |

---

## **Time and Space Complexity**

| Approach | Time | Space |
|----------|------|-------|
| Recursive DFS | O(n) | O(h) |
| Iterative BFS | O(n) | O(w) |
| Iterative DFS | O(n) | O(h) |

`n` = number of nodes, `h` = tree height, `w` = maximum tree width.

**Problem statement:** A BST has exactly **two nodes swapped** by mistake. Recover the tree without changing its structure (restore it to a valid BST).

LeetCode #99

### Examples

```
Input:  [1, 3, null, null, 2]   (3 and 1 are swapped)
         1
        /
       3
        \
         2
Output: [3, 1, null, null, 2]  → inorder: [1, 2, 3]
```

```
Input:  [3, 1, 4, null, null, 2]   (3 and 2 are swapped)
           3
          / \
         1   4
            /
           2
Output: [2, 1, 4, null, null, 3]  → inorder: [1, 2, 3, 4]
```

```
Input:  [4, 2, 6, 1, 5, 3, 7]   (5 and 3 are swapped)
           4
          / \
         2   6
        / \ / \
       1  5 3  7
Output: [4, 2, 6, 1, 3, 5, 7]  → inorder: [1, 2, 3, 4, 5, 6, 7]
```

**Algorithmic Steps (Inorder Traversal)**

1. Perform inorder traversal (left → node → right), which visits nodes in ascending order for a valid BST.
2. Track the **previous node** (`prev`) seen during traversal.
3. When `prev.value > node.value`, an inversion is detected:
   - **First violation**: set `first = prev` (the larger, out-of-place node).
   - **Second violation** (or same if adjacent swap): update `second = node` (the smaller node).
4. After traversal, swap `first.value` and `second.value` to restore the BST.

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(h)  |

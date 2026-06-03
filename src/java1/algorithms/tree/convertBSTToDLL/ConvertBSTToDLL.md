# Convert BST to Doubly Linked List

**Problem statement:** Given the root of a Binary Search Tree (BST), convert it into a sorted circular (or linear) Doubly Linked List (DLL) in-place. The left pointer of a node acts as the previous pointer and the right pointer acts as the next pointer. Return the head of the DLL (the node with the smallest value).

## Examples:

```
Input BST:
       4
      / \
     2   6
    / \ / \
   1  3 5  7

Output DLL: 1 ↔ 2 ↔ 3 ↔ 4 ↔ 5 ↔ 6 ↔ 7
(head = node with value 1)

Input BST: 3 → 2 → 1 (left-skewed)
Output DLL: 1 ↔ 2 ↔ 3
```

## Approach 1: In-Order DFS with prev pointer

Perform an in-order traversal (left → node → right). Track the previously visited node (`prev`). On the first visit (`prev == null`), set the head. Otherwise, link `prev.right = node` and `node.left = prev`. Advance `prev` to the current node.

**Algorithmic Steps**

1. Initialize `head = null` and `prev = null`.
2. Run in-order DFS on the BST.
3. At each node: if `prev == null`, set `head = node` (leftmost node becomes head).
4. Otherwise, link `prev.right = node` and `node.left = prev`.
5. Set `prev = node` and recurse right.
6. Return `head`.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(n) |
| Space | O(h) recursion stack (h = tree height) |

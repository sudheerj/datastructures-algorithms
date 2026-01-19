# **Invert Binary Tree**

## **Problem Statement**
Given the root of a binary tree, invert the tree and return its root.

---

## **Examples**

### Example 1:
- **Input**: `root = [4,2,7,1,3,6,9]`
- **Output**: `[4,7,2,9,6,3,1]`

---

## **Algorithmic Approach**

### Recursive:
1. Base case: if node is null, return null.
2. Swap left and right children.
3. Recursively invert left and right subtrees.
4. Return root.

### Iterative (BFS):
1. Use queue starting with root.
2. For each node, swap its children.
3. Add non-null children to queue.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(h)` recursive, `O(n)` iterative  
  Where h is height of tree.

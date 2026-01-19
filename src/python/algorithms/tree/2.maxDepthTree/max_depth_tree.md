# **Maximum Depth of Binary Tree**

## **Problem Statement**
Given the root of a binary tree, return its maximum depth (number of nodes along the longest path from root to leaf).

---

## **Examples**

### Example 1:
- **Input**: `root = [3,9,20,null,null,15,7]`
- **Output**: `3`

---

## **Algorithmic Approach**

### Recursive:
1. Base case: if node is null, return 0.
2. Return 1 + max(depth of left, depth of right).

### Iterative (BFS):
1. Level order traversal.
2. Count number of levels.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(h)` recursive, `O(n)` iterative  
  Where h is height of tree.

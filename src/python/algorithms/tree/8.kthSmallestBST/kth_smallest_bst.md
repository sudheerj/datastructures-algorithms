# **Kth Smallest Element in BST**

## **Problem Statement**
Given root of a BST and integer k, return the kth smallest value.

---

## **Examples**

### Example 1:
- **Input**: `root = [3,1,4,null,2], k = 1`
- **Output**: `1`

### Example 2:
- **Input**: `root = [5,3,6,2,4,null,null,1], k = 3`
- **Output**: `3`

---

## **Algorithmic Approach (Inorder Traversal)**

BST inorder traversal visits nodes in sorted order:
1. Traverse left subtree.
2. Visit current (decrement k).
3. If k == 0: Return current value.
4. Traverse right subtree.

Can be done iteratively with stack.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(h + k)`  
  Go down to leftmost, then k steps.

- **Space Complexity**: `O(h)`  
  Stack/recursion depth.

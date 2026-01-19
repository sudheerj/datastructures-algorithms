# **Lowest Common Ancestor of BST**

## **Problem Statement**
Given a BST and two nodes, find their lowest common ancestor.

---

## **Examples**

### Example 1:
- **Input**: `root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8`
- **Output**: `6`

---

## **Algorithmic Approach**

Leverage BST property:
1. If both p and q are less than current: Go left.
2. If both p and q are greater than current: Go right.
3. Otherwise: Current node is LCA (split point).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(h)`  
  Where h is height of tree.

- **Space Complexity**: `O(1)` iterative, `O(h)` recursive

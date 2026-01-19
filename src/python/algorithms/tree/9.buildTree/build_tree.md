# **Construct Binary Tree from Preorder and Inorder**

## **Problem Statement**
Given preorder and inorder traversal of a tree, construct the binary tree.

---

## **Examples**

### Example 1:
- **Input**: `preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]`
- **Output**: `[3,9,20,null,null,15,7]`

---

## **Algorithmic Approach**

1. First element of preorder is root.
2. Find root in inorder - elements left are left subtree, right are right subtree.
3. Recursively construct left and right subtrees.

Use hash map for O(1) lookup in inorder array.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  With hash map for inorder lookup.

- **Space Complexity**: `O(n)`  
  Hash map and recursion.

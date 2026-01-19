# **Same Tree**

## **Problem Statement**
Given roots of two binary trees, check if they are the same (structurally identical with same node values).

---

## **Examples**

### Example 1:
- **Input**: `p = [1,2,3], q = [1,2,3]`
- **Output**: `true`

### Example 2:
- **Input**: `p = [1,2], q = [1,null,2]`
- **Output**: `false`

---

## **Algorithmic Approach**

### Recursive:
1. If both null: return true.
2. If one null or values differ: return false.
3. Recursively check left and right subtrees.

### Iterative:
1. Use queue with pairs of nodes.
2. Compare each pair and add children.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(h)`  
  Where h is minimum height of trees.

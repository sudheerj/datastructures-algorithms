# **Maximum Path Sum**

## **Problem Statement**
Find the maximum path sum in a binary tree. A path is any sequence of nodes from any node to any other node (not necessarily root to leaf).

---

## **Examples**

### Example 1:
- **Input**: `root = [1,2,3]`
- **Output**: `6` (2 → 1 → 3)

### Example 2:
- **Input**: `root = [-10,9,20,null,null,15,7]`
- **Output**: `42` (15 → 20 → 7)

---

## **Algorithmic Approach**

1. For each node, calculate:
   - Max path through this node (left + node + right).
   - Max path ending at this node (for parent's calculation).
2. Update global maximum.
3. Return max of (node + left, node + right, node) to parent.

Negative paths can be ignored (take 0 instead).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(h)`  
  Recursion depth.

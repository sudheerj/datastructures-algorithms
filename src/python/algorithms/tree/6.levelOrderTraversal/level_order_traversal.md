# **Binary Tree Level Order Traversal**

## **Problem Statement**
Given root of a binary tree, return the level order traversal of its nodes' values (level by level from left to right).

---

## **Examples**

### Example 1:
- **Input**: `root = [3,9,20,null,null,15,7]`
- **Output**: `[[3],[9,20],[15,7]]`

---

## **Algorithmic Approach (BFS)**

1. Use queue initialized with root.
2. For each level:
   - Process all nodes in queue.
   - Add their values to current level list.
   - Add children to queue for next level.
3. Return list of levels.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(n)`  
  Queue can hold up to n/2 nodes (last level).

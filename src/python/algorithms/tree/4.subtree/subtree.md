# **Subtree of Another Tree**

## **Problem Statement**
Given roots of two trees, check if the second tree is a subtree of the first.

---

## **Examples**

### Example 1:
- **Input**: `root = [3,4,5,1,2], subRoot = [4,1,2]`
- **Output**: `true`

---

## **Algorithmic Approach**

1. For each node in main tree:
   - Check if subtree rooted at this node is same as subRoot.
2. Use "same tree" comparison for each potential match.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m * n)`  
  Where m and n are sizes of trees.

- **Space Complexity**: `O(h)`  
  Recursion depth.

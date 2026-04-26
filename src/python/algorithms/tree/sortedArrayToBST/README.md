# Sorted Array to Binary Search Tree (BST)

Given a sorted array, convert it to a height-balanced BST.

## Approach
- Pick the middle element as root, recursively build left and right subtrees.
- Time: O(n), Space: O(log n) recursion stack.

## Example
Input: [-10, -3, 0, 5, 9]
Output (preorder): 0 -10 -3 5 9 (structure may vary)

## Test Cases
- [] → (empty tree)
- [0] → 0
- [1,2] → 1 2 or 2 1
- [-10,-3,0,5,9] → 0 -10 -3 5 9

---

## Java, Python, JavaScript Implementations
See respective folders for code and test examples.

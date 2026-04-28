## Unique Binary Search Trees II

Given an integer n, return all structurally unique BSTs (binary search trees) that store values 1 ... n.

### Examples

**Example 1**
Input: n = 3
Output: 5 unique BSTs (see below for preorder traversals)

**Example 2**
Input: n = 1
Output: 1 unique BST

**Example 3**
Input: n = 0
Output: 0 unique BSTs (empty list)

### Approach
- Use recursion with memoization (DP) to generate all trees for each range [left, right].
- For each root, combine all left and right subtree possibilities.
- Time Complexity: Catalan number C(n), exponential in n
- Space Complexity: Exponential in n (output size)

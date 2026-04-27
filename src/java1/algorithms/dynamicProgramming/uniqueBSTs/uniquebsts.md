## Unique Binary Search Trees

Given n, how many structurally unique BSTs (binary search trees) that store values 1 ... n?

### Examples

**Example 1**
Input: n = 3
Output: 5

**Example 2**
Input: n = 1
Output: 1

**Example 3**
Input: n = 0
Output: 1

**Example 4**
Input: n = 4
Output: 14

**Example 5**
Input: n = 5
Output: 42

### Approach
- Use dynamic programming (Catalan numbers):
  - dp[0] = dp[1] = 1
  - For each number of nodes, sum over all possible roots: dp[nodes] += dp[left] * dp[right]
- Time Complexity: O(n^2)
- Space Complexity: O(n)

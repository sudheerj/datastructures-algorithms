## Combinations

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

### Examples

**Example 1**
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

**Example 2**
Input: n = 1, k = 1
Output: [[1]]

**Example 3**
Input: n = 3, k = 1
Output: [[1],[2],[3]]

**Example 4**
Input: n = 3, k = 3
Output: [[1,2,3]]

**Example 5**
Input: n = 5, k = 3
Output: 10 combinations

### Approach
- Use backtracking to build all k-length combinations from 1 to n.
- At each step, add the next number and recurse until the combination is of length k.
- Time Complexity: O(C(n, k) * k)
- Space Complexity: O(C(n, k) * k)

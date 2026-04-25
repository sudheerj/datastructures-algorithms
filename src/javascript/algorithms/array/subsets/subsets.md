## Subsets

Given an integer array nums, return all possible subsets (the power set).

### Examples

**Example 1**
Input: [1,2,3]
Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]

**Example 2**
Input: [0]
Output: [[], [0]]

**Example 3**
Input: []
Output: [[]]

### Approach
- Use backtracking (DFS) to generate all subsets.
- At each step, include or exclude the current element.
- Time Complexity: O(2^n)
- Space Complexity: O(2^n * n)

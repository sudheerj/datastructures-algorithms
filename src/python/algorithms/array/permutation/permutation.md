## Permutation

Given an array of distinct integers, return all possible permutations.

### Examples

**Example 1**
Input: [1, 2, 3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

**Example 2 (Two elements)**
Input: [0, 1]
Output: [[0,1],[1,0]]

**Example 3 (Single element)**
Input: [1]
Output: [[1]]

**Example 4 (Empty array)**
Input: []
Output: [[]]

**Example 5 (Negative numbers)**
Input: [-1, 2]
Output: [[-1,2],[2,-1]]

### Approach
- Use backtracking to generate all permutations.
- For each position, try every unused number.

### Complexity
- Time: O(n! * n)
- Space: O(n! * n)

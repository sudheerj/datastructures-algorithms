**Description:**
Given an array of integers, partition the array into two subsets such that the absolute difference of their sums is minimized. Return the minimal absolute sum.

### Examples
Example 1:

Input: numbers = [1, 5, 2, -2]
Output: 0

Example 2:

Input: numbers = [3, 1, 4, 2, 2]
Output: 0

Example 3:

Input: numbers = [1, 2, 3, 9]
Output: 3

**Algorithmic Steps**
This problem is solved using dynamic programming (subset sum):

1. Calculate the total sum of the array.
2. Use a boolean DP array to track possible subset sums up to half the total sum.
3. For each number, update the DP array for all possible sums.
4. Find the largest subset sum not exceeding half the total sum.
5. The minimal absolute sum is the difference between the total sum and twice this subset sum.

**Time and Space complexity:**
- Time complexity: `O(n * S)`, where `n` is the number of elements and `S` is half the total sum.
- Space complexity: `O(S)`. 
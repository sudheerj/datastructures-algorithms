**Description:**
Given an integer `n`, return the least number of perfect square numbers that sum to `n`.

A **perfect square** is an integer that is the square of an integer. In other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

**Note:** You can use each perfect square number unlimited times.

## Examples:
Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4

Example 2: 

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9

Example 3:

Input: n = 7
Output: 4
Explanation: 7 = 4 + 1 + 1 + 1

**Algorithmic Steps**
This problem is solved efficiently using **dynamic programming** approach (similar to coin change problem) by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Initialize a DP array to hold the minimum number of perfect squares needed for each value from `0` to `n`. By default, each value is assigned with a large value `n` (worst case: all 1s).
   
2. Set `dp[0] = 0` since zero requires zero perfect squares.
   
3. Iterate through each target value from `1` to `n` to find the minimum perfect squares required.

4. For each target value, iterate through all perfect squares (s² where s starts from 1) that are less than or equal to the target.

5. For each valid perfect square s², calculate the minimum as: `dp[target] = min(dp[target], 1 + dp[target - s²])`. This represents using one perfect square s² plus the minimum squares needed for the remaining value.
   
6. Repeat steps 4-5 until all perfect squares are checked for the current target.

7. Continue steps 3-6 until the minimum number of squares is calculated for all values up to `n`.

8. Return `dp[n]` which indicates the minimum number of perfect squares required to sum to `n`.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n * √n)`, where `n` is the input number and `√n` represents the number of perfect squares we check for each target value. This is because for each value up to n, we iterate through all perfect squares up to that value.

Here, we use a DP array to store the minimum count for each value from 0 to n. Hence, the space complexity is `O(n)`.

## Related Topics
- Dynamic Programming
- Coin Change Problem
- Mathematical Optimization

## Implementation
- [Java Implementation](./PerfectSquares.java)
- [Python Implementation](../../../../python/algorithms/dynamicProgramming/perfectSquares/perfect_squares.py)
- [JavaScript Implementation](../../../../javascript/algorithms/dynamicProgramming/perfectSquares/perfectSquares.js)

**Description:**
Given an array of integers representing squares on a board, a player starts at the first square and can move 1 to 6 steps forward with each dice roll. Find the maximal sum the player can collect to reach the last square.

### Examples
Example 1:

Input: numbers = [1, -2, 0, 9, -1, -2]
Output: 8

**Algorithmic Steps**
This problem is solved using dynamic programming:

1. Initialize a DP array where dp[i] is the maximal sum to reach square i.
2. Set dp[0] to numbers[0].
3. For each square i from 1 to n-1:
   - For each dice roll j from 1 to 6:
     - If i-j >= 0, update dp[i] as the maximum of its current value and dp[i-j] + numbers[i].
4. Return dp[n-1] as the maximal sum to reach the last square.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of squares.
- Space complexity: `O(n)`. 
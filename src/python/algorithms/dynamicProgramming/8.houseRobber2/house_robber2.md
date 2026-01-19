**Description:**
Given an integer array `nums` representing the amount of money stashed at each house arranged in a circle, return the maximum amount of money you can rob tonight without alerting the police (i.e., you cannot rob two adjacent houses, and the first and last houses are also adjacent).

**Edge Cases:**
- Empty array: should return 0.
- Single house: should return the value of that house.
- Two houses: should return the max of the two.
- All houses have 0 money.

## Examples

**Example 1:**
```
Input: nums = [1, 5, 7, 2, 4]
Output: 11
Explanation: Rob houses 2 and 4 (5 + 4 = 9) or houses 1, 3, and 5 (1 + 7 + 4 = 12), but since 1 and 5 are adjacent, you can't take both. The optimal is 11.
```

**Example 2:**
```
Input: nums = [1, 2, 3]
Output: 3
Explanation: Rob house 3.
```

**Example 3 (Edge):**
```
Input: nums = [3]
Output: 3
```

**Example 4 (Edge):**
```
Input: nums = [2, 3, 2]
Output: 3
```

## Algorithm steps
This problem is solved using a variation of the House Robber I approach. This problem can also be solved efficiently using **Fibonacci pattern bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems.

1. If `nums` is empty, return 0. If it has one element, return that element. If it has two, return the max of the two.
2. Since the first and last houses are adjacent, you cannot rob both. So, compute the max of:
    - Robbing houses from index 0 to n-2 (exclude last house)
    - Robbing houses from index 1 to n-1 (exclude first house)
3. Use the House Robber I algorithm for each subarray.
4. Return the maximum of the two results.

**Time Complexity:** `O(n)` - This algorithm has a time complexity of `O(n)` (i.e, `O(2n) ~ O(n)`), where `n` is the number of houses with money stashed. This is because we need to traverse over two subarray sequence of houses to find the maximum money.
**Space Complexity:** `O(1)` - We are not using any additional datastructure other than two variables to store money. Hence, the space complexity will be `O(1)`.

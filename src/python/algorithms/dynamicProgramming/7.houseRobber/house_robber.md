**Description:**

Given an integer array `nums` representing the amount of money stashed at each house, return the maximum amount of money you can rob tonight without alerting the police (i.e., you cannot rob two adjacent houses).

**Edge Cases:**
- Empty array: should return 0.
- Single house: should return the value of that house.
- All houses have 0 money.

## Examples

**Example 1:**
```
Input: nums = [1, 5, 7, 2, 4]
Output: 12
Explanation: Rob houses 1, 3, and 5 (1 + 7 + 4 = 12).
```

**Example 2:**
```
Input: nums = [8, 1, 2, 9]
Output: 17
Explanation: Rob houses 1 and 4 (8 + 9 = 17).
```

**Example 3 (Edge):**
```
Input: nums = []
Output: 0
```

**Example 4 (Edge):**
```
Input: nums = [0, 0, 0]
Output: 0
```

## Algorithm steps
This problem is solved using **Fibonacci pattern bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems.

1. If `nums` is empty, return 0. If it has one element, return that element.
2. Use two variables (`rob1`, `rob2`) to keep track of the max money robbed up to the previous two houses.
3. For each house, calculate the max of (current house + `rob1`) and `rob2`.
4. Update `rob1` and `rob2` as you iterate.
5. Return the final value of `rob2`.

**Time Complexity:** This algorithm has a time complexity of `O(n)`, where `n` is the number of houses with money stashed. This is because we need to traverse over each house to find the maximum money.
**Space Complexity:** We are not using any additional data structure other than two variables to store money. Hence, the space complexity will be `O(1)`.

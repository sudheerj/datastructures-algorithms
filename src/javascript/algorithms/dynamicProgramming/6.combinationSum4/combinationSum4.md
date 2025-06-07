**Description:**
Given an array of unique positive integers `nums` and a target integer `target`, return the number of possible combinations that add up to `target`. You may use the same number from `nums` as many times as needed. The order of numbers in the combination matters (i.e., [1,2] and [2,1] are different combinations).

**Note:** Same element from `nums` can be used multiple times if required. Also, the different elements order considered as a different combination.

## Examples

**Example 1:**
```
Input: nums = [1, 2, 4], target = 5
Output: 10
Explanation: All possible ordered combinations are:
[1,1,1,1,1], [1,1,1,2], [1,1,2,1], [1,2,1,1], [2,1,1,1], [1,4], [4,1], [2,2,1], [2,1,2], [1,2,2]
```

**Example 2:**
```
Input: nums = [7], target = 6
Output: 0
Explanation: No combination can sum to 6.
```

**Example 3 (Edge):**
```
Input: nums = [], target = 5
Output: 0
```

**Example 4 (Edge):**
```
Input: nums = [1, 2], target = 0
Output: 1
Explanation: Only the empty combination.
```

## Algorithm (Dynamic Programming)
This problem is solved using bottom-up dynamic programming approach by avoiding the recomputations of same subproblems.

1. Create an array `dp` of size `target + 1`, where `dp[i]` is the number of combinations that sum to `i`. Initialize `dp[0] = 1` (one way to make 0: use nothing).
2. For each sub-target `i` from 1 to `target`:
    - For each number `num` in `nums`:
        - If `i >= num`, add `dp[i - num]` to `dp[i]`.
3. Return `dp[target]`.

**Time Complexity:** `O(n * target)` where `n` is the number of elements in `nums` and `target` is the number for which combinations needs to be calculated. This is because we need to traverse each sub-target and find the possible combinations for each element of given array.
**Space Complexity:** `O(target)`. We will use an array datastructure to store possible combinations for each sub-target. Hence, the space complexity will be `O(target)`.

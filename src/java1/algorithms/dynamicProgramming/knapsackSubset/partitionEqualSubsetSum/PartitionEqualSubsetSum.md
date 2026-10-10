# Partition Equal Subset Sum

## Problem statement

Given an integer array `nums`, determine whether it can be divided into two subsets whose elements have equal sums. Each array element may be used in at most one subset.

## Examples

### Example 1

Input: `nums = [1,5,11,5]`

Output: `true`

Explanation: `[1,5,5]` and `[11]` both sum to `11`.

### Example 2

Input: `nums = [1,2,3,5]`

Output: `false`

Explanation: The total sum is odd, so it cannot be split into two equal integer sums.

### Example 3

Input: `nums = [2,2,1,1]`

Output: `true`

Explanation: `[2,1]` and `[2,1]` both sum to `3`.

## Algorithm: 0/1 knapsack subset sum

1. Sum all elements. If the total is odd, return `false`.
2. Set the target to half of the total sum. The question becomes whether a subset sums to this target.
3. Create a boolean DP array where `dp[s]` means a subset with sum `s` can be formed. Initialize `dp[0] = true`.
4. For each number, update sums from the target down to that number. Iterating downward ensures each number is used at most once.
5. Return `dp[target]`.

**Time complexity:** `O(n * target)`.

**Space complexity:** `O(target)`.

## Java implementation

[PartitionEqualSubsetSum.java](./PartitionEqualSubsetSum.java)
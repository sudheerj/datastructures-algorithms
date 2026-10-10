# Delete and Earn

## Problem statement

Given an integer array `nums`, choose a number and earn points equal to its value for every occurrence. After choosing a number `x`, every occurrence of `x - 1` and `x + 1` is removed and cannot be chosen. Return the maximum points that can be earned.

## Examples

### Example 1

Input: `nums = [3,4,2]`

Output: `6`

Explanation: Take `4` to earn `4`, then take `2` to earn `2`. The values `3` are removed after either choice.

### Example 2

Input: `nums = [2,2,3,3,3,4]`

Output: `9`

Explanation: Taking all three `3`s earns `9`; taking `2` and `4` is not allowed alongside `3`.

### Example 3

Input: `nums = [1]`

Output: `1`

## Algorithm: frequency aggregation and take/skip DP

1. Aggregate each value's total points in `points[value] = value * frequency(value)`.
2. Treat each possible value as a position in a linear take-or-skip problem. Taking value `i` prevents taking adjacent value `i - 1`; skipping it keeps the previous best score.
3. Maintain two rolling DP values: the best score before the current value and the best score through the previous value.
4. For each `i`, compute `max(points[i] + earn1, earn2)`, then shift the rolling values forward.

**Time complexity:** `O(n + max(nums))`.

**Space complexity:** `O(max(nums))` for the points array.

## Java implementation

[DeleteAndEarn.java](./DeleteAndEarn.java)
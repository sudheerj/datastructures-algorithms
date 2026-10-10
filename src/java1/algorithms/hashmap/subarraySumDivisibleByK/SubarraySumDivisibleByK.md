# Subarray Sum Divisible by K

## Problem statement

Given an integer array `nums` and a positive integer `k`, return the number of non-empty contiguous subarrays whose sum is divisible by `k`.

## Examples

### Example 1

Input: `nums = [4,5,0,-2,-3,1]`, `k = 5`

Output: `7`

Explanation: The seven subarrays are `[5]`, `[5,0]`, `[5,0,-2,-3]`, `[0]`, `[0,-2,-3]`, `[-2,-3]`, and `[4,5,0,-2,-3,1]`.

### Example 2

Input: `nums = [5]`, `k = 9`

Output: `0`

### Example 3

Input: `nums = [-1,2,9]`, `k = 2`

Output: `2`

Explanation: `[2]` and `[-1,2,9]` each have a sum divisible by `2`.

## Algorithm: prefix sums and remainder frequencies

For two prefix sums to delimit a subarray divisible by `k`, their remainders modulo `k` must be equal. Keep a frequency map of remainders seen so far:

1. Initialize the map with remainder `0` occurring once, to account for subarrays beginning at index `0`.
2. Accumulate a running prefix sum and compute its normalized remainder. If the remainder is negative, add `k` so it falls in `[0, k - 1]`.
3. Every earlier prefix with the same remainder forms a divisible-sum subarray ending at the current index. Add that remainder's frequency to the answer.
4. Increment the frequency of the current remainder and continue.

**Time complexity:** `O(n)`.

**Space complexity:** `O(n)` in the worst case for stored remainders.

## Java implementation

[SubarraySumDivisibleByK.java](./SubarraySumDivisibleByK.java)
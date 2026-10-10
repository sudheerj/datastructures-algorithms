# Maximum Non-Decreasing Subarray From Two Arrays

## Problem statement

Given two integer arrays `nums1` and `nums2` of equal length, construct a new array by choosing, at each index, either `nums1[i]` or `nums2[i]`. Return the maximum length of a contiguous non-decreasing subarray that can be obtained from those choices.

## Examples

### Example 1

Input: `nums1 = [2,3,1]`, `nums2 = [1,2,1]`

Output: `2`

Explanation: One valid choice gives `[1,2]`, a non-decreasing subarray of length `2`.

### Example 2

Input: `nums1 = [1,3,2,1]`, `nums2 = [2,2,3,4]`

Output: `4`

Explanation: Choose `[1,2,3,4]` by selecting values from the input arrays at each index.

### Example 3

Input: `nums1 = [1,1]`, `nums2 = [2,2]`

Output: `2`

Explanation: Choosing both values from `nums1` produces `[1,1]`, which is non-decreasing.

## Algorithm: two-state dynamic programming

At each index, keep two DP states:

- `dp1`: longest non-decreasing subarray ending at this index when choosing `nums1[i]`.
- `dp2`: longest non-decreasing subarray ending at this index when choosing `nums2[i]`.

For each next index, initialize both new states to `1`. Extend a prior state when the selected current value is greater than or equal to the prior selected value. Track the largest state seen. Store only the previous pair of states, so the DP uses constant extra space.

**Time complexity:** `O(n)`.

**Space complexity:** `O(1)`.

## Java implementation

[MaxNonDecreasingSubarrayFromTwoArrays.java](./MaxNonDecreasingSubarrayFromTwoArrays.java)
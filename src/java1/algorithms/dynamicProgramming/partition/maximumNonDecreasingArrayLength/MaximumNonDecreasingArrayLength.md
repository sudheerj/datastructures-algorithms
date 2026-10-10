# Maximum Non-Decreasing Array Length

## Problem statement

Given an integer array `nums`, split it into one or more non-empty contiguous subarrays. Replace each subarray with its sum, preserving the order of the subarrays. Return the maximum possible number of subarrays such that their sums form a non-decreasing array. This implementation assumes all input values are positive.

### Examples

Example 1:

Input: `nums = [5, 2, 2]`
Output: `1`
Explanation: No split into multiple subarrays produces non-decreasing sums, so the whole array is one subarray.

Example 2:

Input: `nums = [1, 2, 3, 4]`
Output: `4`
Explanation: Each element can be its own subarray, producing sums `[1, 2, 3, 4]`.

Example 3:

Input: `nums = [4, 3, 2, 6]`
Output: `3`
Explanation: Split into `[4]`, `[3, 2]`, and `[6]`, producing sums `[4, 5, 6]`.

Example 4:

Input: `nums = [1, 1, 1]`
Output: `2`
Explanation: Split into `[1]` and `[1, 1]`, producing sums `[1, 2]`.

Example 5:

Input: `nums = [1, 2, 3, 4, 5]`
Output: `5`
Explanation: Each value can be its own subarray because the singleton sums are already non-decreasing.

**Algorithmic Steps**
The solution uses prefix sums, dynamic programming, and binary search. Let `prefix[i]` be the sum of the first `i` elements. The DP state `dp[i]` stores the maximum number of non-decreasing-sum subarrays covering the first `i` elements. The `best` array carries forward the furthest valid previous boundary that can be used before the current endpoint.

1. Build prefix sums so the sum of any subarray `[j, i)` can be computed as `prefix[i] - prefix[j]`.
2. Process each prefix endpoint `i` from left to right, carrying forward the best previous boundary.
3. Set `dp[i]` to one more than the best number of groups ending at the selected previous boundary.
4. To ensure the next subarray sum is at least the current subarray sum, find the first prefix sum at least `2 * prefix[i] - prefix[j]` using binary search. Positive values make prefix sums sorted, which is required by binary search.
5. Record endpoint `i` as a usable boundary from that point onward, then return `dp[n]`.

**Time and Space complexity:**
The time complexity is `O(n log n)`: each of the `n` prefix endpoints performs a binary search.

The space complexity is `O(n)` for the prefix sum and dynamic programming arrays.

**Java Implementation:** [MaximumNonDecreasingArrayLength.java](./MaximumNonDecreasingArrayLength.java)

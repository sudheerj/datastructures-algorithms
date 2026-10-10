# Maximum Index-Weighted Sum

## Problem statement

Given an integer array `nums`, maximize the weighted score `sum(i * nums[i])` using any number of pairwise swaps, with each index participating in at most one swap. In other words, swaps must be disjoint; an index cannot be swapped more than once.

## Examples

### Example 1

Input: `nums = [3,1,2]`

Output: `7`

Explanation: The original score is `0*3 + 1*1 + 2*2 = 5`. Swapping indices `0` and `1` gives `[1,3,2]`, whose score is `0*1 + 1*3 + 2*2 = 7`.

### Example 2

Input: `nums = [4,1,3,2]`

Output: `17`

Explanation: Swap indices `0` and `1`, and swap indices `2` and `3`. The resulting array `[1,4,2,3]` has score `0 + 4 + 4 + 9 = 17`.

### Example 3

Input: `nums = [5,5,5]`

Output: `15`

Explanation: Swapping equal values does not change the score.

## Algorithm: bitmask dynamic programming

The initial score is computed directly. The DFS then finds the maximum additional gain from disjoint swaps.

1. Represent indices already fixed or used in a swap with a bitmask. `dp[mask]` stores the maximum additional gain possible from that state.
2. Find the first unused index `i`. It must either remain in place, or be swapped with an unused index `j > i`.
3. If `i` and `j` are swapped, the change in score is `(j - i) * (nums[i] - nums[j])`.
4. Mark the chosen index or pair as processed, recurse, and take the best gain.
5. Add the maximum gain to the original score.

Choosing the first unused index at every state ensures each set of disjoint swaps is considered without permuting the order in which pairs are processed.

**Time complexity:** `O(n * 2^n)` in the stated bound; the number of transitions can be as high as `O(n^2 * 2^n)` in the straightforward worst-case analysis.

**Space complexity:** `O(2^n)` for memoization, plus `O(n)` recursion depth.

## Java implementation

[MaximumIndexWeightedSum.java](./MaximumIndexWeightedSum.java)
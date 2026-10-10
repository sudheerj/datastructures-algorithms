# Min Max Riddle

## Problem statement

Given an array of positive integers, consider every contiguous window size from `1` to `n`. For each size, find the minimum value in every window of that size, then return the maximum among those minimum values.

## Examples

### Example 1

Input: `arr = [6,3,5,1,12]`

Output: `[12,3,3,1,1]`

Explanation: For window sizes `1` through `5`, the maximum of the window minimums is respectively `12`, `3`, `3`, `1`, and `1`.

### Example 2

Input: `arr = [1,2,3,5,1,13,3]`

Output: `[13,3,2,1,1,1,1]`

### Example 3

Input: `arr = [2,2,2]`

Output: `[2,2,2]`

## Algorithm: monotonic stack

For each element, find the nearest strictly smaller element to its left and right. These indices determine the largest window in which the current element is the minimum.

1. Use a monotonic increasing stack to compute the nearest smaller index on each side of every element. Pop values greater than or equal to the current value so duplicates are handled consistently.
2. For index `i`, compute the maximum window size where `nums[i]` is the minimum: `right[i] - left[i] - 1`.
3. Store `nums[i]` as a candidate answer for that window size.
4. Fill missing window sizes by propagating the best answer from larger windows to smaller ones.
5. Return the answers for sizes `1` through `n`.

**Time complexity:** `O(n)`, since each index is pushed and popped at most once per stack pass.

**Space complexity:** `O(n)` for the boundary arrays, stack, and result.

## Java implementation

[MinMaxRiddle.java](./MinMaxRiddle.java)
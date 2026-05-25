**Problem statement:** Given an integer array `nums`, move all `0`s to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

## Examples:

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: nums = [0]
Output: [0]
```

## Approach 1: Two Pointers (Swap)

**Algorithmic Steps**

1. Use a `left` pointer starting at 0 to track the next position for a non-zero element.
2. Iterate `right` from 0 to n-1.
3. Whenever `nums[right] != 0`, swap `nums[left]` and `nums[right]` (only if they differ in position), then increment `left`.
4. Non-zeros accumulate at the front in their original order; zeros are pushed to the end via swaps.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n) |
| Space | O(1) |

## Approach 2: Two Passes (Overwrite)

**Algorithmic Steps**

1. Use a `left` pointer starting at 0.
2. First pass: iterate through `nums`; whenever `nums[right] != 0`, write it to `nums[left]` and increment `left`.
3. Second pass: fill every position from `left` to the end of the array with `0`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n) |
| Space | O(1) |

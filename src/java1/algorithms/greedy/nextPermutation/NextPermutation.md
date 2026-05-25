# Next Permutation

**Problem statement:** Given an array of integers `nums`, rearrange it into the next lexicographically greater permutation. If no such permutation exists (the array is sorted in descending order), rearrange it to the lowest possible order (sorted ascending). The replacement must be done **in-place**.

## Examples:

```
Input: nums = [1,2,3]
Output: [1,3,2]

Input: nums = [3,2,1]
Output: [1,2,3]

Input: nums = [1,1,5]
Output: [1,5,1]
```

## Approach 1: Greedy + Array Manipulation

Find the rightmost element that is smaller than its right neighbor (the **pivot**). Swap it with the smallest element to its right that is still larger than it, then reverse the suffix to produce the smallest possible ordering in that suffix.

**Algorithmic Steps**

1. Scan from right to left to find index `i` where `nums[i] < nums[i+1]` (the pivot).
2. If a pivot exists, scan from right to find the first index `j` where `nums[j] > nums[i]`, then swap `nums[i]` and `nums[j]`.
3. Reverse the subarray from `i+1` to the end to convert the descending suffix into the smallest ascending order.
4. If no pivot exists (entire array descending), simply reverse the whole array.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(n) |
| Space | O(1) |

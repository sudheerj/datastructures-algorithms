**Problem statement:** Given an integer array `nums`, find three numbers whose product is maximum and return the maximum product.

### Examples

```
Input: nums = [-3, 1, 2, -2, 5, 6]
Output: 60  (2 * 5 * 6)

Input: nums = [-10, -10, 1, 3, 2]
Output: 300  (-10 * -10 * 3)

Input: nums = [1, 2, 3]
Output: 6
```

**Algorithmic Steps — Approach 1: Sorting**

1. Sort the array.
2. The answer is the maximum of:
   - Product of the three largest: `nums[n-3] * nums[n-2] * nums[n-1]`
   - Product of the two smallest (most negative) and the largest: `nums[0] * nums[1] * nums[n-1]`
3. Return the maximum.

**Algorithmic Steps — Approach 2: Greedy (single pass)**

1. Track the three largest values (`max1 ≥ max2 ≥ max3`) and two smallest values (`min1 ≤ min2`).
2. For each number, update the three maximums and two minimums accordingly.
3. Return `max(max1 * max2 * max3, min1 * min2 * max1)`.

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Sorting | O(n log n) | O(1) |
| Greedy | O(n) | O(1) |

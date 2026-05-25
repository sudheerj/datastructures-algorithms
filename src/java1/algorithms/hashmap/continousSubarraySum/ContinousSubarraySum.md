**Problem statement:** Given an integer array `nums` and an integer `k`, return `true` if `nums` has a **good subarray** or `false` otherwise. A good subarray is a subarray where its length is **at least two** and the sum of its elements is a **multiple of `k`**.

## Examples:

```
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2,4] is a subarray of length 2 and sums to 6, which is a multiple of 6.

Input: nums = [23,2,6,4,7], k = 13
Output: false
```

## Approach 1: Brute Force

**Algorithmic Steps**

1. For every pair of indices `(i, j)` where `j > i` (subarray length ≥ 2), compute the subarray sum.
2. If `sum % k == 0`, return `true`.
3. If no such pair is found, return `false`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n²) |
| Space | O(1) |

## Approach 2: Prefix Sum + HashMap

**Algorithmic Steps**

1. Use a hashmap `remainderMap` to store the first index at which each prefix-sum remainder (`prefixSum % k`) is seen. Seed it with `{0: -1}` to handle subarrays starting at index 0.
2. Iterate through `nums`, maintaining a running `total`. Compute `remainder = total % k`.
3. If `remainder` is not in the map, store `remainder → i`.
4. If `remainder` is already in the map and `i - map[remainder] > 1`, a subarray of length ≥ 2 with sum divisible by `k` exists — return `true`.
5. Return `false` if the loop completes without a match.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n) |
| Space | O(min(n, k)) |

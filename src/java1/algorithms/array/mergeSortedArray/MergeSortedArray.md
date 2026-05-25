**Problem statement:**
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n` representing the number of elements in `nums1` and `nums2` respectively. `nums1` has a total length of `m + n` (the last `n` slots are zeros). Merge `nums2` into `nums1` in-place so that the result is sorted in non-decreasing order.

## Examples:

```
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Input: nums1 = [4,5,6,0,0,0], m = 3, nums2 = [1,2,3], n = 3
Output: [1,2,3,4,5,6]

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
```

## Approach 1: Three Pointers from the Back

**Algorithmic Steps**
1. Initialize three pointers: `i = m - 1` (last real element in `nums1`), `j = n - 1` (last element in `nums2`), `k = m + n - 1` (last position in `nums1`).
2. While both `i ≥ 0` and `j ≥ 0`, compare `nums1[i]` and `nums2[j]`:
   - Place the larger value at `nums1[k]`, then decrement the corresponding pointer and `k`.
3. If any elements remain in `nums2` (i.e., `j ≥ 0`), copy them into `nums1` from position `k` downward.
4. No need to handle leftover elements in `nums1` — they are already in place.

**Time and Space complexity:**

| Complexity | Value    |
|------------|----------|
| Time       | O(m + n) |
| Space      | O(1)     |

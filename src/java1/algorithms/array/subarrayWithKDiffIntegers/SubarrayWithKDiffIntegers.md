**Problem statement:**
Given an integer array `nums` and an integer `k`, return the number of **good subarrays** of `nums`. A good subarray is a subarray where the number of **different** integers in it is exactly `k`.

## Examples:

```
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays with exactly 2 distinct integers:
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays with exactly 3 distinct integers:
[1,2,1,3], [2,1,3], [1,3,4]
```

## Approach 1: Brute Force (HashSet)

**Algorithmic Steps**
1. For each starting index `i`, create an empty `HashSet`.
2. Expand right pointer `j` from `i` to `n-1`, adding `nums[j]` to the set.
3. If the set size exceeds `k`, break — no longer valid.
4. If the set size equals `k`, increment the count.
5. Return the total count.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n²) |
| Space      | O(n)  |

---

## Approach 2: Sliding Window (Exactly K = At Most K − At Most K−1)

**Algorithmic Steps**
1. Observe that `count(exactly k) = count(at most k) − count(at most k−1)`.
2. Implement `atMostK(nums, k)` using a sliding window with a frequency map:
   - Expand `right`, add `nums[right]` to the frequency map.
   - While the map has more than `k` distinct keys, shrink from `left`: decrement `nums[left]`'s frequency; if it reaches `0`, remove the key; advance `left`.
   - Each valid window ending at `right` contributes `right − left + 1` subarrays.
3. Return `atMostK(nums, k) − atMostK(nums, k−1)`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(k)  |

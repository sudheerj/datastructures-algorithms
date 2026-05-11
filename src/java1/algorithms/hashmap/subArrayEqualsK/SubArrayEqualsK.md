# Subarray Sum Equals K

## Problem
Given an array of integers `nums` and an integer `k`, return the **total number of subarrays whose sum equals `k`**.

A subarray is a contiguous non-empty sequence of elements within an array.

LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/

---

## Approach

**Prefix Sum + HashMap — O(n) / O(n)**

Maintain a running `sum`. At each index, check if `sum - k` exists in a map of previously seen prefix sums. If it does, there are that many subarrays ending here that sum to `k`.

Seed the map with `{0: 1}` to handle subarrays that start from index 0 (i.e., when `sum == k`).

---

## Steps

1. Initialize `prefixSumMap = {0: 1}`, `sum = 0`, `count = 0`.
2. For each `num`:
   - `sum += num`
   - `count += prefixSumMap.getOrDefault(sum - k, 0)`
   - `prefixSumMap.put(sum, freq + 1)`
3. Return `count`.

---

## Example

```
nums = [1, 2, 3], k = 3

map = {0:1}, sum=0, count=0

num=1: sum=1, sum-k=-2 → not in map. map={0:1, 1:1}
num=2: sum=3, sum-k=0  → in map (1 time) → count=1. map={0:1, 1:1, 3:1}
num=3: sum=6, sum-k=3  → in map (1 time) → count=2. map={0:1, 1:1, 3:1, 6:1}

Answer: 2  → subarrays [1,2] and [3]
```

---

## Test Cases

| nums        | k | output | subarrays              |
|-------------|---|--------|------------------------|
| [1,1,1]     | 2 | 2      | [1,1],[1,1]            |
| [1,2,3]     | 3 | 2      | [1,2],[3]              |
| [3]         | 3 | 1      | [3]                    |
| [1,2,3]     | 6 | 1      | [1,2,3]                |
| [1,1,1]     | 1 | 3      | [1],[1],[1]            |
| [-1,-1,1]   | 0 | 1      | [-1,1] (indices 1-2)   |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Prefix Sum + HashMap | O(n) | O(n) |

# Subarray Sum Equals K

## Problem
Given an array of integers `nums` and an integer `k`, return the **total number of subarrays whose sum equals `k`**.

LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/

---

## Approach

**Prefix Sum + Dictionary — O(n) / O(n)**

Maintain a running `current_sum`. At each index, if `current_sum - k` was seen before, those many subarrays ending here sum to `k`.

Seed the dict with `{0: 1}` to handle subarrays starting from index 0.

---

## Steps

1. `prefix_sum_map = {0: 1}`, `total = 0`, `current_sum = 0`.
2. For each `num`: `current_sum += num`, `total += map.get(current_sum - k, 0)`, update map.
3. Return `total`.

---

## Example

```
nums = [1, 2, 3], k = 3

map={0:1}, sum=0

num=1: sum=1, sum-k=-2 → 0. map={0:1, 1:1}
num=2: sum=3, sum-k=0  → 1. total=1. map={0:1, 1:1, 3:1}
num=3: sum=6, sum-k=3  → 1. total=2. map={0:1, 1:1, 3:1, 6:1}

Answer: 2
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
| Prefix Sum + Dict | O(n) | O(n) |

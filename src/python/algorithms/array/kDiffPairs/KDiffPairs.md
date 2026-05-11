# K-diff Pairs in an Array

## Problem
Given an integer array `nums` and an integer `k`, return the number of **unique** k-diff pairs in the array.

A k-diff pair is an integer pair `(nums[i], nums[j])` where:
- `0 <= i < j < nums.length`
- `|nums[i] - nums[j]| == k`

LeetCode: https://leetcode.com/problems/k-diff-pairs-in-an-array/

---

## Approaches

### 1. HashSet — O(n) / O(n)

Two sets: `seen` and `pairs`. For each `num`, check if `num-k` or `num+k` is already seen.

### 2. Two Pointers (sorting) — O(n log n) / O(1)

Sort, then slide two pointers based on the difference.

---

## Steps (HashSet)

1. If `k < 0` return 0.
2. For each `num`:
   - `num-k in seen` → add `num-k` to `pairs`.
   - `num+k in seen` → add `num` to `pairs`.
   - Add `num` to `seen`.
3. Return `len(pairs)`.

---

## Example

```
nums = [3, 1, 4, 1, 5], k = 2

num=3: seen={}  → no match. seen={3}
num=1: 1+2=3 in seen → pairs={1}. seen={3,1}
num=4: no match. seen={3,1,4}
num=1: no new pair. seen={3,1,4}
num=5: 5-2=3 in seen → pairs={1,3}. seen={3,1,4,5}

Answer: 2  →  pairs (1,3) and (3,5)
```

---

## Test Cases

| nums                  | k   | output | notes                   |
| --------------------- | --- | ------ | ----------------------- |
| [3,1,4,1,5]           | 2   | 2      | (1,3),(3,5)             |
| [1,2,3,4,5]           | 1   | 4      | (1,2),(2,3),(3,4),(4,5) |
| [1,3,1,5,4]           | 0   | 1      | k=0 duplicate           |
| [1,1,1,1,1]           | 0   | 1      | all duplicates          |
| [1,2,4,4,3,3,0,9,2,3] | 3   | 2      | (0,3),(1,4)             |

---

## Complexity

| Approach     | Time       | Space |
| ------------ | ---------- | ----- |
| HashSet      | O(n)       | O(n)  |
| Two Pointers | O(n log n) | O(1)  |

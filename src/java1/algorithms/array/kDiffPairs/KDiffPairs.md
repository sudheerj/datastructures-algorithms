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

Use two sets: `seen` (all numbers visited so far) and `pairs` (smaller element of each valid pair).

For each `num`:
- If `num - k` is in `seen` → pair `(num-k, num)` found; add `num-k` to `pairs`.
- If `num + k` is in `seen` → pair `(num, num+k)` found; add `num` to `pairs`.
- Add `num` to `seen`.

Return `pairs.size()`.

### 2. Two Pointers (sorting) — O(n log n) / O(1)

Sort the array, then use two pointers `left` and `right` (both starting at 0/1).

- `diff > k` → advance `right`
- `diff < k` → advance `left`
- `diff == k` → count pair, advance both
- If `left == right`, advance `right` to keep pointers distinct.

---

## Steps (HashSet)

1. If `k < 0` return 0.
2. For each `num` in `nums`:
   - Check `num-k` in `seen` → add `num-k` to `pairs`.
   - Check `num+k` in `seen` → add `num` to `pairs`.
   - Add `num` to `seen`.
3. Return `pairs.size()`.

---

## Example

```
nums = [3, 1, 4, 1, 5], k = 2

num=3: seen={} → no match. seen={3}
num=1: 1-2=-1 not seen, 1+2=3 seen → pairs={1}. seen={3,1}
num=4: 4-2=2 not seen, 4+2=6 not seen. seen={3,1,4}
num=1: already in seen (dup), no new pair. seen={3,1,4}
num=5: 5-2=3 seen → pairs={1,3}. seen={3,1,4,5}

Answer: 2  → pairs (1,3) and (3,5)
```

---

## Test Cases

| nums                        | k | output | notes                        |
|-----------------------------|---|--------|------------------------------|
| [3,1,4,1,5]                 | 2 | 2      | (1,3), (3,5)                 |
| [1,2,3,4,5]                 | 1 | 4      | (1,2),(2,3),(3,4),(4,5)      |
| [1,3,1,5,4]                 | 0 | 1      | only (1,1) duplicate         |
| [1,1,1,1,1]                 | 0 | 1      | all duplicates, one pair     |
| [1,2,4,4,3,3,0,9,2,3]      | 3 | 2      | (0,3),(1,4)                  |

---

## Complexity

| Approach      | Time       | Space  |
|---------------|------------|--------|
| HashSet       | O(n)       | O(n)   |
| Two Pointers  | O(n log n) | O(1)   |

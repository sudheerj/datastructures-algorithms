# Maximum Gap

## Problem
Given an integer array `nums`, return the maximum difference between two successive elements in its sorted form. If the array contains fewer than two elements, return `0`.

You must write an algorithm that runs in **O(n)** time and uses **O(n)** extra space.

LeetCode: https://leetcode.com/problems/maximum-gap/

---

## Approach — Bucket Sort (Pigeonhole principle)

The key insight: if we distribute `n` elements across `n-1` buckets, at least one bucket must be empty. This means the maximum gap **cannot be within a single bucket** — it must cross a bucket boundary. So we only need to track each bucket's `min` and `max`.

Uses `Math.ceil`, `Infinity`, and `-Infinity` as empty markers.

**TC: O(n) — SC: O(n)**

---

## Steps

1. Handle edge cases: fewer than 2 elements → return 0; all elements equal → return 0.
2. Find global `minVal` and `maxVal`.
3. Compute `bucketSize = Math.ceil((maxVal - minVal) / (n - 1))`.
4. Compute `bucketCount = Math.floor((maxVal - minVal) / bucketSize) + 1`.
5. Place each element into its bucket (store only bucket `min` and `max`).
6. Scan buckets: `maxGap = Math.max(maxGap, currentBucketMin - previousBucketMax)`.
7. Return `maxGap`.

---

## Example

```
nums = [3, 6, 9, 1]

minVal=1, maxVal=9, n=4
bucketSize = Math.ceil(8/3) = 3
bucketCount = Math.floor(8/3) + 1 = 3

Buckets:
  bucket 0 → [1,3]:  min=1, max=3  (holds 1, 3)
  bucket 1 → [4,6]:  min=6, max=6  (holds 6)
  bucket 2 → [7,9]:  min=9, max=9  (holds 9)

Scan:
  bucket 0: 1 - 1(global min) = 0,  previousMax = 3
  bucket 1: 6 - 3 = 3,              previousMax = 6
  bucket 2: 9 - 6 = 3,              previousMax = 9

maxGap = 3 ✓
```

---

## Test Cases

| nums             | output  | notes                        |
|------------------|---------|------------------------------|
| [3, 6, 9, 1]     | 3       | LeetCode example 1           |
| [10]             | 0       | single element               |
| [1, 1, 1, 1]     | 0       | all elements equal           |
| [1, 10000000]    | 9999999 | two elements, large gap      |
| [1, 3, 6, 10]    | 4       | gap between 6 and 10         |
| [5, 1]           | 4       | two elements, unsorted input |

### Walkthrough — `[1, 3, 6, 10]`

```
minVal=1, maxVal=10, n=4
bucketSize = Math.ceil(9/3) = 3
bucketCount = Math.floor(9/3) + 1 = 4

Buckets:
  bucket 0 → [1,3]:   min=1,  max=3
  bucket 1 → [4,6]:   min=6,  max=6
  bucket 2 → [7,9]:   empty
  bucket 3 → [10,12]: min=10, max=10

Scan:
  bucket 0: 1 - 1 = 0,   previousMax = 3
  bucket 1: 6 - 3 = 3,   previousMax = 6
  bucket 2: skip (empty)
  bucket 3: 10 - 6 = 4,  previousMax = 10

maxGap = 4 ✓
```

---

## Complexity

| | Time | Space |
|-|------|-------|
| Bucket Sort | O(n) | O(n) |

> The pigeonhole principle guarantees the maximum gap crosses bucket boundaries, so intra-bucket comparisons are unnecessary.

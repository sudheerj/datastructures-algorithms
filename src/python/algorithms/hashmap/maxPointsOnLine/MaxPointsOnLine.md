# Max Points on a Line

## Problem
Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane, return the **maximum number of points** that lie on the same straight line.

LeetCode: https://leetcode.com/problems/max-points-on-a-line/

---

## Approach

For each **anchor point** `i`, iterate over all other points `j > i` and record the slope of the line through `i` and `j` in a dictionary.

Slope is stored as a **GCD-normalized tuple** `(dx, dy)` (reduced to lowest terms) rather than a float to avoid precision issues.

Duplicate points are tracked separately — they lie on every line through the anchor, so they are added to each candidate count.

**TC: O(n²) — SC: O(n)**

---

## Steps

1. If `n ≤ 2`, return `n`.
2. For each anchor `i`:
   - Reset `slope_map`, `duplicates = 0`, `local_max = 0`.
   - For each `j > i`:
     - Compute `dx`, `dy`.
     - If both zero: `duplicates += 1`, skip.
     - Reduce by `gcd(|dx|, |dy|)`.
     - Normalize sign: `dx ≥ 0`; if `dx == 0` then `dy > 0`.
     - Increment `slope_map[(dx, dy)]`, update `local_max`.
   - `result = max(result, local_max + duplicates + 1)`.
3. Return `result`.

---

## Example

```
Points: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]

Anchor (1,4):
  → (2,3): dx=1,dy=-1 → (1,-1) → count 1
  → (3,2): dx=2,dy=-2 → gcd=2 → (1,-1) → count 2
  → (4,1): dx=3,dy=-3 → gcd=3 → (1,-1) → count 3
  local_max = 3  →  result = 3+0+1 = 4  ✓

Answer: 4
```

---

## Test Cases

| input                                    | output | notes                    |
|------------------------------------------|--------|--------------------------|
| [[1,1],[2,2],[3,3]]                      | 3      | all collinear (slope 1)  |
| [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]    | 4      | diagonal anti-slope line |
| [[0,0]]                                  | 1      | single point             |
| [[0,0],[1,0],[2,0]]                      | 3      | horizontal line          |
| [[0,0],[0,1],[0,2]]                      | 3      | vertical line            |
| [[0,0],[0,0],[1,1]]                      | 3      | duplicate counts as +1   |

---

## Complexity

| | Time | Space |
|-|------|-------|
| Dict per anchor | O(n²) | O(n) |

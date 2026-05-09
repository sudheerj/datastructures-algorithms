# Max Points on a Line

## Problem
Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane, return the **maximum number of points** that lie on the same straight line.

LeetCode: https://leetcode.com/problems/max-points-on-a-line/

---

## Approach

For each **anchor point** `i`, iterate over all other points `j > i` and record the slope of the line through `i` and `j` in a HashMap.

Slope is stored as a **GCD-normalized fraction** `"dx/dy"` (integer pair reduced to lowest terms) rather than a floating-point number to avoid precision issues.

Duplicate points (same coordinates as anchor) are tracked separately — they can lie on any line through the anchor, so they are added to every candidate at the end.

**TC: O(n²) — SC: O(n)**

---

## Steps

1. If `n ≤ 2`, return `n` (any 2 points always form a line).
2. For each anchor `i`:
   - Reset `slopeMap`, `duplicates = 0`, `localMax = 0`.
   - For each `j > i`:
     - Compute `dx = x[j]-x[i]`, `dy = y[j]-y[i]`.
     - If `dx == 0 && dy == 0`: `duplicates++`, skip.
     - Divide both by `gcd(|dx|, |dy|)`.
     - Normalize sign: keep `dx ≥ 0`; if `dx == 0` keep `dy > 0`.
     - Key = `"dx/dy"`. Increment `slopeMap[key]`, update `localMax`.
   - Update `result = max(result, localMax + duplicates + 1)`.
3. Return `result`.

---

## Example

```
Points: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]

Anchor = (1,1):
  → (3,2): dx=2,dy=1  → key "2/1"  → count 1
  → (5,3): dx=4,dy=2  → gcd=2 → "2/1" → count 2
  → (4,1): dx=3,dy=0  → key "1/0"  → count 1
  → (2,3): dx=1,dy=2  → key "1/2"  → count 1
  → (1,4): dx=0,dy=3  → key "0/1"  → count 1
  localMax = 2  →  result = 2+0+1 = 3

Anchor = (1,4):
  → (2,3): dx=1,dy=-1 → key "1/-1" → count 1
  → (3,2): dx=2,dy=-2 → gcd=2 → "1/-1" → count 2
  → (4,1): dx=3,dy=-3 → gcd=3 → "1/-1" → count 3
  localMax = 3  →  result = 3+0+1 = 4  ✓

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
| Hashmap per anchor | O(n²) | O(n) |

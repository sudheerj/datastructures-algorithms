**Problem statement:** Given an array of points on a 2D plane, return the maximum area of an axis-aligned rectangle formed by any four of those points. Return `0` if no rectangle can be formed. (LeetCode 963 variant — axis-aligned)

## Examples:

```
points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
→ 4   // rectangle corners: (1,1),(1,3),(3,1),(3,3), area = 2×2 = 4

points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
→ 6   // best rectangle: (1,1),(1,3),(4,1),(4,3), area = 3×2 = 6

points = [[1,1],[2,2],[3,1],[1,3]]
→ 0   // no four points form an axis-aligned rectangle
```

**Algorithmic Steps:**

1. Store all points in a `HashSet` as `"x#y"` strings for O(1) lookup.
2. Iterate over all pairs of points `(i, j)` as potential diagonal corners.
3. Skip pairs that share the same x or same y (they can't be diagonal corners of a non-degenerate rectangle).
4. For pair `(x1,y1)` and `(x2,y2)`, check if the other two corners `(x1,y2)` and `(x2,y1)` exist in the set.
5. If both exist, compute `area = |x1-x2| × |y1-y2|` and update `maxArea`.
6. Return `maxArea` (0 if no rectangle found).

**Time and Space complexity:**

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| HashSet + pair enumeration | O(n²) | O(n) |

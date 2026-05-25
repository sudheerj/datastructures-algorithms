**Problem statement:**
Given an array of points where `points[i] = [xi, yi]` represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

## Examples:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

**Algorithmic Steps**
1. Initialize `maxPoints = 1` (a single point is always on a line).
2. For each point `i`, create a slope frequency map.
3. For each point `j > i`, compute the slope from point `i` to point `j`:
   - If `dx == 0`, slope is `POSITIVE_INFINITY` (vertical line).
   - Otherwise, slope = `(double)(dy) / dx`. Normalize `-0.0` to `0.0`.
4. Increment the slope count in the map.
5. Update `maxPoints = max(maxPoints, count[slope] + 1)` — adding 1 to include point `i` itself.
6. Return `maxPoints`.

**Time and Space complexity:**
| | Time | Space |
|---|---|---|
| Best | O(n²) | O(n) |
| Average | O(n²) | O(n) |
| Worst | O(n²) | O(n) |

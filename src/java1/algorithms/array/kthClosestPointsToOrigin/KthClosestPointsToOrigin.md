**Problem statement:** Given an array of points where `points[i] = [xi, yi]` represents a point on the X-Y plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`. The distance between two points is the Euclidean distance $\sqrt{x^2 + y^2}$. You may return the answer in any order.

## Examples:

```
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation: Distance of [1,3] is sqrt(10); distance of [-2,2] is sqrt(8). Since sqrt(8) < sqrt(10), [-2,2] is closer.

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
```

## Approach 1: Sorting

**Algorithmic Steps**

1. Sort all points by their squared distance ($x^2 + y^2$) in ascending order (no need for sqrt since it's monotonic).
2. Return the first `k` elements.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n log n) |
| Space | O(log n) |

## Approach 2: Max Heap of Size k

**Algorithmic Steps**

1. Maintain a max-heap ordered by squared distance (farthest point at the top), capped at size `k`.
2. For each point, push it onto the heap; if the heap exceeds size `k`, pop the farthest point.
3. The `k` points remaining in the heap are the closest.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n log k) |
| Space | O(k) |

## Approach 3: Min Heap

**Algorithmic Steps**

1. Push all `n` points into a min-heap ordered by squared distance (closest at the top).
2. Pop the top element `k` times to collect the `k` closest points.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n + k log n) |
| Space | O(n) |

## Approach 4: QuickSelect

**Algorithmic Steps**

1. Use Lomuto partition: choose `points[right]` as pivot; rearrange so all points with distance ≤ pivot are to the left.
2. If the pivot lands at index `k`, stop — `points[0..k-1]` are the k closest.
3. If pivot index < `k`, recurse on the right half; if pivot index > `k`, recurse on the left half.
4. Return `points[0..k-1]`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time  | O(n) avg, O(n²) worst |
| Space | O(log n) recursion stack |

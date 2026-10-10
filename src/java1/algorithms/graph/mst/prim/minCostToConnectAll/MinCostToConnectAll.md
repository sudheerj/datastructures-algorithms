**Problem statement:**

You are given an array `points` where `points[i] = [xi, yi]` represents a point on a 2D plane. The cost to connect two points is their Manhattan distance, `|xi - xj| + |yi - yj|`. Return the minimum total cost required to connect every point, where any two points may be connected directly or indirectly.

## Examples

**Example 1:**

```text
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: One minimum spanning tree uses edges with costs 4, 3, 4, and 9, totaling 20.
```

**Example 2:**

```text
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
Explanation: Connecting the first and second points costs 12, and connecting the second and third costs 6; total cost is 18.
```

**Example 3:**

```text
Input: points = [[1,1]]
Output: 0
Explanation: A single point requires no connections.
```

## Algorithmic steps (Prim's algorithm with a min-heap)

1. Start with point `0` in the growing minimum spanning tree (MST), using a heap entry `{cost = 0, point = 0}`.
2. Keep a `visited` array, the number of points added to the MST, and the accumulated MST cost.
3. Repeatedly remove the lowest-cost candidate edge from the min-heap.
4. If its point is already visited, skip the entry because a cheaper edge may already have connected it.
5. Otherwise, add the point to the MST and add the edge cost to the total.
6. For every unvisited point, calculate its Manhattan distance from the newly added point and add `{distance, point}` to the heap.
7. Continue until all points have been added. Return the accumulated cost.

## Key insight

Every pair of points can be connected, so the graph is complete. Prim's algorithm does not need to store all edges up front: whenever a point joins the MST, it adds the distances from that point to all points not yet included. The minimum heap selects the cheapest edge crossing from the current tree to an unvisited point.

## Complexity

Let `n` be the number of points.

- **Time:** `O(n² log n)` in this implementation. It considers up to `O(n²)` candidate edges, and heap operations take `O(log(n²)) = O(log n)`.
- **Space:** `O(n²)` in the worst case for candidate entries in the priority queue, plus `O(n)` for the visited array.

## Constraints

- `1 <= points.length <= 1000`
- `-10^6 <= xi, yi <= 10^6`
- All pairs of points are distinct.

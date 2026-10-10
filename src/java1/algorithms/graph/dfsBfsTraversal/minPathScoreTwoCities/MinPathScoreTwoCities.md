**Problem statement:**

You are given an undirected, weighted graph with `n` cities numbered from `1` to `n`. Each road is represented by `[cityA, cityB, distance]`. The **score** of a path is the minimum distance among all roads on that path. Return the minimum score of any path from city `1` to city `n`.

## Examples

**Example 1:**

```text
Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: A path from city 1 to city 4 can use roads 1-2 and 2-4. Its score is min(9, 5) = 5.
```

**Example 2:**

```text
Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
Output: 2
Explanation: The path 1-2-1-3-4 has a minimum road distance of 2.
```

## Algorithmic steps

Both implementations build an adjacency list and traverse the connected component containing city `1`. Because the roads are undirected, every road is stored for both endpoints.

1. Create an adjacency list for cities `1` through `n`.
2. For each road `[u, v, distance]`, add `(v, distance)` to `u`'s neighbors and `(u, distance)` to `v`'s neighbors.
3. Start a graph traversal from city `1`, using either DFS (`minScore`) or BFS (`minScore1`).
4. For every road encountered from a visited city, update the answer to the minimum distance seen so far.
5. Visit each neighboring city at most once, using a `visited` array to prevent repeated traversal.
6. Return the smallest road distance found.

## Key insight

The score is the minimum edge weight on a path. Since city `n` is reachable from city `1`, any road in the connected component of city `1` can be included in a walk from city `1` to city `n`: travel to that road, cross it, then continue to city `n`. Therefore, the answer is the smallest road distance in city `1`'s connected component. A shortest-path algorithm is not needed.

## Complexity

Let `n` be the number of cities and `m` the number of roads.

- **Time:** `O(n + m)` to build and traverse the adjacency list.
- **Space:** `O(n + m)` for the adjacency list, visited array, and traversal queue or recursion stack.

## Constraints

- `2 <= n <= 10^5`
- `1 <= roads.length <= 10^5`
- `roads[i].length == 3`
- `1 <= cityA, cityB <= n`
- `cityA != cityB`
- `1 <= distance <= 10^4`
- There is at least one path between city `1` and city `n`.

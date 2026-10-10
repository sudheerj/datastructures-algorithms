**Problem statement:**

You are given an undirected graph with `n` vertices numbered from `0` to `n - 1`, represented by an edge list `edges`, where `edges[i] = [u, v]` indicates an edge between vertices `u` and `v`. Given `source` and `destination`, return `true` if there is a path between them, and `false` otherwise.

## Examples

**Example 1:**

```text
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There is a path from vertex 0 to vertex 2.
```

**Example 2:**

```text
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: Vertices 0 and 5 are in different connected components.
```

## Algorithmic steps (DFS)

The graph is undirected, so each edge must be added to the adjacency list of both endpoints. Then Depth-First Search (DFS) explores the component containing `source`.

1. Create an adjacency list with one list for each of the `n` vertices.
2. For every edge `[u, v]`, add `v` to `u`'s neighbors and `u` to `v`'s neighbors.
3. Create a `visited` array and start DFS from `source`.
4. In DFS:
   - If the current vertex is `destination`, return `true`.
   - Mark the current vertex as visited.
   - Recursively search each unvisited neighbor. If any recursive call returns `true`, return `true`.
   - If no neighbor reaches the destination, return `false`.
5. Return the result of the DFS call.

## Key insight

The question is whether the source and destination belong to the same connected component. DFS visits all vertices reachable from the source; reaching the destination proves a path exists. The visited array prevents revisiting vertices, including in cyclic graphs. If `source == destination`, DFS immediately returns `true`.

## Complexity

- **Time:** `O(n + E)`, where `E` is the number of edges. Building the adjacency list and traversing the graph each take `O(n + E)` overall.
- **Space:** `O(n + E)` for the adjacency list, visited array, and DFS recursion stack.

## Constraints

- `1 <= n <= 2 * 10^5`
- `0 <= edges.length <= 2 * 10^5`
- `edges[i].length == 2`
- `0 <= u, v <= n - 1`
- `u != v`
- `0 <= source, destination <= n - 1`
- There are no duplicate edges.

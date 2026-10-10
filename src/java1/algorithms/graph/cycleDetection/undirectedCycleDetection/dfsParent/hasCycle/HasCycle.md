# Detect Cycle in an Undirected Graph Using DFS

## Problem statement

Given an undirected graph with `n` vertices, determine whether it contains a cycle. The graph is represented as an adjacency list.

## Examples

### Example 1: Cycle exists

Input: `n = 4`, edges = `[[0,1],[1,2],[2,3],[3,0]]`

Output: `true`

Explanation: The edges form the cycle `0 -> 1 -> 2 -> 3 -> 0`.

### Example 2: No cycle

Input: `n = 4`, edges = `[[0,1],[1,2],[2,3]]`

Output: `false`

Explanation: The graph is a path and contains no cycle.

### Example 3: Disconnected graph with a cycle

Input: `n = 5`, edges = `[[0,1],[1,2],[2,0],[3,4]]`

Output: `true`

Explanation: The component containing vertices `0`, `1`, and `2` has a cycle. The search must examine every connected component.

## Algorithm: DFS with parent tracking

1. Create a `visited` array to track explored vertices.
2. Iterate through every vertex, starting a DFS from each unvisited vertex so disconnected components are covered.
3. In DFS, mark the current vertex visited and inspect each adjacent vertex.
4. If a neighbor is unvisited, recurse while passing the current vertex as its parent.
5. If a neighbor is already visited and is not the parent, a cycle exists. The parent check ignores the undirected edge used to reach the current vertex.
6. If no component discovers a cycle, return `false`.

**Time complexity:** `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges.

**Space complexity:** `O(V)` for the visited array and DFS call stack.

## Java implementation

[HasCycle.java](./HasCycle.java)

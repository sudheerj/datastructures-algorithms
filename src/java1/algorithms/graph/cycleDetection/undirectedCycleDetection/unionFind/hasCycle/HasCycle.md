# Detect Cycle in an Undirected Graph Using Union-Find

## Problem statement

Given a simple undirected graph with `n` vertices and an edge list, determine whether the graph contains a cycle.

## Examples

### Example 1: Cycle exists

Input: `n = 4`, `edges = [[0,1],[1,2],[2,3],[3,0]]`

Output: `true`

Explanation: The edges form the cycle `0 -> 1 -> 2 -> 3 -> 0`.

### Example 2: No cycle

Input: `n = 4`, `edges = [[0,1],[1,2],[2,3]]`

Output: `false`

Explanation: These edges form a path, so no edge connects two vertices that are already in the same connected component.

### Example 3: Disconnected graph with a cycle

Input: `n = 5`, `edges = [[0,1],[1,2],[2,0],[3,4]]`

Output: `true`

Explanation: The component containing vertices `0`, `1`, and `2` contains a cycle.

## Algorithm: Disjoint Set Union (Union-Find)

1. Initialize each vertex as its own parent and set each rank to zero.
2. For every edge `(u, v)`, find the representative roots of both endpoints, using path compression to flatten parent chains.
3. If both endpoints already have the same root, they are connected by a path, so adding this edge closes a cycle. Return `true`.
4. Otherwise, union their components by rank, attaching the shallower tree under the deeper one.
5. If all edges are processed without finding a cycle, return `false`.

**Time complexity:** `O(E * α(V))`, where `α` is the inverse Ackermann function, which grows so slowly that it is effectively constant for practical input sizes.

**Space complexity:** `O(V)` for the parent and rank arrays.

## Java implementation

[HasCycle.java](./HasCycle.java)

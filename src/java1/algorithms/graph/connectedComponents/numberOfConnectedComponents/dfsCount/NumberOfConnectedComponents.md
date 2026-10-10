**Problem statement:**

Given an undirected graph with `n` nodes numbered from `0` to `n - 1` and an edge list `edges`, where `edges[i] = [a, b]` represents an edge between nodes `a` and `b`, return the number of connected components in the graph.

## Examples

**Example 1:**

```text
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Explanation: Nodes 0, 1, and 2 form one component; nodes 3 and 4 form another.
```

**Example 2:**

```text
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
Explanation: Every node is reachable from every other node.
```

## Algorithmic steps (DFS)

1. Build an adjacency list with one list for each node.
2. For each edge `[u, v]`, add `v` to `u`'s neighbors and `u` to `v`'s neighbors because the graph is undirected.
3. Create a `visited` array and initialize the component count to `0`.
4. Iterate through all nodes. Whenever a node is unvisited:
   - Increment the component count. This node is the start of a new connected component.
   - Run DFS from it to mark every node reachable within that component as visited.
5. Return the component count after all nodes have been checked.

## Key insight

A DFS traversal visits exactly the nodes in one connected component. Starting a DFS at each still-unvisited node therefore starts one new component, and the number of such DFS traversals is the answer. This also correctly counts isolated nodes as components.

## Complexity

Let `V` be the number of nodes and `E` the number of edges.

- **Time:** `O(V + E)` to build the adjacency list and visit every node and edge.
- **Space:** `O(V + E)` for the adjacency list, visited array, and DFS recursion stack.

## Constraints

- `1 <= n <= 2000`
- `1 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= a <= b < n`
- `a != b`
- There are no duplicate edges.

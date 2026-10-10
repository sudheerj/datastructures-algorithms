**Problem statement:**

Given an undirected graph with `n` nodes numbered from `0` to `n - 1` and an edge list `edges`, where `edges[i] = [a, b]` represents an edge between nodes `a` and `b`, return the number of connected components in the graph.

## Examples

**Example 1:**

```text
Input: n = 6, edges = [[0,1],[1,2],[2,3],[4,5]]
Output: 2
Explanation: Nodes 0, 1, 2, and 3 form one component; nodes 4 and 5 form another.
```

**Example 2:**

```text
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Explanation: Nodes 0, 1, and 2 form one component; nodes 3 and 4 form another.
```

## Algorithmic steps (Union-Find by rank)

1. Initialize a `parent` array so each node is its own parent. Initialize each node's `rank` to `1`.
2. Set the component count to `n`, since initially each node is an isolated component.
3. For each edge `[u, v]`, call `union(u, v)`:
   - Find the root representative of each endpoint, using `find` with path compression.
   - If both roots are the same, the nodes are already connected, so do not change the count.
   - Otherwise, link the root with smaller rank under the root with larger rank. If their ranks are equal, link one root under the other and increment the new root's rank.
   - Return `true` when the roots were merged; decrement the component count for each successful merge.
4. Return the remaining component count.

## Key insights

- **Path compression:** `find` recursively updates each visited node's parent to its root, making later lookups faster.
- **Union by rank:** Attach the shallower tree under the deeper tree. Rank increases only when two roots of equal rank are merged.
- An edge joining nodes already in the same set does not reduce the number of components.

## Complexity

Let `V` be the number of nodes and `E` the number of edges.

- **Time:** `O(V + E * α(V))`, including initialization, where `α` is the inverse Ackermann function and grows extremely slowly.
- **Space:** `O(V)` for the `parent` and `rank` arrays.

## Constraints

- `1 <= n <= 2000`
- `1 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= a <= b < n`
- `a != b`
- There are no duplicate edges.

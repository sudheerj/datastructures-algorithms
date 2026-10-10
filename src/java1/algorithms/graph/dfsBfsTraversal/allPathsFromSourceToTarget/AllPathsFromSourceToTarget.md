**Problem statement:**

You are given a directed acyclic graph (DAG) with `n` nodes labeled from `0` to `n - 1`. The graph is represented as an adjacency list, where `graph[i]` contains the nodes that can be reached directly from node `i`. Return all possible paths from node `0` to node `n - 1`.

## Examples

**Example 1:**

```text
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths from node 0 to node 3.
```

**Example 2:**

```text
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
```

## Algorithmic steps (DFS with backtracking)

1. Create a `result` list to store completed paths and a `path` list initialized with the source node `0`.
2. Run DFS from node `0`, carrying the current path.
3. If the current node is the target (`n - 1`), add a copy of the current path to `result` and return. Copying is important because the working path will continue to be modified during backtracking.
4. Otherwise, for each neighbor of the current node:
   - Add the neighbor to the current path.
   - Recursively search from that neighbor.
   - Remove the neighbor from the path after returning, restoring the path for the next branch.
5. Return all paths collected in `result`.

## Key insight

The input is a DAG, so DFS cannot enter a cycle. Backtracking lets the search explore every branch while reusing one working path; a node is removed from that path when its branch has been fully explored. Each time DFS reaches the target, it records one distinct source-to-target path.

## Complexity

Let `V` be the number of nodes and `P` the number of paths returned.

- **Time:** `O(2^V * V)` in the worst case. A DAG can have exponentially many paths to explore, and copying each completed path takes up to `O(V)` time.
- **Space:** `O(P * V)` for the returned paths, plus `O(V)` auxiliary space for the current path and recursion stack.

## Constraints

- `2 <= graph.length <= 15`
- `0 <= graph[i].length <= graph.length - 1`
- `0 <= graph[i][j] < graph.length`
- `graph[i][j] != i`
- The graph contains no cycles.

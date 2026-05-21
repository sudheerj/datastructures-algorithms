**Problem statement:**
Given a directed graph with `V` vertices and an adjacency list `adj`, determine whether the graph contains a **cycle**. Return `true` if a cycle exists, otherwise return `false`.

## Examples:
Input: V = 3, adj = [[1], [2], [0]]
Output: true
(0 → 1 → 2 → 0 forms a cycle)

Input: V = 4, adj = [[1], [2], [3], []]
Output: false
(Linear DAG, no cycle)

**Algorithmic Steps**
This problem is solved using **Recursive DFS** with two boolean arrays — `visited` and `pathVisited` — to detect back edges (which indicate cycles in a directed graph). The algorithmic approach can be summarized as follows:

1. Create the main function `isCycle(V, adj)` that accepts the number of vertices `V` and the adjacency list `adj`.

2. Initialize two boolean arrays of size `V`:
   - `visited` — tracks whether a node has ever been visited.
   - `pathVisited` — tracks whether a node is on the **current DFS recursion path**.

3. Iterate over all vertices `0` to `V-1`. For each unvisited vertex, call `dfs(node, adj, visited, pathVisited)`. If it returns `true`, immediately return `true` (cycle found).

4. In the `dfs` function:
   1. Mark `visited[node] = true` and `pathVisited[node] = true`.
   2. For each `neighbour` in `adj[node]`:
      - If `neighbour` is not yet visited, recursively call `dfs(neighbour, ...)`. Return `true` if cycle found.
      - If `pathVisited[neighbour]` is `true`, a back edge is found — return `true` (cycle detected).
   3. After processing all neighbours, set `pathVisited[node] = false` (backtrack).
   4. Return `false`.

5. If no cycle is found after checking all components, return `false`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges, since each node and edge is visited once.

The space complexity is `O(V)` for the `visited` and `pathVisited` arrays, plus `O(V)` for the DFS recursion stack in the worst case.

**Problem statement:**
Given a directed graph with `V` vertices and an adjacency list `adj`, determine whether the graph contains a **cycle**. Return `True` if a cycle exists, otherwise return `False`.

## Examples:
Input: V = 3, adj = [[1], [2], [0]]
Output: True
(0 → 1 → 2 → 0 forms a cycle)

Input: V = 4, adj = [[1], [2], [3], []]
Output: False
(Linear DAG, no cycle)

**Algorithmic Steps**
This problem is solved using **Recursive DFS** with two boolean lists — `visited` and `path_visited` — to detect back edges (which indicate cycles in a directed graph). The algorithmic approach can be summarized as follows:

1. Create the main function `is_cycle(V, adj)` that accepts the number of vertices `V` and the adjacency list `adj`.

2. Initialize two boolean lists of size `V`:
   - `visited` — tracks whether a node has ever been visited.
   - `path_visited` — tracks whether a node is on the **current DFS recursion path**.

3. Define an inner `dfs(node)` function using closure over `visited` and `path_visited`.

4. In the `dfs` function:
   1. Mark `visited[node] = True` and `path_visited[node] = True`.
   2. For each `neighbour` in `adj[node]`:
      - If `neighbour` is not yet visited, recursively call `dfs(neighbour)`. Return `True` if cycle found.
      - If `path_visited[neighbour]` is `True`, a back edge is found — return `True` (cycle detected).
   3. After processing all neighbours, set `path_visited[node] = False` (backtrack).
   4. Return `False`.

5. Iterate over all vertices. For each unvisited vertex, call `dfs(i)`. If it returns `True`, immediately return `True`.

6. If no cycle is found after checking all components, return `False`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges, since each node and edge is visited once.

The space complexity is `O(V)` for the `visited` and `path_visited` lists, plus `O(V)` for the DFS recursion stack in the worst case.

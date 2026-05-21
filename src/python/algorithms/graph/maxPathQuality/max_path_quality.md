**Problem statement:**
There is an undirected graph with `n` nodes numbered `0` to `n-1`. Each node has a value given by `values[i]`. You are given weighted edges `edges[i] = [u, v, time]`. Starting from node `0`, you can traverse any edge in either direction. A node's value is added to your score **only the first time** you visit it. Return the **maximum score** of any valid path that starts and ends at node `0` within `maxTime`.

## Examples:
Input: values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
Output: 75
(Path: 0→3→0→1→0, time = 10+10+10+10 = 40 ≤ 49, score = 0+43+32 = 75)

Input: values = [1,2,3,4], edges = [[0,1,5],[0,2,5],[0,3,5]], maxTime = 20
Output: 8
(Path: 0→2→0→3→0, time = 20, score = 1+3+4 = 8)

**Algorithmic Steps**
This problem is solved using **DFS + Backtracking** to explore all valid paths that start and end at node `0` within `maxTime`. The algorithmic approach can be summarized as follows:

1. Create the main function `max_path_quality(values, edges, max_time)`.

2. Build an undirected weighted adjacency list using `defaultdict(list)`. Each entry stores `(neighbour, travel_time)`.

3. Initialize a `visited_count` list of size `n` with zeros, and `max_score = [0]` (list for mutation inside closure).

4. Define an inner `dfs(node, time, score)` function.

5. In the `dfs` function:
   1. If `visited_count[node] == 0` (first visit), add `values[node]` to `score`.
   2. Increment `visited_count[node]`.
   3. If `node == 0`, update `max_score[0] = max(max_score[0], score)`.
   4. For each `(nei, cost)` in `graph[node]`: if `time + cost <= max_time`, recursively call `dfs(nei, time+cost, score)`.
   5. Decrement `visited_count[node]` (backtrack).

6. Call `dfs(0, 0, 0)` and return `max_score[0]`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(2^V)` in the worst case, as it explores all possible paths via backtracking, where `V` is the number of nodes. In practice it is bounded by `maxTime`.

The space complexity is `O(V + E)` for the graph, plus `O(V)` for the recursion stack and `visited_count` list.

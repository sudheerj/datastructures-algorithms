# Recursive DFS + visited & path_visited arrays => TC: O(V+E) SC: O(V)
def is_cycle(V, adj):
    visited = [False] * V
    path_visited = [False] * V

    def dfs(node):
        visited[node] = True
        path_visited[node] = True

        for neighbour in adj[node]:
            if not visited[neighbour]:
                if dfs(neighbour):
                    return True
            if path_visited[neighbour]:
                return True

        path_visited[node] = False
        return False

    for i in range(V):
        if not visited[i]:
            if dfs(i):
                return True
    return False


test_cases = [
    (3, [[1], [2], [0]], True),          # simple cycle 0->1->2->0
    (4, [[1], [2], [3], []], False),     # DAG, no cycle
    (2, [[1], [1]], True),               # self-loop
    (4, [[], [2], [3], [1]], True),      # disconnected, cycle in 1-2-3
    (1, [[]], False),                    # single node
]

for i, (V, adj, expected) in enumerate(test_cases, 1):
    result = is_cycle(V, adj)
    print(f"Test {i}: Result={result}, Expected={expected}")

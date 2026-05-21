from collections import defaultdict

# Max Path Quality of a Graph
# DFS + Backtracking  TC: O(2^V)  SC: O(V + E)
def max_path_quality(values, edges, max_time):
    n = len(values)

    # Build undirected weighted adjacency list
    graph = defaultdict(list)
    for u, v, t in edges:
        graph[u].append((v, t))
        graph[v].append((u, t))

    max_score = [0]
    visited_count = [0] * n

    def dfs(node, time, score):
        # Add value only on first visit
        if visited_count[node] == 0:
            score += values[node]
        visited_count[node] += 1

        # Update max_score whenever we return to node 0
        if node == 0:
            max_score[0] = max(max_score[0], score)

        for nei, cost in graph[node]:
            if time + cost <= max_time:
                dfs(nei, time + cost, score)

        # Backtrack
        visited_count[node] -= 1

    dfs(0, 0, 0)
    return max_score[0]


# Test 1: Classic example — best path is 0->3->0->1->0
print(max_path_quality(
    [0, 32, 10, 43],
    [[0,1,10],[1,2,15],[0,3,10]],
    49))  # Expected: 75

# Test 2: Star graph — visit two best-value leaves within max_time
print(max_path_quality(
    [1, 2, 3, 4],
    [[0,1,5],[0,2,5],[0,3,5]],
    20))  # Expected: 8 (node0+node2+node3 = 1+3+4)

# Test 3: Single node, no edges
print(max_path_quality(
    [5],
    [],
    10))  # Expected: 5

# Test 4: Can't travel to any node and return within max_time
print(max_path_quality(
    [1, 100],
    [[0,1,20]],
    10))  # Expected: 1

# Test 5: Linear path — traverse full chain and return
print(max_path_quality(
    [10, 20, 30],
    [[0,1,5],[1,2,5]],
    20))  # Expected: 60 (0->1->2->1->0, time=20)

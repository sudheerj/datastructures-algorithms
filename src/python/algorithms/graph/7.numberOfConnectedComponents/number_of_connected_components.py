"""
Number of Connected Components in an Undirected Graph

Given n nodes labeled from 0 to n - 1 and a list of undirected edges,
find the number of connected components.

Time Complexity: O(V + E)
Space Complexity: O(V + E)
"""

from collections import defaultdict


def count_components_dfs(n, edges):
    """
    DFS approach.
    TC: O(V + E), SC: O(V + E)
    """
    graph = defaultdict(list)
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)
    
    visited = set()
    count = 0
    
    def dfs(node):
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor)
    
    for node in range(n):
        if node not in visited:
            count += 1
            dfs(node)
    
    return count


def count_components_union_find(n, edges):
    """
    Union-Find approach.
    TC: O(E * α(n)) ≈ O(E), SC: O(V)
    """
    parent = list(range(n))
    rank = [1] * n
    
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])  # Path compression
        return parent[x]
    
    def union(x, y):
        root_x, root_y = find(x), find(y)
        if root_x == root_y:
            return False
        
        # Union by rank
        if rank[root_x] < rank[root_y]:
            root_x, root_y = root_y, root_x
        parent[root_y] = root_x
        rank[root_x] += rank[root_y]
        return True
    
    components = n
    for a, b in edges:
        if union(a, b):
            components -= 1
    
    return components


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"n": 5, "edges": [[0, 1], [1, 2], [3, 4]]},          # 2
        {"n": 5, "edges": [[0, 1], [1, 2], [2, 3], [3, 4]]},  # 1
    ]
    
    for test in test_cases:
        print(f"n: {test['n']}, edges: {test['edges']}")
        print(f"Components (DFS): {count_components_dfs(test['n'], test['edges'])}")
        print(f"Components (Union-Find): {count_components_union_find(test['n'], test['edges'])}")
        print()

"""
Clone Graph

Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph.

Time Complexity: O(N + E) where N is nodes and E is edges
Space Complexity: O(N)
"""

from collections import deque


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


def clone_graph_dfs(node):
    """
    DFS approach.
    TC: O(N + E), SC: O(N)
    """
    if not node:
        return None
    
    visited = {}
    
    def dfs(node):
        if node in visited:
            return visited[node]
        
        copy = Node(node.val)
        visited[node] = copy
        
        for neighbor in node.neighbors:
            copy.neighbors.append(dfs(neighbor))
        
        return copy
    
    return dfs(node)


def clone_graph_bfs(node):
    """
    BFS approach.
    TC: O(N + E), SC: O(N)
    """
    if not node:
        return None
    
    visited = {node: Node(node.val)}
    queue = deque([node])
    
    while queue:
        current = queue.popleft()
        
        for neighbor in current.neighbors:
            if neighbor not in visited:
                visited[neighbor] = Node(neighbor.val)
                queue.append(neighbor)
            visited[current].neighbors.append(visited[neighbor])
    
    return visited[node]


# Test case
if __name__ == "__main__":
    # Create a simple graph: 1 -- 2
    #                        |    |
    #                        4 -- 3
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    
    node1.neighbors = [node2, node4]
    node2.neighbors = [node1, node3]
    node3.neighbors = [node2, node4]
    node4.neighbors = [node1, node3]
    
    cloned = clone_graph_dfs(node1)
    print(f"Original node value: {node1.val}")
    print(f"Cloned node value: {cloned.val}")
    print(f"Are they the same object? {node1 is cloned}")

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
    
    cloned = {}
    
    def dfs(node):
        if node in cloned:
            return cloned[node]
        
        clone = Node(node.val)
        cloned[node] = clone
        
        for neighbor in node.neighbors:
            clone.neighbors.append(dfs(neighbor))
        
        return clone
    
    return dfs(node)


def clone_graph_bfs(node):
    """
    BFS approach.
    TC: O(N + E), SC: O(N)
    """
    if not node:
        return None
    
    cloned = {node: Node(node.val)}
    queue = deque([node])
    
    while queue:
        current = queue.popleft()
        
        for neighbor in current.neighbors:
            if neighbor not in cloned:
                cloned[neighbor] = Node(neighbor.val)
                queue.append(neighbor)
            cloned[current].neighbors.append(cloned[neighbor])
    
    return cloned[node]


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

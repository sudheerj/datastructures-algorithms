"""
Dijkstra's Algorithm implementation in Python.
Finds the shortest path from a source vertex to all other vertices in a weighted graph.
"""


def dijkstra(graph, start):
    """
    Dijkstra's shortest path algorithm.
    
    Args:
        graph: Dictionary representing weighted graph
        start: Starting vertex
    
    Returns:
        Dictionary with shortest distances from start to all vertices
    """
    distances = {}
    visited = set()
    nodes = list(graph.keys())

    # Initialize all distances to infinity
    for node in nodes:
        distances[node] = float('inf')
    
    distances[start] = 0

    while nodes:
        # Sort nodes by distance and get the closest unvisited node
        nodes.sort(key=lambda x: distances[x])
        closest_node = nodes.pop(0)

        if distances[closest_node] == float('inf'):
            break

        visited.add(closest_node)

        # Update distances to neighbors
        for neighbor, weight in graph[closest_node].items():
            if neighbor not in visited:
                new_distance = distances[closest_node] + weight
                if new_distance < distances[neighbor]:
                    distances[neighbor] = new_distance

    return distances


# Usage example
if __name__ == "__main__":
    graph = {
        'A': {'B': 1, 'C': 4},
        'B': {'A': 1, 'C': 2, 'D': 5},
        'C': {'A': 4, 'B': 2, 'D': 1},
        'D': {'B': 5, 'C': 1}
    }

    result = dijkstra(graph, 'A')
    print(f"Shortest distances from A: {result}")
    # Output: {'A': 0, 'B': 1, 'C': 3, 'D': 4}

"""
Find Shortest Path with K Hops

Given a directed weighted graph, find the minimum cost path from source to 
destination using at most k edges (hops). Return -1 if no such path exists.

TC: O((V + E) * k * log(V * k))
SC: O(V * k)
"""

import heapq
from typing import List, Tuple


class Edge:
    """Represents a directed weighted edge."""
    def __init__(self, to: int, weight: int):
        self.to = to
        self.weight = weight


def shortest_path_with_k_hops(graph: List[List[Edge]], src: int, dst: int, k: int) -> int:
    """
    Find shortest path from src to dst with at most k hops.
    
    Args:
        graph: Adjacency list where graph[i] is list of Edge objects
        src: Source node
        dst: Destination node
        k: Maximum number of hops allowed
    
    Returns:
        Minimum cost to reach dst from src with at most k hops, or -1 if impossible
    """
    n = len(graph)
    
    # best[node][hops] = minimum cost to reach node using exactly hops edges
    best = [[float('inf')] * (k + 1) for _ in range(n)]
    
    # Priority queue: (cost, node, hops)
    pq = [(0, src, 0)]
    best[src][0] = 0
    
    while pq:
        cost, node, hops = heapq.heappop(pq)
        
        # If we reached destination, return the cost
        if node == dst:
            return cost
        
        # Cannot exceed k hops
        if hops > k:
            continue
        
        # Explore all edges from current node
        for edge in graph[node]:
            new_cost = cost + edge.weight
            new_hops = hops + 1
            
            if new_cost < best[edge.to][new_hops]:
                best[edge.to][new_hops] = new_cost
                heapq.heappush(pq, (new_cost, edge.to, new_hops))
    
    return -1  # Not reachable


if __name__ == "__main__":
    # Test case 1: Simple path with k=1
    print("Test case 1:")
    graph1 = [
        [Edge(1, 100), Edge(2, 500)],  # Node 0
        [Edge(2, 100)],                 # Node 1
        [Edge(3, 100)],                 # Node 2
        []                              # Node 3
    ]
    result1 = shortest_path_with_k_hops(graph1, 0, 3, 1)
    print("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)")
    print("Source: 0, Destination: 3, K: 1")
    print(f"Output: {result1}")
    print("Expected: -1 (need at least 2 hops)")
    print()

    # Test case 2: Direct path vs longer path
    print("Test case 2:")
    graph2 = [
        [Edge(1, 100), Edge(2, 500)],  # Node 0
        [Edge(2, 100)],                 # Node 1
        [Edge(3, 100)],                 # Node 2
        []                              # Node 3
    ]
    result2 = shortest_path_with_k_hops(graph2, 0, 3, 2)
    print("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)")
    print("Source: 0, Destination: 3, K: 2")
    print(f"Output: {result2}")
    print("Expected: 600 (0->2->3 with cost 500+100=600)")
    print()

    # Test case 3: Multiple paths with different costs
    print("Test case 3:")
    graph3 = [
        [Edge(1, 100), Edge(2, 500)],  # Node 0
        [Edge(2, 100)],                 # Node 1
        [Edge(3, 100)],                 # Node 2
        []                              # Node 3
    ]
    result3 = shortest_path_with_k_hops(graph3, 0, 3, 3)
    print("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)")
    print("Source: 0, Destination: 3, K: 3")
    print(f"Output: {result3}")
    print("Expected: 300 (0->1->2->3 with cost 100+100+100=300)")
    print()

    # Test case 4: Flight prices example
    print("Test case 4:")
    graph4 = [
        [Edge(1, 100)],                      # Node 0
        [Edge(2, 100), Edge(0, 100)],       # Node 1
        [Edge(0, 100)]                       # Node 2
    ]
    result4 = shortest_path_with_k_hops(graph4, 0, 2, 1)
    print("Graph: 0->(1:100), 1->(2:100, 0:100), 2->(0:100)")
    print("Source: 0, Destination: 2, K: 1")
    print(f"Output: {result4}")
    print("Expected: 200 (0->1->2 with cost 100+100=200)")
    print()

    # Test case 5: No path possible
    print("Test case 5:")
    graph5 = [
        [Edge(1, 100)],  # Node 0
        [Edge(2, 100)],  # Node 1
        [],              # Node 2
        []               # Node 3
    ]
    result5 = shortest_path_with_k_hops(graph5, 0, 3, 5)
    print("Graph: 0->(1:100), 1->(2:100), 2->(), 3->()")
    print("Source: 0, Destination: 3, K: 5")
    print(f"Output: {result5}")
    print("Expected: -1 (no path from 0 to 3)")

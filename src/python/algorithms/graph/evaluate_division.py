"""
Evaluate Division

Given equations and values representing division relationships,
evaluate queries to find division results between variables.

TC: O(E + Q * (V + E)) where E=equations, Q=queries, V=variables
SC: O(E + V) for graph storage and recursion stack
"""

from typing import List
from collections import defaultdict


def calcEquation(equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
    """
    Evaluate division queries based on given equations.
    
    Args:
        equations: List of variable pairs [a, b] representing a/b
        values: List of values for each equation
        queries: List of query pairs [c, d] to evaluate c/d
    
    Returns:
        List of results for each query, -1.0 if cannot be determined
    """
    # Build the graph
    graph = defaultdict(list)
    for i, (a, b) in enumerate(equations):
        val = values[i]
        graph[a].append((b, val))
        graph[b].append((a, 1.0 / val))
    
    def dfs(curr: str, target: str, product: float, visited: set) -> float:
        """DFS to find path from curr to target, accumulating product."""
        if curr == target:
            return product
        
        visited.add(curr)
        
        for neighbor, weight in graph[curr]:
            if neighbor not in visited:
                result = dfs(neighbor, target, product * weight, visited)
                if result != -1.0:
                    return result
        
        return -1.0
    
    # Process each query
    results = []
    for src, dst in queries:
        if src not in graph or dst not in graph:
            results.append(-1.0)
        else:
            visited = set()
            results.append(dfs(src, dst, 1.0, visited))
    
    return results


if __name__ == "__main__":
    # Test case 1
    print("Test case 1:")
    equations1 = [["a", "b"], ["b", "c"]]
    values1 = [2.0, 3.0]
    queries1 = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
    result1 = calcEquation(equations1, values1, queries1)
    print(f"Output: {result1}")
    print("Expected: [6.0, 0.5, -1.0, 1.0, -1.0]")
    print("Explanation: a/b = 2.0, b/c = 3.0, so a/c = 6.0")
    print()

    # Test case 2
    print("Test case 2:")
    equations2 = [["a", "b"], ["b", "c"], ["bc", "cd"]]
    values2 = [1.5, 2.5, 5.0]
    queries2 = [["a", "c"], ["c", "b"], ["bc", "cd"], ["cd", "bc"]]
    result2 = calcEquation(equations2, values2, queries2)
    print(f"Output: {result2}")
    print("Expected: [3.75, 0.4, 5.0, 0.2]")
    print()

    # Test case 3
    print("Test case 3:")
    equations3 = [["a", "b"]]
    values3 = [0.5]
    queries3 = [["a", "b"], ["b", "a"], ["a", "c"], ["x", "y"]]
    result3 = calcEquation(equations3, values3, queries3)
    print(f"Output: {result3}")
    print("Expected: [0.5, 2.0, -1.0, -1.0]")
    print()

    # Test case 4
    print("Test case 4:")
    equations4 = [["a", "b"], ["b", "c"], ["c", "d"]]
    values4 = [2.0, 3.0, 4.0]
    queries4 = [["a", "d"], ["d", "a"]]
    result4 = calcEquation(equations4, values4, queries4)
    print(f"Output: {result4}")
    print("Expected: [24.0, 0.04166...]")
    print("Explanation: a/d = (a/b) * (b/c) * (c/d) = 2 * 3 * 4 = 24")
    print()

    # Test case 5
    print("Test case 5:")
    equations5 = [["x1", "x2"], ["x2", "x3"], ["x3", "x4"], ["x4", "x5"]]
    values5 = [3.0, 4.0, 5.0, 6.0]
    queries5 = [["x1", "x5"], ["x5", "x2"], ["x2", "x4"], ["x2", "x2"], ["x2", "x9"]]
    result5 = calcEquation(equations5, values5, queries5)
    print(f"Output: {result5}")
    print("Expected: [360.0, 0.04166..., 20.0, 1.0, -1.0]")
    print("Explanation: x1/x5 = 3 * 4 * 5 * 6 = 360")

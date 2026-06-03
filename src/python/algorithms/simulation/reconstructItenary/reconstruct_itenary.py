# Reconstruct Itinerary (LC 332)
# DFS + Hierholzer's algorithm  TC: O(E log E)  SC: O(E)

from typing import List


def reconstruct_itinerary(tickets: List[List[str]]) -> List[str]:
    graph = {}
    for src, dst in tickets:
        graph.setdefault(src, []).append(dst)
    for src in graph:
        graph[src].sort(reverse=True)  # descending so pop() yields smallest

    result = []

    def dfs(airport: str) -> None:
        while graph.get(airport):
            dfs(graph[airport].pop())
        result.append(airport)

    dfs("JFK")
    return result[::-1]


if __name__ == "__main__":
    test_cases = [
        (
            [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]],
            ["JFK","MUC","LHR","SFO","SJC"],
        ),
        (
            [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]],
            ["JFK","ATL","JFK","SFO","ATL","SFO"],
        ),
        (
            [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]],
            ["JFK","NRT","JFK","KUL"],
        ),
        (
            [["JFK","A"],["A","JFK"]],
            ["JFK","A","JFK"],
        ),
    ]

    for tickets, expected in test_cases:
        result = reconstruct_itinerary(tickets)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

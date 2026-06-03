# Number of Provinces (LC 547)
# Approach 1: Recursive DFS  TC: O(n^2)  SC: O(n)
# Approach 2: BFS             TC: O(n^2)  SC: O(n)
# Approach 3: Union-Find      TC: O(n^2)  SC: O(n)

from collections import deque


def number_of_provinces(is_connected: list[list[int]]) -> int:
    n = len(is_connected)
    visited = [False] * n
    provinces = 0

    def dfs(city: int) -> None:
        visited[city] = True
        for neighbor in range(n):
            if is_connected[city][neighbor] == 1 and not visited[neighbor]:
                dfs(neighbor)

    for i in range(n):
        if not visited[i]:
            dfs(i)
            provinces += 1

    return provinces


def number_of_provinces2(is_connected: list[list[int]]) -> int:
    n = len(is_connected)
    visited = [False] * n
    provinces = 0

    for i in range(n):
        if not visited[i]:
            queue = deque([i])
            visited[i] = True
            while queue:
                city = queue.popleft()
                for neighbor in range(n):
                    if is_connected[city][neighbor] == 1 and not visited[neighbor]:
                        queue.append(neighbor)
                        visited[neighbor] = True
            provinces += 1

    return provinces


class UnionFind:
    def __init__(self, n: int) -> None:
        self.parent = list(range(n))
        self.rank = [0] * n
        self.count = n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int) -> None:
        rx, ry = self.find(x), self.find(y)
        if rx == ry:
            return
        if self.rank[rx] > self.rank[ry]:
            self.parent[ry] = rx
        elif self.rank[rx] < self.rank[ry]:
            self.parent[rx] = ry
        else:
            self.parent[ry] = rx
            self.rank[rx] += 1
        self.count -= 1


def number_of_provinces3(is_connected: list[list[int]]) -> int:
    n = len(is_connected)
    uf = UnionFind(n)
    for i in range(n):
        for j in range(i + 1, n):
            if is_connected[i][j] == 1:
                uf.union(i, j)
    return uf.count


if __name__ == "__main__":
    test_cases = [
        ([[1,1,0],[1,1,0],[0,0,1]],                     2),
        ([[1,0,0],[0,1,0],[0,0,1]],                     3),
        ([[1,1,1],[1,1,1],[1,1,1]],                     1),
        ([[1,0,0,1],[0,1,1,0],[0,1,1,0],[1,0,0,1]],    2),
        ([[1]],                                          1),
    ]

    for label, fn in [("Approach 1: Recursive DFS", number_of_provinces),
                      ("Approach 2: BFS",            number_of_provinces2),
                      ("Approach 3: Union-Find",     number_of_provinces3)]:
        print(f"--- {label} ---")
        for is_connected, expected in test_cases:
            result = fn(is_connected)
            status = "PASS" if result == expected else "FAIL"
            print(f"[{status}] result={result} expected={expected}")


class UnionFind:
    def __init__(self, size):
        self.parent = [-1] * size
        self.rank = [0] * size

    def add_land(self, x):
        self.parent[x] = x

    def is_land(self, x):
        return self.parent[x] != -1

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x == root_y:
            return False
        if self.rank[root_x] > self.rank[root_y]:
            self.parent[root_y] = root_x
        elif self.rank[root_x] < self.rank[root_y]:
            self.parent[root_x] = root_y
        else:
            self.parent[root_y] = root_x
            self.rank[root_x] += 1
        return True


# TC: O(k * α(m*n)) ≈ O(k),  SC: O(m*n)
def number_of_islands2(m, n, positions):
    result = []
    uf = UnionFind(m * n)
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    islands_count = 0

    for row, col in positions:
        index = row * n + col

        if uf.is_land(index):
            result.append(islands_count)
            continue

        uf.add_land(index)
        islands_count += 1

        for dr, dc in directions:
            nr, nc = row + dr, col + dc
            if nr < 0 or nr >= m or nc < 0 or nc >= n:
                continue
            neighbour_index = nr * n + nc
            if uf.is_land(neighbour_index):
                if uf.union(index, neighbour_index):
                    islands_count -= 1

        result.append(islands_count)
    return result


test_cases = [
    (3, 3, [[0,0],[0,1],[1,2],[2,1]], [1,1,2,3]),
    (2, 2, [[0,0],[0,1],[1,0],[1,1]], [1,1,1,1]),
    (1, 1, [[0,0]], [1]),
    (3, 3, [[0,0],[0,0],[0,1]], [1,1,1]),
    (3, 3, [[0,0],[2,2],[1,1],[0,1],[1,0]], [1,2,3,2,2]),
]

for i, (m, n, positions, expected) in enumerate(test_cases, 1):
    result = number_of_islands2(m, n, positions)
    print(f"Test {i}: Result={result}, Expected={expected}")

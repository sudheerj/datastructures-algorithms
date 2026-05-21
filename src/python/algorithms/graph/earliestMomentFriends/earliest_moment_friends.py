class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n
        self.count = n

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
        self.count -= 1
        return True

    def get_count(self):
        return self.count


# TC: O(m log m) for sorting + O(m * α(n)) ≈ O(m log m),  SC: O(n)
def find_time(logs, n):
    logs.sort(key=lambda x: x[0])
    uf = UnionFind(n)

    for time, p1, p2 in logs:
        if uf.union(p1, p2):
            if uf.get_count() == 1:
                return time
    return -1


test_cases = [
    ([[20,0,1],[30,1,2],[10,0,3],[40,2,3]], 4, 30),
    ([[9,3,0],[0,2,1],[8,0,1],[5,2,0]], 4, 9),
    ([[10,0,1],[20,2,3]], 5, -1),
    ([[5,0,1]], 2, 5),
    ([[1,0,1],[2,1,2],[3,2,3],[4,3,4]], 5, 4),
]

for i, (logs, n, expected) in enumerate(test_cases, 1):
    result = find_time(logs, n)
    print(f"Test {i}: Result={result}, Expected={expected}")

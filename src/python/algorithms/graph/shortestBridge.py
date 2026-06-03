from collections import deque
from copy import deepcopy

def shortestBridge(grid):
    n, m = len(grid), len(grid[0])
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    queue = deque()
    found = False
    def dfs(r, c):
        if r < 0 or r >= n or c < 0 or c >= m or grid[r][c] != 1:
            return
        grid[r][c] = -1
        queue.append((r, c))
        for dr, dc in directions:
            dfs(r+dr, c+dc)
    for i in range(n):
        if found:
            break
        for j in range(m):
            if grid[i][j] == 1:
                dfs(i, j)
                found = True
                break
    steps = 0
    while queue:
        for _ in range(len(queue)):
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r+dr, c+dc
                if 0 <= nr < n and 0 <= nc < m:
                    if grid[nr][nc] == 1:
                        return steps
                    if grid[nr][nc] == 0:
                        grid[nr][nc] = -1
                        queue.append((nr, nc))
        steps += 1
    return -1

def run_tests():
    tests = [
        ([[0,1],[1,0]], 1),
        ([[0,1,0],[0,0,0],[0,0,1]], 2),
        ([[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]], 1),
        ([[0,1,1,0,0],[0,0,0,0,0],[0,0,0,0,1],[0,0,0,0,1]], 2),
        ([[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,1]], 4),
    ]
    for i, (grid, expected) in enumerate(tests, 1):
        result = shortestBridge(deepcopy(grid))
        print(f"Test {i}: Output={result}, Expected={expected} [{'PASS' if result==expected else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()

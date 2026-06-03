"""
Max Area of Island (LeetCode 695)
DFS and BFS solutions
"""
from collections import deque

def max_area_of_island_dfs(grid):
    rows, cols = len(grid), len(grid[0])
    copy = [row[:] for row in grid]
    def dfs(r, c):
        if r < 0 or c < 0 or r >= rows or c >= cols or copy[r][c] == 0:
            return 0
        copy[r][c] = 0
        return 1 + dfs(r-1, c) + dfs(r, c+1) + dfs(r+1, c) + dfs(r, c-1)
    max_area = 0
    for r in range(rows):
        for c in range(cols):
            if copy[r][c] == 1:
                max_area = max(max_area, dfs(r, c))
    return max_area

def max_area_of_island_bfs(grid):
    rows, cols = len(grid), len(grid[0])
    copy = [row[:] for row in grid]
    directions = [(-1,0),(0,1),(1,0),(0,-1)]
    max_area = 0
    for r in range(rows):
        for c in range(cols):
            if copy[r][c] == 1:
                area = 0
                queue = deque([(r, c)])
                copy[r][c] = 0
                while queue:
                    row, col = queue.popleft()
                    area += 1
                    for dr, dc in directions:
                        nr, nc = row + dr, col + dc
                        if 0 <= nr < rows and 0 <= nc < cols and copy[nr][nc] == 1:
                            queue.append((nr, nc))
                            copy[nr][nc] = 0
                max_area = max(max_area, area)
    return max_area

if __name__ == "__main__":
    test_grids = [
        [
            [0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0]
        ],
        [[0,0,0,0,0,0,0,0]],
        [[1,1,1],[1,0,1],[1,1,1]]
    ]
    expected = [6, 0, 8]

    print("Testing Max Area of Island (DFS):")
    for i, grid in enumerate(test_grids):
        res = max_area_of_island_dfs(grid)
        print(("PASS" if res == expected[i] else "FAIL"), f"Test {i+1}: got {res}, expected {expected[i]}")

    print("\nTesting Max Area of Island (BFS):")
    for i, grid in enumerate(test_grids):
        res = max_area_of_island_bfs(grid)
        print(("PASS" if res == expected[i] else "FAIL"), f"Test {i+1}: got {res}, expected {expected[i]}")

from collections import deque
from copy import deepcopy

def oranges_rotting(grid):
    rows, cols = len(grid), len(grid[0])
    queue = deque()
    fresh = 0
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 2:
                queue.append((r, c))
            elif grid[r][c] == 1:
                fresh += 1
    minutes = 0
    directions = [(-1,0),(0,1),(1,0),(0,-1)]
    while queue and fresh > 0:
        for _ in range(len(queue)):
            row, col = queue.popleft()
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                    grid[nr][nc] = 2
                    queue.append((nr, nc))
                    fresh -= 1
        minutes += 1
    return minutes if fresh == 0 else -1

def run_tests():
    test_cases = [
        # Example 1
        [
            [2,1,1],
            [1,1,0],
            [0,1,1]
        ],
        # Example 2
        [
            [2,1,1],
            [0,1,1],
            [1,0,1]
        ],
        # Example 3
        [
            [0,2]
        ],
        # All rotten
        [
            [2,2],
            [2,2]
        ],
        # No oranges
        [
            [0,0],
            [0,0]
        ]
    ]
    expected = [4, -1, 0, 0, 0]
    for i, (grid, exp) in enumerate(zip(test_cases, expected)):
        result = oranges_rotting(deepcopy(grid))
        status = "PASS" if result == exp else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {exp} | {status}")

if __name__ == "__main__":
    run_tests()

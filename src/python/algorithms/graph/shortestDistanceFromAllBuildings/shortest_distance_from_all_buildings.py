from collections import deque


# BFS Shortest path TC: O(k * m * n) SC: O(m * n)
def shortest_distance(grid: list[list[int]]) -> int:
    rows, cols = len(grid), len(grid[0])
    distance = [[0] * cols for _ in range(rows)]
    walk = 0
    answer = float('inf')
    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == 1:
                queue = deque([(row, col)])
                level = 0

                while queue:
                    for _ in range(len(queue)):
                        r, c = queue.popleft()
                        for dr, dc in directions:
                            nr, nc = r + dr, c + dc
                            if nr < 0 or nr >= rows or nc < 0 or nc >= cols or grid[nr][nc] != walk:
                                continue
                            grid[nr][nc] -= 1               # mark visited
                            distance[nr][nc] += level + 1   # accumulate distance
                            answer = min(answer, distance[nr][nc])
                            queue.append((nr, nc))
                    level += 1

                walk -= 1

    return -1 if answer == float('inf') else answer


if __name__ == "__main__":
    import copy

    test_cases = [
        ([[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]], 7),
        ([[1,0]],                                 1),
        ([[1]],                                  -1),
        ([[0,1,0],[0,0,0],[0,1,0]],               2),
        ([[0,2,1]],                              -1),
    ]

    for grid, expected in test_cases:
        result = shortest_distance(copy.deepcopy(grid))
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

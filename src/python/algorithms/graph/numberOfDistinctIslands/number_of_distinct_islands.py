"""
Number of Distinct Islands

Given an m x n binary grid, return the number of distinct islands.
Two islands are the same if one can be translated (not rotated/reflected) to match the other.

Approach: DFS with relative-position path encoding stored in a set.
TC: O(m * n)  SC: O(m * n)
"""


def num_distinct_islands(grid: list[list[str]]) -> int:
    distinct = set()

    def dfs(row, col, base_row, base_col, path):
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] == '0':
            return
        grid[row][col] = '0'
        path.append(f"{row - base_row}:{col - base_col}")
        dfs(row + 1, col, base_row, base_col, path)  # down
        dfs(row - 1, col, base_row, base_col, path)  # up
        dfs(row, col + 1, base_row, base_col, path)  # right
        dfs(row, col - 1, base_row, base_col, path)  # left

    for r in range(len(grid)):
        for c in range(len(grid[0])):
            if grid[r][c] == '1':
                path = []
                dfs(r, c, r, c, path)
                distinct.add(tuple(path))

    return len(distinct)


if __name__ == "__main__":
    import copy

    test_cases = [
        (
            [['1','1','0','0'],
             ['1','1','0','0'],
             ['0','0','1','1'],
             ['0','0','1','1']],
            1, "two identical 2x2 blocks"
        ),
        (
            [['1','1','0','1','1'],
             ['1','0','0','0','0'],
             ['0','0','0','1','1'],
             ['0','0','0','1','1']],
            3, "L-shape + pair + 2x2 → 3 distinct"
        ),
        (
            [['1','1','0','0','0'],
             ['1','0','0','1','1'],
             ['0','0','0','1','0']],
            1, "two identical L-shapes (translation)"
        ),
        (
            [['0','0','0'],
             ['0','0','0']],
            0, "no islands"
        ),
        (
            [['1','0','1'],
             ['0','0','0'],
             ['1','0','0']],
            1, "three single-cell islands"
        ),
    ]

    for grid, expected, label in test_cases:
        result = num_distinct_islands(copy.deepcopy(grid))
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: → {result} (expected {expected})")

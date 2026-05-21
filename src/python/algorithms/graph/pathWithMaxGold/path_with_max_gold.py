# Path With Maximum Gold
# DFS + Backtracking  TC: O(m*n * 3^(m*n))  SC: O(m*n) for recursion stack
def path_with_max_gold(grid):
    rows, cols = len(grid), len(grid[0])
    max_gold = [0]

    def dfs(r, c, current_gold):
        # boundary or zero cell
        if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] == 0:
            return

        gold = grid[r][c]
        current_gold += gold
        max_gold[0] = max(max_gold[0], current_gold)

        # mark as visited
        grid[r][c] = 0

        # explore all 4 directions
        dfs(r - 1, c, current_gold)
        dfs(r, c + 1, current_gold)
        dfs(r + 1, c, current_gold)
        dfs(r, c - 1, current_gold)

        # backtrack
        grid[r][c] = gold

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] != 0:
                dfs(r, c, 0)

    return max_gold[0]


# Test 1: Classic grid — best path through center (9->8->7)
print(path_with_max_gold([
    [0, 6, 0],
    [5, 8, 7],
    [0, 9, 0]
]))  # Expected: 24

# Test 2: Larger grid with isolated regions
print(path_with_max_gold([
    [1, 0, 7],
    [2, 0, 6],
    [3, 4, 5],
    [0, 3, 0],
    [9, 0, 20]
]))  # Expected: 28

# Test 3: Single non-zero cell
print(path_with_max_gold([
    [5]
]))  # Expected: 5

# Test 4: All zeros — no gold to collect
print(path_with_max_gold([
    [0, 0],
    [0, 0]
]))  # Expected: 0

# Test 5: All non-zero — can traverse entire grid
print(path_with_max_gold([
    [1, 2],
    [3, 4]
]))  # Expected: 10

# Test 6: Single row — linear path
print(path_with_max_gold([
    [1, 2, 3]
]))  # Expected: 6

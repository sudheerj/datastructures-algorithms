"""
Number of Islands

Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
return the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically.

Time Complexity: O(m * n) where m is rows and n is columns
Space Complexity: O(m * n) for recursion stack in worst case
"""


def num_islands(grid):
    """
    DFS approach to count islands.
    TC: O(m * n), SC: O(m * n)
    """
    if not grid or not grid[0]:
        return 0
    
    rows, cols = len(grid), len(grid[0])
    count = 0
    
    def dfs(r, c):
        # Base case: out of bounds or water
        if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
            return
        
        # Mark as visited by changing to '0'
        grid[r][c] = '0'
        
        # Explore all 4 directions
        dfs(r + 1, c)  # down
        dfs(r - 1, c)  # up
        dfs(r, c + 1)  # right
        dfs(r, c - 1)  # left
    
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == '1':
                count += 1
                dfs(r, c)
    
    return count


def num_islands_bfs(grid):
    """
    BFS approach to count islands.
    TC: O(m * n), SC: O(min(m, n))
    """
    from collections import deque
    
    if not grid or not grid[0]:
        return 0
    
    rows, cols = len(grid), len(grid[0])
    count = 0
    
    def bfs(r, c):
        queue = deque([(r, c)])
        grid[r][c] = '0'
        
        while queue:
            row, col = queue.popleft()
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == '1':
                    grid[nr][nc] = '0'
                    queue.append((nr, nc))
    
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == '1':
                count += 1
                bfs(r, c)
    
    return count


# Test cases
if __name__ == "__main__":
    # Example 1
    grid1 = [
        ['1', '1', '1', '1', '0'],
        ['1', '1', '0', '1', '0'],
        ['1', '1', '0', '0', '0'],
        ['0', '0', '0', '0', '0']
    ]
    print(f"Number of islands: {num_islands([row[:] for row in grid1])}")  # 1
    
    # Example 2
    grid2 = [
        ['1', '1', '0', '0', '0'],
        ['1', '1', '0', '0', '0'],
        ['0', '0', '1', '0', '0'],
        ['0', '0', '0', '1', '1']
    ]
    print(f"Number of islands: {num_islands([row[:] for row in grid2])}")  # 3
    
    # Example 3: Single island
    grid3 = [['1']]
    print(f"Number of islands: {num_islands([row[:] for row in grid3])}")  # 1

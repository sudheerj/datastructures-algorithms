"""
Game of Life

Given an m x n grid of cells where each cell is either live (1) or dead (0),
the next state is determined by these rules:
1. Live cell with < 2 live neighbors dies (under-population).
2. Live cell with 2-3 live neighbors lives.
3. Live cell with > 3 live neighbors dies (over-population).
4. Dead cell with exactly 3 live neighbors becomes live (reproduction).

Compute the next state in-place.

Time Complexity: O(m * n)
Space Complexity: O(1) - in-place modification
"""


def game_of_life(board):
    """
    In-place solution using state encoding.
    Original | New | State
    0        | 0   | 0
    1        | 0   | 1
    0        | 1   | 2
    1        | 1   | 3
    TC: O(m * n), SC: O(1)
    """
    if not board or not board[0]:
        return
    
    rows, cols = len(board), len(board[0])
    
    def count_live_neighbors(r, c):
        """Count live neighbors (original state: 1 or 3)."""
        count = 0
        for dr in [-1, 0, 1]:
            for dc in [-1, 0, 1]:
                if dr == 0 and dc == 0:
                    continue
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    # Check original state (1 or 3 means originally alive)
                    if board[nr][nc] in [1, 3]:
                        count += 1
        return count
    
    # First pass: encode new state
    for r in range(rows):
        for c in range(cols):
            live_neighbors = count_live_neighbors(r, c)
            
            if board[r][c] == 1:  # Currently alive
                if live_neighbors in [2, 3]:
                    board[r][c] = 3  # Stays alive (1 -> 3)
                # else stays 1 (will die, 1 -> 0)
            else:  # Currently dead
                if live_neighbors == 3:
                    board[r][c] = 2  # Becomes alive (0 -> 2)
                # else stays 0
    
    # Second pass: decode final state
    for r in range(rows):
        for c in range(cols):
            board[r][c] = 1 if board[r][c] >= 2 else 0


def game_of_life_with_copy(board):
    """
    Simple solution using a copy of the board.
    TC: O(m * n), SC: O(m * n)
    """
    if not board or not board[0]:
        return
    
    rows, cols = len(board), len(board[0])
    copy = [row[:] for row in board]
    
    def count_live_neighbors(r, c):
        count = 0
        for dr in [-1, 0, 1]:
            for dc in [-1, 0, 1]:
                if dr == 0 and dc == 0:
                    continue
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and copy[nr][nc] == 1:
                    count += 1
        return count
    
    for r in range(rows):
        for c in range(cols):
            live_neighbors = count_live_neighbors(r, c)
            
            if copy[r][c] == 1:
                if live_neighbors < 2 or live_neighbors > 3:
                    board[r][c] = 0
            else:
                if live_neighbors == 3:
                    board[r][c] = 1


# Test cases
if __name__ == "__main__":
    # Example 1
    board1 = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    print(f"Before: {board1}")
    game_of_life(board1)
    print(f"After: {board1}")  # [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    
    # Example 2
    board2 = [[1, 1], [1, 0]]
    print(f"\nBefore: {board2}")
    game_of_life(board2)
    print(f"After: {board2}")  # [[1,1],[1,1]]

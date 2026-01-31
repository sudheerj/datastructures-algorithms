"""
Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
validated according to the following rules:
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes must contain the digits 1-9 without repetition.

Time Complexity: O(1) - fixed 9x9 board, or O(n^2) for n x n board
Space Complexity: O(1) - fixed size sets
"""


def is_valid_sudoku(board):
    """
    Use sets to track seen numbers in rows, columns, and boxes.
    TC: O(1), SC: O(1)
    """
    rows = [set() for _ in range(9)]
    cols = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]
    
    for r in range(9):
        for c in range(9):
            num = board[r][c]
            
            if num == '.':
                continue
            
            # Calculate box index (0-8)
            box_idx = (r // 3) * 3 + (c // 3)
            
            # Check if number already exists
            if num in rows[r] or num in cols[c] or num in boxes[box_idx]:
                return False
            
            # Add number to sets
            rows[r].add(num)
            cols[c].add(num)
            boxes[box_idx].add(num)
    
    return True


def is_valid_sudoku_single_set(board):
    """
    Alternative: Use a single set with encoded keys.
    TC: O(1), SC: O(1)
    """
    seen = set()
    
    for r in range(9):
        for c in range(9):
            num = board[r][c]
            
            if num == '.':
                continue
            
            # Create unique keys for row, column, and box
            row_key = f"row{r}:{num}"
            col_key = f"col{c}:{num}"
            box_key = f"box{r//3},{c//3}:{num}"
            
            if row_key in seen or col_key in seen or box_key in seen:
                return False
            
            seen.add(row_key)
            seen.add(col_key)
            seen.add(box_key)
    
    return True


# Test cases
if __name__ == "__main__":
    # Example 1: Valid sudoku
    board1 = [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
    print(f"Is valid sudoku: {is_valid_sudoku(board1)}")  # True
    
    # Example 2: Invalid sudoku (duplicate 8 in first column)
    board2 = [
        ["8","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
    print(f"Is valid sudoku: {is_valid_sudoku(board2)}")  # False

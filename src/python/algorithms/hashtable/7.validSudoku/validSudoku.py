
# Solution 1: Set-based
def isValidSudoku1(board):
    rows = [set() for _ in range(9)]
    cols = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]
    for r in range(9):
        for c in range(9):
            val = board[r][c]
            if val == ".":
                continue
            box_idx = (r // 3) * 3 + (c // 3)
            if val in rows[r] or val in cols[c] or val in boxes[box_idx]:
                return False
            rows[r].add(val)
            cols[c].add(val)
            boxes[box_idx].add(val)
    return True

# Solution 2: Boolean Array
def isValidSudoku2(board):
    rows = [[False]*9 for _ in range(9)]
    cols = [[False]*9 for _ in range(9)]
    boxes = [[False]*9 for _ in range(9)]
    for r in range(9):
        for c in range(9):
            if board[r][c] == ".":
                continue
            num = int(board[r][c]) - 1
            box_idx = (r // 3) * 3 + (c // 3)
            if rows[r][num] or cols[c][num] or boxes[box_idx][num]:
                return False
            rows[r][num] = cols[c][num] = boxes[box_idx][num] = True
    return True

# Solution 3: Map-based
def isValidSudoku3(board):
    from collections import defaultdict
    rows = defaultdict(set)
    cols = defaultdict(set)
    boxes = defaultdict(set)
    for r in range(9):
        for c in range(9):
            val = board[r][c]
            if val == ".":
                continue
            box_idx = (r // 3, c // 3)
            if val in rows[r] or val in cols[c] or val in boxes[box_idx]:
                return False
            rows[r].add(val)
            cols[c].add(val)
            boxes[box_idx].add(val)
    return True


if __name__ == "__main__":
    # Example 1: Valid Sudoku
    board1 = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"],
    ]
    print("isValidSudoku1:", isValidSudoku1(board1))  # Expected: True
    print("isValidSudoku2:", isValidSudoku2(board1))  # Expected: True
    print("isValidSudoku3:", isValidSudoku3(board1))  # Expected: True

    # Example 2: Invalid Sudoku (duplicate in row)
    board2 = [
        ["8", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"],
    ]
    print("isValidSudoku1:", isValidSudoku1(board2))  # Expected: False
    print("isValidSudoku2:", isValidSudoku2(board2))  # Expected: False
    print("isValidSudoku3:", isValidSudoku3(board2))  # Expected: False

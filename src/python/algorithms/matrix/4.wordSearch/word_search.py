"""
Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells.

Time Complexity: O(m * n * 4^L) where L is word length
Space Complexity: O(L) for recursion stack
"""


def exist(board, word):
    """
    DFS/Backtracking approach.
    TC: O(m * n * 4^L), SC: O(L)
    """
    if not board:
        return False
    
    rows, cols = len(board), len(board[0])
    
    def dfs(r, c, index):
        if index == len(word):
            return True
        
        if (r < 0 or r >= rows or c < 0 or c >= cols or 
            board[r][c] != word[index]):
            return False
        
        # Mark as visited
        temp = board[r][c]
        board[r][c] = '#'
        
        # Explore all 4 directions
        found = (dfs(r + 1, c, index + 1) or
                 dfs(r - 1, c, index + 1) or
                 dfs(r, c + 1, index + 1) or
                 dfs(r, c - 1, index + 1))
        
        # Restore
        board[r][c] = temp
        
        return found
    
    for r in range(rows):
        for c in range(cols):
            if dfs(r, c, 0):
                return True
    
    return False


# Test cases
if __name__ == "__main__":
    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    
    test_words = ["ABCCED", "SEE", "ABCB"]
    
    for word in test_words:
        # Create a copy of board for each test
        board_copy = [row[:] for row in board]
        print(f"Word '{word}' exists: {exist(board_copy, word)}")

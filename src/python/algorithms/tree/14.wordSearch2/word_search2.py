"""
Word Search II

Given an m x n board of characters and a list of strings words,
return all words found in the board.

Time Complexity: O(RC * 4^(RC))
Space Complexity: O(n * l) where n is number of words, l is longest word
"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.fullword = ""


class WordSearch2:
    def __init__(self):
        self.root = TrieNode()
    
    def find_words(self, board, words):
        """Find all words from the list that exist in the board."""
        result = []
        root = self._build_trie(words)
        
        for r in range(len(board)):
            for c in range(len(board[0])):
                self._dfs(board, result, root, r, c)
        
        return result
    
    def _build_trie(self, words):
        """Build a trie from the list of words."""
        for word in words:
            curr = self.root
            for ch in word:
                if ch not in curr.children:
                    curr.children[ch] = TrieNode()
                curr = curr.children[ch]
            curr.fullword = word
        return self.root
    
    def _dfs(self, board, result, curr, r, c):
        """DFS to find words starting from position (r, c)."""
        if r < 0 or c < 0 or r >= len(board) or c >= len(board[0]):
            return
        
        ch = board[r][c]
        if ch == '#' or ch not in curr.children:
            return
        
        curr = curr.children[ch]
        if curr.fullword:
            result.append(curr.fullword)
            curr.fullword = ""  # Avoid duplicates
        
        # Mark as visited
        board[r][c] = '#'
        
        # Explore all 4 directions
        self._dfs(board, result, curr, r - 1, c)  # up
        self._dfs(board, result, curr, r, c - 1)  # left
        self._dfs(board, result, curr, r + 1, c)  # down
        self._dfs(board, result, curr, r, c + 1)  # right
        
        # Restore the cell
        board[r][c] = ch


# Test cases
if __name__ == "__main__":
    board1 = [
        ['o', 'b', 'e', 'l'],
        ['k', 'a', 'p', 'p'],
        ['i', 'n', 'a', 'n'],
        ['w', 'i', 'p', 'a']
    ]
    words1 = ["apple", "banana", "pineapple", "kiwi", "orange"]
    
    word_search = WordSearch2()
    print(f"Board 1 found words: {word_search.find_words(board1, words1)}")
    
    board2 = [
        ['p', 'q'],
        ['p', 'q']
    ]
    words2 = ["pqpq"]
    
    word_search2 = WordSearch2()
    print(f"Board 2 found words: {word_search2.find_words(board2, words2)}")
    
    board3 = [
        ['o', 'a', 'a', 'n'],
        ['e', 't', 'a', 'e'],
        ['i', 'h', 'k', 'r'],
        ['i', 'f', 'l', 'v']
    ]
    words3 = ["oath", "pea", "eat", "rain"]
    
    word_search3 = WordSearch2()
    print(f"Board 3 found words: {word_search3.find_words(board3, words3)}")

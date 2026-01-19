"""
Design Add and Search Words Data Structure

Design a data structure that supports adding new words and
finding if a string matches any previously added string.
'.' can match any letter.

Time Complexity: O(n) for add, O(n * 26^m) for search where m is number of '.'
Space Complexity: O(n * k) where k is average word length
"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False


class WordDictionary:
    def __init__(self):
        self.root = TrieNode()
    
    def add_word(self, word):
        """Add a word to the dictionary. TC: O(n)"""
        if not word:
            return
        
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
        curr.is_end_of_word = True
    
    def search(self, word):
        """Search for a word. '.' can match any letter. TC: O(n * 26^m)"""
        if not word:
            return False
        return self._dfs(word, 0, self.root)
    
    def _dfs(self, word, index, node):
        if not node:
            return False
        if index == len(word):
            return node.is_end_of_word
        
        if word[index] == '.':
            # Try all possible children
            for child in node.children.values():
                if self._dfs(word, index + 1, child):
                    return True
            return False
        else:
            if word[index] not in node.children:
                return False
            return self._dfs(word, index + 1, node.children[word[index]])


# Test cases
if __name__ == "__main__":
    word_dict = WordDictionary()
    
    word_dict.add_word("bat")
    word_dict.add_word("cat")
    word_dict.add_word("rat")
    
    print(f"search('mat'): {word_dict.search('mat')}")  # False
    print(f"search('bat'): {word_dict.search('bat')}")  # True
    print(f"search('.at'): {word_dict.search('.at')}")  # True
    print(f"search('c..'): {word_dict.search('c..')}")  # True
    print(f"search('...'): {word_dict.search('...')}")  # True
    print(f"search('....'): {word_dict.search('....')}")  # False

"""
Trie (Prefix Tree) Implementation

A trie is an efficient information retrieval data structure.
Using a trie, search complexities can be brought to optimal limit (key length).

Time Complexity: O(m) where m is key length for all operations
Space Complexity: O(ALPHABET_SIZE * m * n) where n is number of keys
"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """Insert a word into the trie."""
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def search(self, word):
        """Returns True if word is in the trie."""
        node = self._find_node(word)
        return node is not None and node.is_end_of_word

    def starts_with(self, prefix):
        """Returns True if there is any word with the given prefix."""
        return self._find_node(prefix) is not None

    def _find_node(self, prefix):
        """Helper to find the node for a prefix."""
        node = self.root
        for char in prefix:
            if char not in node.children:
                return None
            node = node.children[char]
        return node


# Test case
if __name__ == "__main__":
    trie = Trie()
    
    trie.insert("apple")
    print(f"Search 'apple': {trie.search('apple')}")      # True
    print(f"Search 'app': {trie.search('app')}")          # False
    print(f"Starts with 'app': {trie.starts_with('app')}")  # True
    
    trie.insert("app")
    print(f"Search 'app' after insert: {trie.search('app')}")  # True

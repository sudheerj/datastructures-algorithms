"""
Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith operations.

Time Complexity: O(m) per operation where m is word length
Space Complexity: O(n * m) where n is number of words
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


# Test cases
if __name__ == "__main__":
    trie = Trie()

    # Example 1: Basic insert and search
    trie.insert("apple")
    print(f"Search 'apple': {trie.search('apple')}")          # True
    print(f"Search 'app': {trie.search('app')}")              # False
    print(f"Starts with 'app': {trie.starts_with('app')}")    # True

    # Example 2: Insert prefix word
    trie.insert("app")
    print(f"Search 'app' after insert: {trie.search('app')}")  # True

    # Example 3: Search non-existent word
    print(f"Search 'banana': {trie.search('banana')}")        # False
    print(f"Starts with 'ban': {trie.starts_with('ban')}")    # False

    # Example 4: Multiple words with shared prefix
    trie.insert("application")
    trie.insert("apply")
    print(f"Search 'application': {trie.search('application')}")  # True
    print(f"Search 'apply': {trie.search('apply')}")              # True
    print(f"Starts with 'appl': {trie.starts_with('appl')}")      # True

"""
Binary Search Tree implementation in Python.
"""


class Node:
    """Node class for Binary Search Tree."""
    
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class BinarySearchTree:
    """Binary Search Tree implementation."""
    
    def __init__(self):
        self.root = None

    def insert(self, value):
        """Inserts a new value into the BST."""
        new_node = Node(value)
        if not self.root:
            self.root = new_node
            return self
        
        current_node = self.root
        while True:
            if value < current_node.value:
                # Left
                if not current_node.left:
                    current_node.left = new_node
                    break
                current_node = current_node.left
            elif value > current_node.value:
                # Right
                if not current_node.right:
                    current_node.right = new_node
                    break
                current_node = current_node.right
            else:
                break  # Duplicate value, do nothing
        return self

    def lookup(self, value):
        """Searches for a value in the BST."""
        current_node = self.root
        while current_node:
            if value < current_node.value:
                current_node = current_node.left
            elif value > current_node.value:
                current_node = current_node.right
            else:
                return True
        return False

    def contains(self, value):
        """Alias for lookup method."""
        return self.lookup(value)

    def min_value_node(self, current_node=None):
        """Returns the node with the minimum value."""
        if current_node is None:
            current_node = self.root
        while current_node and current_node.left:
            current_node = current_node.left
        return current_node

    def max_value_node(self, current_node=None):
        """Returns the node with the maximum value."""
        if current_node is None:
            current_node = self.root
        while current_node and current_node.right:
            current_node = current_node.right
        return current_node

    def bfs(self):
        """Breadth-First Search traversal."""
        if not self.root:
            return []
        queue = [self.root]
        output = []
        while queue:
            current_node = queue.pop(0)
            output.append(current_node.value)
            if current_node.left:
                queue.append(current_node.left)
            if current_node.right:
                queue.append(current_node.right)
        return output

    def dfs_pre_order(self):
        """Depth-First Search - Pre-Order traversal."""
        output = []
        
        def traverse(node):
            if not node:
                return
            output.append(node.value)
            traverse(node.left)
            traverse(node.right)
        
        traverse(self.root)
        return output

    def dfs_post_order(self):
        """Depth-First Search - Post-Order traversal."""
        output = []
        
        def traverse(node):
            if not node:
                return
            traverse(node.left)
            traverse(node.right)
            output.append(node.value)
        
        traverse(self.root)
        return output

    def dfs_in_order(self):
        """Depth-First Search - In-Order traversal."""
        output = []
        
        def traverse(node):
            if not node:
                return
            traverse(node.left)
            output.append(node.value)
            traverse(node.right)
        
        traverse(self.root)
        return output


# Usage example
if __name__ == "__main__":
    tree = BinarySearchTree()
    for value in [20, 15, 25, 12, 16, 22, 30, 10, 14, 28, 35]:
        tree.insert(value)

    print(f"Lookup 25: {tree.lookup(25)}")
    print(f"Lookup 7: {tree.lookup(7)}")
    print(f"Lookup 10: {tree.lookup(10)}")
    print(f"Lookup 12: {tree.lookup(12)}")
    
    min_node = tree.min_value_node(tree.root.left)
    max_node = tree.max_value_node(tree.root.right)
    print(f"Min value in left subtree: {min_node.value if min_node else None}")
    print(f"Max value in right subtree: {max_node.value if max_node else None}")

    print(f"\nBFS: {tree.bfs()}")
    print(f"DFS Pre-Order: {tree.dfs_pre_order()}")
    print(f"DFS Post-Order: {tree.dfs_post_order()}")
    print(f"DFS In-Order: {tree.dfs_in_order()}")

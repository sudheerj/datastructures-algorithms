"""
Serialize and Deserialize Binary Tree

Design an algorithm to serialize and deserialize a binary tree.
Serialization is the process of converting a tree to a string.
Deserialization is the process of converting a string back to the original tree.

Time Complexity: O(n) for both serialize and deserialize
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def serialize(root):
    """
    Preorder traversal DFS serialization.
    TC: O(n), SC: O(n)
    """
    result = []
    
    def dfs(node):
        if not node:
            result.append("N")
            return
        result.append(str(node.value))
        dfs(node.left)
        dfs(node.right)
    
    dfs(root)
    return ",".join(result)


def deserialize(data):
    """
    DFS deserialization.
    TC: O(n), SC: O(n)
    """
    tokens = data.split(",")
    index = [0]
    
    def dfs():
        if tokens[index[0]] == "N":
            index[0] += 1
            return None
        
        node = TreeNode(int(tokens[index[0]]))
        index[0] += 1
        node.left = dfs()
        node.right = dfs()
        return node
    
    return dfs()


def print_tree(root):
    """Helper function to print tree in preorder."""
    if not root:
        return
    print(root.value, end=" ")
    print_tree(root.left)
    print_tree(root.right)


# Test cases
if __name__ == "__main__":
    # Create tree: [0, 1, 2, 3, 4, 5, 6]
    root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    
    serialized = serialize(root)
    print(f"Serialized: {serialized}")
    
    deserialized = deserialize(serialized)
    print("Deserialized tree (preorder): ", end="")
    print_tree(deserialized)
    print()
    
    # Test with empty tree
    serialized_empty = serialize(None)
    print(f"Serialized empty: {serialized_empty}")
    print(f"Deserialized empty: {deserialize(serialized_empty)}")

"""
Serialize and Deserialize Binary Tree

Design an algorithm to serialize a binary tree to a string
and deserialize the string back to a tree.

Time Complexity: O(n) for both serialize and deserialize
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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
        result.append(str(node.val))
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


# Test cases
if __name__ == "__main__":
    # Example 1: root = [1,2,3,null,null,4,5]
    #     1
    #    / \
    #   2   3
    #      / \
    #     4   5
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3, TreeNode(4), TreeNode(5))

    serialized = serialize(root)
    print(f"Serialized: {serialized}")  # 1,2,N,N,3,4,N,N,5,N,N

    deserialized = deserialize(serialized)
    print(f"Re-serialized: {serialize(deserialized)}")  # 1,2,N,N,3,4,N,N,5,N,N

    # Example 2: Empty tree
    print(f"Empty serialize: {serialize(None)}")  # N
    print(f"Empty deserialize is None: {deserialize('N') is None}")  # True

    # Example 3: Single node
    single = TreeNode(42)
    s = serialize(single)
    print(f"Single node serialized: {s}")  # 42,N,N
    d = deserialize(s)
    print(f"Single node value: {d.val}")  # 42

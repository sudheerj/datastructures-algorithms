"""
Invert Binary Tree

Given the root of a binary tree, invert the tree and return its root.

Time Complexity: O(n)
Space Complexity: O(h)
"""

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def invert_tree_recursive(root):
    """
    Recursive approach.
    TC: O(n), SC: O(h)
    """
    if not root:
        return None
    
    root.left, root.right = root.right, root.left
    
    invert_tree_recursive(root.left)
    invert_tree_recursive(root.right)
    
    return root


def invert_tree_iterative(root):
    """
    Iterative approach using queue.
    TC: O(n), SC: O(n)
    """
    if not root:
        return None
    
    queue = deque([root])
    
    while queue:
        node = queue.popleft()
        node.left, node.right = node.right, node.left
        
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    
    return root


def tree_to_list(root):
    """Helper to convert tree to list for printing."""
    if not root:
        return []
    
    result = []
    queue = deque([root])
    
    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
    
    return result


# Test case
if __name__ == "__main__":
    #     4
    #    / \
    #   2   7
    #  / \ / \
    # 1  3 6  9
    root = TreeNode(4)
    root.left = TreeNode(2, TreeNode(1), TreeNode(3))
    root.right = TreeNode(7, TreeNode(6), TreeNode(9))
    
    print(f"Original: {tree_to_list(root)}")
    invert_tree_recursive(root)
    print(f"Inverted: {tree_to_list(root)}")

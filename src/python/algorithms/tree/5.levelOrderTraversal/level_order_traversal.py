"""
Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values.

Time Complexity: O(n)
Space Complexity: O(n)
"""

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def level_order(root):
    """
    BFS approach.
    TC: O(n), SC: O(n)
    """
    if not root:
        return []
    
    result = []
    queue = deque([root])
    
    while queue:
        level = []
        level_size = len(queue)
        
        for _ in range(level_size):
            node = queue.popleft()
            level.append(node.val)
            
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        
        result.append(level)
    
    return result


def level_order_dfs(root):
    """
    DFS approach.
    TC: O(n), SC: O(n)
    """
    result = []
    
    def dfs(node, level):
        if not node:
            return
        
        if len(result) == level:
            result.append([])
        
        result[level].append(node.val)
        
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
    
    dfs(root, 0)
    return result


# Test case
if __name__ == "__main__":
    #     3
    #    / \
    #   9  20
    #     /  \
    #    15   7
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20, TreeNode(15), TreeNode(7))
    
    print(f"Level order: {level_order(root)}")  # [[3], [9, 20], [15, 7]]

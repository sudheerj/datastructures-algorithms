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


# Test cases
if __name__ == "__main__":
    #       1
    #      / \
    #     2   3
    #    / \ / \
    #   4  5 6  7
    root1 = TreeNode(1)
    root1.left = TreeNode(2, TreeNode(4), TreeNode(5))
    root1.right = TreeNode(3, TreeNode(6), TreeNode(7))

    root2 = TreeNode(3)

    # BFS tests
    print(f"BFS Test 1: {level_order(root1)}")  # [[1], [2, 3], [4, 5, 6, 7]]
    print(f"BFS Test 2: {level_order(root2)}")  # [[3]]
    print(f"BFS Test 3: {level_order(None)}")  # []

    # DFS tests
    print(f"DFS Test 1: {level_order_dfs(root1)}")  # [[1], [2, 3], [4, 5, 6, 7]]
    print(f"DFS Test 2: {level_order_dfs(root2)}")  # [[3]]
    print(f"DFS Test 3: {level_order_dfs(None)}")  # []

"""
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

Time Complexity: O(n)
Space Complexity: O(h) where h is height
"""

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def max_depth_recursive(root):
    """
    Recursive DFS approach.
    TC: O(n), SC: O(h)
    """
    if not root:
        return 0
    
    return 1 + max(max_depth_recursive(root.left), max_depth_recursive(root.right))


def max_depth_bfs(root):
    """
    BFS approach.
    TC: O(n), SC: O(n)
    """
    if not root:
        return 0
    
    queue = deque([root])
    depth = 0
    
    while queue:
        depth += 1
        level_size = len(queue)
        
        for _ in range(level_size):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    
    return depth


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
    
    print(f"Max depth (recursive): {max_depth_recursive(root)}")  # 3
    print(f"Max depth (BFS): {max_depth_bfs(root)}")  # 3

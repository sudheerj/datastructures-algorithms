"""
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth
(number of nodes along the longest path from root to leaf).

Time Complexity: O(n)
Space Complexity: O(h) recursive, O(n) iterative
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
    BFS level order approach.
    TC: O(n), SC: O(n)
    """
    if not root:
        return 0

    queue = deque([root])
    depth = 0

    while queue:
        depth += 1
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

    return depth


# Test cases
if __name__ == "__main__":
    # Example 1: root = [3,9,20,null,null,15,7] -> depth = 3
    #     3
    #    / \
    #   9  20
    #      / \
    #     15  7
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20, TreeNode(15), TreeNode(7))

    print(f"Max depth (recursive): {max_depth_recursive(root)}")  # 3
    print(f"Max depth (BFS): {max_depth_bfs(root)}")  # 3

    # Example 2: root = [1,null,2] -> depth = 2
    root2 = TreeNode(1, None, TreeNode(2))
    print(f"Max depth (recursive): {max_depth_recursive(root2)}")  # 2

    # Example 3: Empty tree -> depth = 0
    print(f"Empty tree depth: {max_depth_recursive(None)}")  # 0

    # Example 4: Single node -> depth = 1
    print(f"Single node depth: {max_depth_recursive(TreeNode(1))}")  # 1

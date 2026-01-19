"""
Maximum Path Sum in Binary Tree

Given the root of a binary tree, return the maximum path sum of any non-empty path.
A path is any sequence of nodes from some starting node to any node in the tree
along the parent-child connections.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def max_path_sum(root):
    """
    DFS approach tracking max path sum with and without split.
    TC: O(n), SC: O(n)
    """
    max_sum = [float('-inf')]
    
    def dfs(node):
        if not node:
            return 0
        
        # Get max path sum from left and right subtrees (ignore negative paths)
        left_max = max(0, dfs(node.left))
        right_max = max(0, dfs(node.right))
        
        # Max path sum with split (path goes through current node)
        max_sum[0] = max(max_sum[0], node.value + left_max + right_max)
        
        # Max path sum without split (can only go one direction)
        return node.value + max(left_max, right_max)
    
    dfs(root)
    return max_sum[0]


# Test cases
if __name__ == "__main__":
    # Test case 1: [1, 2, 3]
    root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    print(f"Max path sum: {max_path_sum(root1)}")  # 6
    
    # Test case 2: [-20, 10, 20, None, None, 15, 10, -10]
    root2 = TreeNode(-20)
    root2.left = TreeNode(10)
    root2.right = TreeNode(20)
    root2.right.left = TreeNode(15)
    root2.right.right = TreeNode(10)
    root2.right.left.left = TreeNode(-10)
    print(f"Max path sum: {max_path_sum(root2)}")  # 45

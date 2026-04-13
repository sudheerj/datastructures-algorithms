"""
Maximum Path Sum in Binary Tree

Find the maximum path sum in a binary tree. A path is any sequence
of nodes from any node to any other node (not necessarily root to leaf).

Time Complexity: O(n)
Space Complexity: O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def max_path_sum(root):
    """
    DFS approach tracking global max.
    TC: O(n), SC: O(h)
    """
    max_sum = [float('-inf')]

    def dfs(node):
        if not node:
            return 0

        left_gain = max(dfs(node.left), 0)
        right_gain = max(dfs(node.right), 0)

        # Path through current node
        current_path = node.val + left_gain + right_gain
        max_sum[0] = max(max_sum[0], current_path)

        # Return max gain from this node to parent
        return node.val + max(left_gain, right_gain)

    dfs(root)
    return max_sum[0]


# Test cases
if __name__ == "__main__":
    # Example 1: root = [1,2,3] -> 6 (path: 2 -> 1 -> 3)
    #   1
    #  / \
    # 2   3
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    print(f"Max path sum [1,2,3]: {max_path_sum(root)}")  # 6

    # Example 2: root = [-10,9,20,null,null,15,7] -> 42 (path: 15 -> 20 -> 7)
    #     -10
    #     / \
    #    9  20
    #       / \
    #      15  7
    root2 = TreeNode(-10)
    root2.left = TreeNode(9)
    root2.right = TreeNode(20, TreeNode(15), TreeNode(7))
    print(f"Max path sum [-10,9,20,null,null,15,7]: {max_path_sum(root2)}")  # 42

    # Example 3: Single negative node root = [-3] -> -3
    print(f"Single negative node: {max_path_sum(TreeNode(-3))}")  # -3

    # Example 4: root = [2,-1] -> 2
    root4 = TreeNode(2, TreeNode(-1))
    print(f"Max path sum [2,-1]: {max_path_sum(root4)}")  # 2

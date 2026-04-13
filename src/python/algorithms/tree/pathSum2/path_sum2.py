"""
Path Sum II

Given the root of a binary tree and an integer targetSum, return all
root-to-leaf paths where the sum of the node values equals targetSum.

Time Complexity: O(n^2)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def path_sum(root, target_sum):
    """
    DFS + Backtracking approach collecting all root-to-leaf paths matching target.
    TC: O(n^2), SC: O(n)
    """
    result = []

    def dfs(node, current_sum, curr_path):
        if not node:
            return

        curr_path.append(node.value)
        current_sum += node.value

        if node.left is None and node.right is None and current_sum == target_sum:
            result.append(list(curr_path))

        dfs(node.left, current_sum, curr_path)
        dfs(node.right, current_sum, curr_path)

        curr_path.pop()  # backtrack

    dfs(root, 0, [])
    return result


# Test cases
if __name__ == "__main__":
    # Test 1: Normal tree with multiple valid paths
    #         5
    #        / \
    #       4   8
    #      /   / \
    #     11  13   4
    #    / \      / \
    #   7   2    5   1
    root1 = TreeNode(5)
    root1.left = TreeNode(4)
    root1.right = TreeNode(8)
    root1.left.left = TreeNode(11)
    root1.right.left = TreeNode(13)
    root1.right.right = TreeNode(4)
    root1.left.left.left = TreeNode(7)
    root1.left.left.right = TreeNode(2)
    root1.right.right.left = TreeNode(5)
    root1.right.right.right = TreeNode(1)
    print(f"Test 1 (targetSum=22): {path_sum(root1, 22)}")  # [[5,4,11,2],[5,8,4,5]]

    # Test 2: Simple tree with no valid path
    root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)
    print(f"Test 2 (targetSum=5): {path_sum(root2, 5)}")  # []

    # Test 3: Single node matching target
    root3 = TreeNode(1)
    print(f"Test 3 (targetSum=1): {path_sum(root3, 1)}")  # [[1]]

    # Test 4: Single node not matching target
    print(f"Test 4 (targetSum=2): {path_sum(root3, 2)}")  # []

    # Test 5: Null tree
    print(f"Test 5 (null tree, targetSum=0): {path_sum(None, 0)}")  # []

    # Test 6: Tree with negative values (-2 -> -3 = -5)
    root6 = TreeNode(-2)
    root6.right = TreeNode(-3)
    print(f"Test 6 (targetSum=-5): {path_sum(root6, -5)}")  # [[-2,-3]]

    # Test 7: Multiple leaves, only one path valid (1->2 = 3)
    print(f"Test 7 (targetSum=3): {path_sum(root2, 3)}")  # [[1,2]]

    # Test 8: All root-to-leaf paths valid
    root8 = TreeNode(1)
    root8.left = TreeNode(2)
    root8.right = TreeNode(2)
    print(f"Test 8 (targetSum=3): {path_sum(root8, 3)}")  # [[1,2],[1,2]]

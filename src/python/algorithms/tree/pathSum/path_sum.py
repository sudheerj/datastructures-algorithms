"""
Path Sum

Given the root of a binary tree and an integer targetSum, return true if the
tree has a root-to-leaf path such that adding up all the values along the path
equals targetSum.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def has_path_sum(root, target_sum):
    """
    DFS approach tracking cumulative sum along root-to-leaf paths.
    TC: O(n), SC: O(n)
    """
    def dfs(node, curr_sum):
        if not node:
            return False

        curr_sum += node.value

        if node.left is None and node.right is None:
            return curr_sum == target_sum

        return dfs(node.left, curr_sum) or dfs(node.right, curr_sum)

    return dfs(root, 0)


# Test cases
if __name__ == "__main__":
    # Test 1: Normal tree with valid path sum (5->4->11->2 = 22)
    root1 = TreeNode(5)
    root1.left = TreeNode(4)
    root1.right = TreeNode(8)
    root1.left.left = TreeNode(11)
    root1.right.left = TreeNode(13)
    root1.right.right = TreeNode(4)
    root1.left.left.left = TreeNode(7)
    root1.left.left.right = TreeNode(2)
    root1.right.right.right = TreeNode(1)
    print(f"Test 1 (targetSum=22): {has_path_sum(root1, 22)}")  # True

    # Test 2: Simple tree with no valid path
    root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)
    print(f"Test 2 (targetSum=5): {has_path_sum(root2, 5)}")  # False

    # Test 3: Single node matching target
    root3 = TreeNode(1)
    print(f"Test 3 (targetSum=1): {has_path_sum(root3, 1)}")  # True

    # Test 4: Single node not matching target
    print(f"Test 4 (targetSum=2): {has_path_sum(root3, 2)}")  # False

    # Test 5: Null tree
    print(f"Test 5 (null tree, targetSum=0): {has_path_sum(None, 0)}")  # False

    # Test 6: Tree with negative values (-2 -> -3 = -5)
    root6 = TreeNode(-2)
    root6.right = TreeNode(-3)
    print(f"Test 6 (targetSum=-5): {has_path_sum(root6, -5)}")  # True

    # Test 7: Path sum equals 0 (1 -> -1 = 0)
    root7 = TreeNode(1)
    root7.left = TreeNode(-1)
    print(f"Test 7 (targetSum=0): {has_path_sum(root7, 0)}")  # True

    # Test 8: Left path valid (1->2 = 3)
    print(f"Test 8 (targetSum=3): {has_path_sum(root2, 3)}")  # True

    # Test 9: Right path valid (1->3 = 4)
    print(f"Test 9 (targetSum=4): {has_path_sum(root2, 4)}")  # True

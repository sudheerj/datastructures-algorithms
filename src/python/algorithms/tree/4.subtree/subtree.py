"""
Subtree of Another Tree

Given roots of two trees, check if the second tree is a subtree of the first.

Time Complexity: O(m * n)
Space Complexity: O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_subtree(root, sub_root):
    """
    Check if sub_root is a subtree of root.
    TC: O(m * n), SC: O(h)
    """
    if not sub_root:
        return True
    if not root:
        return False

    if is_same_tree(root, sub_root):
        return True

    return is_subtree(root.left, sub_root) or is_subtree(root.right, sub_root)


def is_same_tree(p, q):
    """Helper to check if two trees are identical."""
    if not p and not q:
        return True
    if not p or not q:
        return False
    if p.val != q.val:
        return False

    return is_same_tree(p.left, q.left) and is_same_tree(p.right, q.right)


# Test cases
if __name__ == "__main__":
    # Example 1: root = [3,4,5,1,2], subRoot = [4,1,2] -> True
    #     3
    #    / \
    #   4   5       4
    #  / \         / \
    # 1   2       1   2
    root = TreeNode(3)
    root.left = TreeNode(4, TreeNode(1), TreeNode(2))
    root.right = TreeNode(5)
    sub_root = TreeNode(4, TreeNode(1), TreeNode(2))
    print(f"Is subtree: {is_subtree(root, sub_root)}")  # True

    # Example 2: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2] -> False
    root2 = TreeNode(3)
    root2.left = TreeNode(4, TreeNode(1), TreeNode(2, TreeNode(0)))
    root2.right = TreeNode(5)
    sub_root2 = TreeNode(4, TreeNode(1), TreeNode(2))
    print(f"Not a subtree (extra node): {is_subtree(root2, sub_root2)}")  # False

    # Example 3: Empty subRoot -> True
    print(f"Empty subtree: {is_subtree(root, None)}")  # True

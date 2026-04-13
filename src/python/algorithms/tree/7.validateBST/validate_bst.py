"""
Validate Binary Search Tree

Determine if a binary tree is a valid BST.

Time Complexity: O(n)
Space Complexity: O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_valid_bst(root):
    """
    Recursive approach with valid range tracking.
    TC: O(n), SC: O(h)
    """
    def validate(node, min_val, max_val):
        if not node:
            return True

        if node.val <= min_val or node.val >= max_val:
            return False

        return (validate(node.left, min_val, node.val) and
                validate(node.right, node.val, max_val))

    return validate(root, float('-inf'), float('inf'))


def is_valid_bst_inorder(root):
    """
    Inorder traversal approach - BST inorder produces sorted sequence.
    TC: O(n), SC: O(h)
    """
    prev = [float('-inf')]

    def inorder(node):
        if not node:
            return True

        if not inorder(node.left):
            return False

        if node.val <= prev[0]:
            return False
        prev[0] = node.val

        return inorder(node.right)

    return inorder(root)


def is_valid_bst_iterative(root):
    """
    Iterative inorder traversal using stack.
    TC: O(n), SC: O(h)
    """
    stack = []
    prev = float('-inf')
    current = root

    while stack or current:
        while current:
            stack.append(current)
            current = current.left

        current = stack.pop()

        if current.val <= prev:
            return False
        prev = current.val

        current = current.right

    return True


# Test cases
if __name__ == "__main__":
    # Example 1: root = [2,1,3] -> True
    #   2
    #  / \
    # 1   3
    root = TreeNode(2, TreeNode(1), TreeNode(3))
    print(f"Valid BST [2,1,3]: {is_valid_bst(root)}")  # True

    # Example 2: root = [5,1,4,null,null,3,6] -> False
    #     5
    #    / \
    #   1   4
    #      / \
    #     3   6
    root2 = TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6)))
    print(f"Invalid BST [5,1,4,null,null,3,6]: {is_valid_bst(root2)}")  # False

    # Example 3: root = [5,4,6,null,null,3,7] -> False (3 < 5 but in right subtree)
    root3 = TreeNode(5, TreeNode(4), TreeNode(6, TreeNode(3), TreeNode(7)))
    print(f"Invalid BST (inorder): {is_valid_bst_inorder(root3)}")  # False

    # Example 4: Single node -> True
    print(f"Single node: {is_valid_bst_iterative(TreeNode(1))}")  # True

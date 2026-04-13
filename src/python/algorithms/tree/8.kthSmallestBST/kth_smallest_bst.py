"""
Kth Smallest Element in BST

Given root of a BST and integer k, return the kth smallest value.

Time Complexity: O(h + k)
Space Complexity: O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def kth_smallest_recursive(root, k):
    """
    Recursive inorder traversal approach.
    TC: O(h + k), SC: O(h)
    """
    count = [0]
    result = [0]

    def inorder(node):
        if not node:
            return

        inorder(node.left)

        count[0] += 1
        if count[0] == k:
            result[0] = node.val
            return

        inorder(node.right)

    inorder(root)
    return result[0]


def kth_smallest_iterative(root, k):
    """
    Iterative inorder traversal using stack.
    TC: O(h + k), SC: O(h)
    """
    stack = []
    current = root

    while stack or current:
        while current:
            stack.append(current)
            current = current.left

        current = stack.pop()
        k -= 1

        if k == 0:
            return current.val

        current = current.right


# Test cases
if __name__ == "__main__":
    # Example 1: root = [3,1,4,null,2], k = 1 -> 1
    #     3
    #    / \
    #   1   4
    #    \
    #     2
    root = TreeNode(3, TreeNode(1, None, TreeNode(2)), TreeNode(4))
    print(f"1st smallest: {kth_smallest_recursive(root, 1)}")  # 1
    print(f"1st smallest (iterative): {kth_smallest_iterative(root, 1)}")  # 1

    # Example 2: root = [5,3,6,2,4,null,null,1], k = 3 -> 3
    #       5
    #      / \
    #     3   6
    #    / \
    #   2   4
    #  /
    # 1
    root2 = TreeNode(5)
    root2.left = TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4))
    root2.right = TreeNode(6)
    print(f"3rd smallest: {kth_smallest_recursive(root2, 3)}")  # 3
    print(f"3rd smallest (iterative): {kth_smallest_iterative(root2, 3)}")  # 3

    # Example 3: k = 5 (5th smallest in above tree)
    print(f"5th smallest: {kth_smallest_iterative(root2, 5)}")  # 5

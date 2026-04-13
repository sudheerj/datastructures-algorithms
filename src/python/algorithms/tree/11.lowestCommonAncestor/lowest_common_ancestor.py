"""
Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes.

Time Complexity: O(h)
Space Complexity: O(h) recursive, O(1) iterative
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def lowest_common_ancestor_recursive(root, p, q):
    """
    Recursive approach.
    TC: O(h), SC: O(h)
    """
    if p.val < root.val and q.val < root.val:
        return lowest_common_ancestor_recursive(root.left, p, q)
    elif p.val > root.val and q.val > root.val:
        return lowest_common_ancestor_recursive(root.right, p, q)
    else:
        return root


def lowest_common_ancestor_iterative(root, p, q):
    """
    Iterative approach.
    TC: O(h), SC: O(1)
    """
    while root:
        if p.val < root.val and q.val < root.val:
            root = root.left
        elif p.val > root.val and q.val > root.val:
            root = root.right
        else:
            return root
    
    return None


# Test cases
if __name__ == "__main__":
    #       5
    #      / \
    #     1   8
    #    / \ / \
    #   0  2 7  9
    root = TreeNode(5)
    root.left = TreeNode(1, TreeNode(0), TreeNode(2))
    root.right = TreeNode(8, TreeNode(7), TreeNode(9))

    # Test 1: Nodes in left subtree
    result1 = lowest_common_ancestor_recursive(root, root.left.left, root.left.right)
    print(f"Test 1 (Recursive): LCA of 0 and 2 = {result1.val}")  # 1

    # Test 2: Nodes on opposite sides
    result2 = lowest_common_ancestor_iterative(root, root.left, root.right)
    print(f"Test 2 (Iterative): LCA of 1 and 8 = {result2.val}")  # 5

    # Test 3: One node is ancestor of the other
    result3 = lowest_common_ancestor_recursive(root, root.right, root.right.right)
    print(f"Test 3 (Recursive): LCA of 8 and 9 = {result3.val}")  # 8

    # Test 4: Nodes in right subtree
    result4 = lowest_common_ancestor_iterative(root, root.right.left, root.right.right)
    print(f"Test 4 (Iterative): LCA of 7 and 9 = {result4.val}")  # 8

    # Test 5: Root is the LCA
    result5 = lowest_common_ancestor_recursive(root, root.left.left, root.right.right)
    print(f"Test 5 (Recursive): LCA of 0 and 9 = {result5.val}")  # 5

    # Test 6: Node with itself
    result6 = lowest_common_ancestor_iterative(root, root.left, root.left)
    print(f"Test 6 (Iterative): LCA of 1 and 1 = {result6.val}")  # 1

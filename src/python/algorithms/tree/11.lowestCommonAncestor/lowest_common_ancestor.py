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


# Test case
if __name__ == "__main__":
    #         6
    #        / \
    #       2   8
    #      / \ / \
    #     0  4 7  9
    #       / \
    #      3   5
    root = TreeNode(6)
    root.left = TreeNode(2, TreeNode(0), TreeNode(4, TreeNode(3), TreeNode(5)))
    root.right = TreeNode(8, TreeNode(7), TreeNode(9))
    
    p = root.left  # node 2
    q = root.right  # node 8
    
    lca = lowest_common_ancestor_iterative(root, p, q)
    print(f"LCA of {p.val} and {q.val}: {lca.val}")  # 6

"""
Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def build_tree(preorder, inorder):
    """
    Recursive approach with hash map for O(1) inorder lookup.
    TC: O(n), SC: O(n)
    """
    inorder_map = {val: idx for idx, val in enumerate(inorder)}
    pre_idx = [0]

    def helper(left, right):
        if left > right:
            return None

        root_val = preorder[pre_idx[0]]
        pre_idx[0] += 1

        root = TreeNode(root_val)
        mid = inorder_map[root_val]

        root.left = helper(left, mid - 1)
        root.right = helper(mid + 1, right)

        return root

    return helper(0, len(inorder) - 1)


def build_tree_simple(preorder, inorder):
    """
    Simple recursive approach using list slicing.
    TC: O(n^2), SC: O(n^2) due to slicing
    """
    if not preorder or not inorder:
        return None

    root = TreeNode(preorder[0])
    mid = inorder.index(preorder[0])

    root.left = build_tree_simple(preorder[1:mid + 1], inorder[:mid])
    root.right = build_tree_simple(preorder[mid + 1:], inorder[mid + 1:])

    return root


def tree_to_list(root):
    """Helper to convert tree to list (BFS) for printing."""
    if not root:
        return []
    from collections import deque
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
    return result


# Test cases
if __name__ == "__main__":
    # Example 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    # Output: [3,9,20,null,null,15,7]
    #     3
    #    / \
    #   9  20
    #      / \
    #     15  7
    preorder1 = [3, 9, 20, 15, 7]
    inorder1 = [9, 3, 15, 20, 7]
    root1 = build_tree(preorder1, inorder1)
    print(f"Build tree (optimized): {tree_to_list(root1)}")  # [3, 9, 20, 15, 7]

    root1_simple = build_tree_simple(preorder1, inorder1)
    print(f"Build tree (simple): {tree_to_list(root1_simple)}")  # [3, 9, 20, 15, 7]

    # Example 2: preorder = [-1], inorder = [-1]
    root2 = build_tree([-1], [-1])
    print(f"Single node: {tree_to_list(root2)}")  # [-1]

    # Example 3: preorder = [1,2,3], inorder = [3,2,1] (left-skewed)
    root3 = build_tree([1, 2, 3], [3, 2, 1])
    print(f"Left-skewed: {tree_to_list(root3)}")  # [1, 2, 3]

"""
Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder,
construct and return the binary tree.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def build_tree(preorder, inorder):
    """
    Build tree using preorder and inorder traversals.
    TC: O(n), SC: O(n)
    """
    if not preorder or not inorder or len(preorder) != len(inorder):
        return None
    
    # Create index map for O(1) lookup in inorder
    inorder_map = {val: idx for idx, val in enumerate(inorder)}
    
    def helper(pre_start, pre_end, in_start, in_end):
        if pre_start > pre_end or in_start > in_end:
            return None
        
        root_val = preorder[pre_start]
        root = TreeNode(root_val)
        
        in_root_idx = inorder_map[root_val]
        left_size = in_root_idx - in_start
        
        root.left = helper(
            pre_start + 1,
            pre_start + left_size,
            in_start,
            in_root_idx - 1
        )
        root.right = helper(
            pre_start + left_size + 1,
            pre_end,
            in_root_idx + 1,
            in_end
        )
        
        return root
    
    return helper(0, len(preorder) - 1, 0, len(inorder) - 1)


def print_tree_preorder(root):
    """Helper to print tree in preorder."""
    if not root:
        return
    print(root.value, end=" ")
    print_tree_preorder(root.left)
    print_tree_preorder(root.right)


def print_tree_inorder(root):
    """Helper to print tree in inorder."""
    if not root:
        return
    print_tree_inorder(root.left)
    print(root.value, end=" ")
    print_tree_inorder(root.right)


# Test cases
if __name__ == "__main__":
    preorder = [1, 2, 4, 5, 3, 6, 7]
    inorder = [4, 2, 5, 1, 6, 3, 7]
    
    root = build_tree(preorder, inorder)
    
    print(f"Preorder: {preorder}")
    print(f"Inorder: {inorder}")
    print("Reconstructed tree preorder: ", end="")
    print_tree_preorder(root)
    print()
    print("Reconstructed tree inorder: ", end="")
    print_tree_inorder(root)
    print()

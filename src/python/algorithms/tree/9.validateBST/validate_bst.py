"""
Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

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
    Recursive approach with bounds.
    TC: O(n), SC: O(h)
    """
    def validate(node, low=float('-inf'), high=float('inf')):
        if not node:
            return True
        
        if node.val <= low or node.val >= high:
            return False
        
        return (validate(node.left, low, node.val) and 
                validate(node.right, node.val, high))
    
    return validate(root)


def is_valid_bst_inorder(root):
    """
    In-order traversal approach.
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


# Test case
if __name__ == "__main__":
    # Valid BST: [2, 1, 3]
    valid_root = TreeNode(2, TreeNode(1), TreeNode(3))
    
    # Invalid BST: [5, 1, 4, null, null, 3, 6]
    invalid_root = TreeNode(5)
    invalid_root.left = TreeNode(1)
    invalid_root.right = TreeNode(4, TreeNode(3), TreeNode(6))
    
    print(f"Valid BST? {is_valid_bst(valid_root)}")    # True
    print(f"Invalid BST? {is_valid_bst(invalid_root)}")  # False

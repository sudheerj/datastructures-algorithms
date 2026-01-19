"""
Subtree of Another Tree

Given the roots of two binary trees root and subRoot,
return true if there is a subtree of root with the same structure
and node values of subRoot and false otherwise.

Time Complexity: O(m * n) where m, n are number of nodes in root and subRoot
Space Complexity: O(m) for recursion stack
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def is_subtree(root, sub_root):
    """
    DFS approach checking if subRoot matches any subtree.
    TC: O(m * n), SC: O(m)
    """
    if not sub_root:
        return True
    if not root:
        return False
    
    return (is_same_tree(root, sub_root) or 
            is_subtree(root.left, sub_root) or 
            is_subtree(root.right, sub_root))


def is_same_tree(root1, root2):
    """Check if two trees are identical."""
    if not root1 and not root2:
        return True
    if not root1 or not root2 or root1.value != root2.value:
        return False
    
    return (is_same_tree(root1.left, root2.left) and 
            is_same_tree(root1.right, root2.right))


# Test cases
if __name__ == "__main__":
    # Create main tree
    root1 = TreeNode(0)
    root1.left = TreeNode(1)
    root1.right = TreeNode(2)
    root1.left.left = TreeNode(3)
    root1.left.right = TreeNode(4)
    root1.right.left = TreeNode(5)
    root1.right.right = TreeNode(6)
    root1.right.right.left = TreeNode(7)
    
    # Create subtree that exists
    root2 = TreeNode(1)
    root2.left = TreeNode(3)
    root2.right = TreeNode(4)
    
    # Create subtree that doesn't exist
    root3 = TreeNode(2)
    root3.left = TreeNode(5)
    root3.right = TreeNode(6)
    
    print(f"Is subtree (should be True): {is_subtree(root1, root2)}")
    print(f"Is subtree (should be False): {is_subtree(root1, root3)}")

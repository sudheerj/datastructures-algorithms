"""
Same Tree

Given the roots of two binary trees p and q, check if they are the same.

Time Complexity: O(n)
Space Complexity: O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_same_tree(p, q):
    """
    Recursive approach.
    TC: O(n), SC: O(h)
    """
    if not p and not q:
        return True
    if not p or not q:
        return False
    if p.val != q.val:
        return False
    
    return is_same_tree(p.left, q.left) and is_same_tree(p.right, q.right)


def is_same_tree_iterative(p, q):
    """
    Iterative approach using stack.
    TC: O(n), SC: O(n)
    """
    stack = [(p, q)]
    
    while stack:
        node1, node2 = stack.pop()
        
        if not node1 and not node2:
            continue
        if not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False
        
        stack.append((node1.left, node2.left))
        stack.append((node1.right, node2.right))
    
    return True


# Test case
if __name__ == "__main__":
    # Tree 1: [1, 2, 3]
    p = TreeNode(1, TreeNode(2), TreeNode(3))
    # Tree 2: [1, 2, 3]
    q = TreeNode(1, TreeNode(2), TreeNode(3))
    
    print(f"Are trees the same? {is_same_tree(p, q)}")  # True

"""
Kth Smallest Element in a BST

Given the root of a binary search tree and an integer k,
return the kth smallest value (1-indexed) of all values in the BST.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, value=0):
        self.value = value
        self.left = None
        self.right = None


def kth_smallest_iterative(root, k):
    """
    Iterative inorder traversal using stack.
    TC: O(n), SC: O(n)
    """
    if not root or k <= 0:
        return None
    
    stack = []
    curr = root
    
    while curr or stack:
        while curr:
            stack.append(curr)
            curr = curr.left
        
        curr = stack.pop()
        k -= 1
        
        if k == 0:
            return curr.value
        
        curr = curr.right
    
    return None


def kth_smallest_recursive(root, k):
    """
    Recursive inorder traversal.
    TC: O(n), SC: O(n)
    """
    if not root or k <= 0:
        return None
    
    result = []
    
    def inorder(node):
        if not node:
            return
        inorder(node.left)
        result.append(node.value)
        inorder(node.right)
    
    inorder(root)
    return result[k - 1] if k <= len(result) else None


# Test cases
if __name__ == "__main__":
    # Create BST: [5, 1, 8, 0, 2, 7, 9]
    root1 = TreeNode(5)
    root1.left = TreeNode(1)
    root1.right = TreeNode(8)
    root1.left.left = TreeNode(0)
    root1.left.right = TreeNode(2)
    root1.right.left = TreeNode(7)
    root1.right.right = TreeNode(9)
    
    print(f"3rd smallest (iterative): {kth_smallest_iterative(root1, 3)}")  # 2
    print(f"3rd smallest (recursive): {kth_smallest_recursive(root1, 3)}")  # 2
    
    # Create BST: [2, 1, 3]
    root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)
    
    print(f"2nd smallest (iterative): {kth_smallest_iterative(root2, 2)}")  # 2
    print(f"2nd smallest (recursive): {kth_smallest_recursive(root2, 2)}")  # 2
    print(f"10th smallest (out of range): {kth_smallest_iterative(root2, 10)}")  # None

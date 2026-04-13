"""
Same Tree

Given roots of two binary trees, check if they are the same
(structurally identical with same node values).

Time Complexity: O(n)
Space Complexity: O(h)
"""

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_same_tree_recursive(p, q):
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

    return is_same_tree_recursive(p.left, q.left) and is_same_tree_recursive(p.right, q.right)


def is_same_tree_iterative(p, q):
    """
    Iterative approach using queue.
    TC: O(n), SC: O(n)
    """
    queue = deque([(p, q)])

    while queue:
        node1, node2 = queue.popleft()

        if not node1 and not node2:
            continue
        if not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False

        queue.append((node1.left, node2.left))
        queue.append((node1.right, node2.right))

    return True


# Test cases
if __name__ == "__main__":
    # Example 1: p = [1,2,3], q = [1,2,3] -> True
    p1 = TreeNode(1, TreeNode(2), TreeNode(3))
    q1 = TreeNode(1, TreeNode(2), TreeNode(3))
    print(f"Same trees [1,2,3] & [1,2,3]: {is_same_tree_recursive(p1, q1)}")  # True

    # Example 2: p = [1,2], q = [1,null,2] -> False
    p2 = TreeNode(1, TreeNode(2))
    q2 = TreeNode(1, None, TreeNode(2))
    print(f"Different structure: {is_same_tree_recursive(p2, q2)}")  # False

    # Example 3: p = [1,2,1], q = [1,1,2] -> False
    p3 = TreeNode(1, TreeNode(2), TreeNode(1))
    q3 = TreeNode(1, TreeNode(1), TreeNode(2))
    print(f"Different values: {is_same_tree_iterative(p3, q3)}")  # False

    # Example 4: Both empty -> True
    print(f"Both empty: {is_same_tree_recursive(None, None)}")  # True

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


def is_same_tree_iterative_dfs(p, q):
    """
    Iterative DFS approach using stack.
    TC: O(n), SC: O(h)
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


# Test cases
if __name__ == "__main__":
    # Test 1: Identical trees [0,1,2,3,4,5,6]
    p1 = TreeNode(0, TreeNode(1, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(5), TreeNode(6)))
    q1 = TreeNode(0, TreeNode(1, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(5), TreeNode(6)))
    print("Test 1 - Identical trees [0,1,2,3,4,5,6]:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p1, q1)}")        # True
    print(f"  Iterative BFS: {is_same_tree_iterative(p1, q1)}")        # True
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p1, q1)}")    # True

    # Test 2: Different values [1,2,3] vs [1,3,2]
    p2 = TreeNode(1, TreeNode(2), TreeNode(3))
    q2 = TreeNode(1, TreeNode(3), TreeNode(2))
    print("\nTest 2 - Different values [1,2,3] vs [1,3,2]:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p2, q2)}")        # False
    print(f"  Iterative BFS: {is_same_tree_iterative(p2, q2)}")        # False
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p2, q2)}")    # False

    # Test 3: Different structure [1,2] vs [1,null,2]
    p3 = TreeNode(1, TreeNode(2))
    q3 = TreeNode(1, None, TreeNode(2))
    print("\nTest 3 - Different structure [1,2] vs [1,null,2]:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p3, q3)}")        # False
    print(f"  Iterative BFS: {is_same_tree_iterative(p3, q3)}")        # False
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p3, q3)}")    # False

    # Test 4: Both empty
    print("\nTest 4 - Both empty (None, None):")
    print(f"  Recursive DFS: {is_same_tree_recursive(None, None)}")    # True
    print(f"  Iterative BFS: {is_same_tree_iterative(None, None)}")    # True
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(None, None)}")  # True

    # Test 5: One empty, one not
    p5 = TreeNode(1)
    print("\nTest 5 - One empty, one not:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p5, None)}")      # False
    print(f"  Iterative BFS: {is_same_tree_iterative(p5, None)}")      # False
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p5, None)}")  # False

    # Test 6: Single node, same value
    p6 = TreeNode(5)
    q6 = TreeNode(5)
    print("\nTest 6 - Single node, same value:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p6, q6)}")        # True
    print(f"  Iterative BFS: {is_same_tree_iterative(p6, q6)}")        # True
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p6, q6)}")    # True

    # Test 7: Single node, different values
    p7 = TreeNode(1)
    q7 = TreeNode(2)
    print("\nTest 7 - Single node, different values:")
    print(f"  Recursive DFS: {is_same_tree_recursive(p7, q7)}")        # False
    print(f"  Iterative BFS: {is_same_tree_iterative(p7, q7)}")        # False
    print(f"  Iterative DFS: {is_same_tree_iterative_dfs(p7, q7)}")    # False

"""
Binary Tree Vertical Order Traversal

Given the root of a binary tree, return the vertical order traversal
of its nodes' values (top to bottom, column by column).

Approach: BFS + Column Map
TC: O(n)  SC: O(n)
"""

from collections import deque, defaultdict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def binary_tree_vertical_order_traversal(root: TreeNode) -> list[list[int]]:
    if not root:
        return []

    col_map = defaultdict(list)
    queue = deque([(root, 0)])  # (node, col)
    min_col = max_col = 0

    while queue:
        node, col = queue.popleft()
        col_map[col].append(node.val)
        min_col = min(min_col, col)
        max_col = max(max_col, col)

        if node.left:
            queue.append((node.left, col - 1))
        if node.right:
            queue.append((node.right, col + 1))

    return [col_map[c] for c in range(min_col, max_col + 1)]


def build(vals: list) -> TreeNode | None:
    if not vals or vals[0] is None:
        return None
    root = TreeNode(vals[0])
    queue = deque([root])
    i = 1
    while queue and i < len(vals):
        node = queue.popleft()
        if i < len(vals) and vals[i] is not None:
            node.left = TreeNode(vals[i])
            queue.append(node.left)
        i += 1
        if i < len(vals) and vals[i] is not None:
            node.right = TreeNode(vals[i])
            queue.append(node.right)
        i += 1
    return root


if __name__ == "__main__":
    test_cases = [
        ([3, 9, 20, None, None, 15, 7], [[9], [3, 15], [20], [7]],    "[3,9,20,null,null,15,7]"),
        ([3, 9, 8, 4, 0, 1, 7],         [[4], [9], [3, 0, 1], [8], [7]], "[3,9,8,4,0,1,7]"),
        ([1],                            [[1]],                          "single node"),
        (None,                           [],                             "null"),
        ([1, 2, 3],                      [[2], [1], [3]],               "[1,2,3]"),
    ]

    for vals, expected, label in test_cases:
        root = build(vals) if vals is not None else None
        result = binary_tree_vertical_order_traversal(root)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result} (expected {expected})")

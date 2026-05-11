"""
Vertical Order Traversal of a Binary Tree (LeetCode 987)

For each node at (row, col): root=(0,0), left=(row+1,col-1), right=(row+1,col+1).
Group by column; within same column sort by (row, value).

Approach: BFS + sorted dict
TC: O(n log n)  SC: O(n)
"""

from collections import deque, defaultdict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def vertical_binary_tree_traversal(root: TreeNode) -> list[list[int]]:
    if not root:
        return []

    col_map = defaultdict(list)   # col -> [(row, val), ...]
    queue = deque([(root, 0, 0)]) # (node, row, col)

    while queue:
        node, row, col = queue.popleft()
        col_map[col].append((row, node.val))

        if node.left:
            queue.append((node.left, row + 1, col - 1))
        if node.right:
            queue.append((node.right, row + 1, col + 1))

    result = []
    for col in sorted(col_map):
        result.append([val for _, val in sorted(col_map[col])])
    return result


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
        ([3, 9, 20, None, None, 15, 7], [[9], [3, 15], [20], [7]],     "[3,9,20,null,null,15,7]"),
        ([1, 2, 3, 4, 5, 6, 7],         [[4], [2], [1, 5, 6], [3], [7]], "[1,2,3,4,5,6,7]"),
        ([1, 2, 3, 4, 6, 5, 7],         [[4], [2], [1, 5, 6], [3], [7]], "[1,2,3,4,6,5,7] (tie-break by val)"),
        ([1],                            [[1]],                           "single node"),
        (None,                           [],                              "null"),
    ]

    for vals, expected, label in test_cases:
        root = build(vals) if vals is not None else None
        result = vertical_binary_tree_traversal(root)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result} (expected {expected})")

# Cousins in Binary Tree (LC 993)
# BFS: TC O(n) SC O(n) | DFS: TC O(n) SC O(h)

from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


# Approach 1: BFS
def is_cousins(root: Optional[TreeNode], x: int, y: int) -> bool:
    queue = deque([root])
    while queue:
        found_x = found_y = False
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.value == x: found_x = True
            if node.value == y: found_y = True
            if node.left and node.right:
                lv, rv = node.left.value, node.right.value
                if (lv == x and rv == y) or (lv == y and rv == x):
                    return False
            if node.left:  queue.append(node.left)
            if node.right: queue.append(node.right)
        if found_x and found_y: return True
        if found_x or  found_y: return False
    return False


# Approach 2: DFS
def is_cousins2(root: Optional[TreeNode], x: int, y: int) -> bool:
    info = {}  # value -> (depth, parent)

    def dfs(node, parent, depth):
        if not node: return
        if node.value == x or node.value == y:
            info[node.value] = (depth, parent)
        dfs(node.left,  node, depth + 1)
        dfs(node.right, node, depth + 1)

    dfs(root, None, 0)
    if x not in info or y not in info:
        return False
    dx, px = info[x]
    dy, py = info[y]
    return dx == dy and px is not py


if __name__ == "__main__":
    # t1: [1,2,3,4]
    t1 = TreeNode(1, TreeNode(2, TreeNode(4), None), TreeNode(3))
    # t2: [1,2,3,null,4,null,5]
    t2 = TreeNode(1, TreeNode(2, None, TreeNode(4)), TreeNode(3, None, TreeNode(5)))
    # t3: [1,2,3]
    t3 = TreeNode(1, TreeNode(2), TreeNode(3))
    # t4: [1,2,3,4,5,6,7]
    t4 = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)),
                     TreeNode(3, TreeNode(6), TreeNode(7)))

    test_cases = [
        (t1, 4, 3, False),
        (t2, 4, 5, True),
        (t3, 2, 3, False),
        (t4, 4, 7, True),
        (t4, 4, 5, False),
        (t4, 4, 6, True),
    ]

    for label, fn in [("BFS", is_cousins), ("DFS", is_cousins2)]:
        print(f"--- {label} ---")
        for root, x, y, expected in test_cases:
            result = fn(root, x, y)
            status = "PASS" if result == expected else "FAIL"
            print(f"[{status}] x={x} y={y} result={result} expected={expected}")

# Binary Tree Zigzag Level Order Traversal
# Return level-order traversal alternating left→right and right→left each level.
# TC: O(n), SC: O(n)

from collections import deque

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def zigzag_level_order(root: TreeNode) -> list[list[int]]:
    result = []
    if root is None:
        return result

    queue = deque([root])

    while queue:
        size = len(queue)
        level = [0] * size

        for i in range(size):
            node = queue.popleft()
            index = i if len(result) % 2 == 0 else size - i - 1
            level[index] = node.value

            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        result.append(level)

    return result


# Test cases
# Test 1: Full 3-level tree → [[1],[3,2],[4,5,6,7]]
root1 = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6), TreeNode(7)))
print('Test 1:', zigzag_level_order(root1))  # [[1],[3,2],[4,5,6,7]]

# Test 2: Single node → [[3]]
root2 = TreeNode(3)
print('Test 2:', zigzag_level_order(root2))  # [[3]]

# Test 3: None root → []
print('Test 3:', zigzag_level_order(None))  # []

# Test 4: Left-skewed with right child [1,2,null,null,3] → [[1],[2],[3]]
root4 = TreeNode(1)
root4.left = TreeNode(2)
root4.left.right = TreeNode(3)
print('Test 4:', zigzag_level_order(root4))  # [[1],[2],[3]]

# Test 5: 4-level tree → [[1],[3,2],[4,5],[7,6]]
root5 = TreeNode(1)
root5.left = TreeNode(2)
root5.right = TreeNode(3)
root5.left.left = TreeNode(4)
root5.right.right = TreeNode(5)
root5.left.left.left = TreeNode(6)
root5.left.left.right = TreeNode(7)
print('Test 5:', zigzag_level_order(root5))  # [[1],[3,2],[4,5],[7,6]]

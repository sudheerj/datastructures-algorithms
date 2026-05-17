# Diameter of Binary Tree
# Return the length (in edges) of the longest path between any two nodes.
# TC: O(n), SC: O(h)

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def diameter_of_binary_tree(root: TreeNode) -> int:
    diameter = 0

    def dfs(node: TreeNode) -> int:
        nonlocal diameter
        if node is None:
            return 0

        left_height = dfs(node.left)
        right_height = dfs(node.right)

        diameter = max(diameter, left_height + right_height)

        return 1 + max(left_height, right_height)

    dfs(root)
    return diameter


# Test cases
# Test 1: [1,2,3,4,5] → 3
root1 = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
print('Test 1:', diameter_of_binary_tree(root1))  # 3

# Test 2: [1,2] → 1
root2 = TreeNode(1, TreeNode(2))
print('Test 2:', diameter_of_binary_tree(root2))  # 1

# Test 3: single node → 0
root3 = TreeNode(1)
print('Test 3:', diameter_of_binary_tree(root3))  # 0

# Test 4: right-skewed [1,null,2,null,3,null,4] → 3
root4 = TreeNode(1)
root4.right = TreeNode(2)
root4.right.right = TreeNode(3)
root4.right.right.right = TreeNode(4)
print('Test 4:', diameter_of_binary_tree(root4))  # 3

# Test 5: diameter NOT through root → 4
root5 = TreeNode(1)
root5.left = TreeNode(2)
root5.left.left = TreeNode(3)
root5.left.right = TreeNode(4)
root5.left.left.left = TreeNode(5)
root5.left.right.right = TreeNode(6)
print('Test 5:', diameter_of_binary_tree(root5))  # 4

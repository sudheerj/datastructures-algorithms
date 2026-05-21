# Range Sum of BST
# Return the sum of all node values within the inclusive range [low, high].
# TC: O(n), SC: O(n)

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def range_sum(root: TreeNode, low: int, high: int) -> int:
    if root is None:
        return 0

    # Current value too large — only left subtree can have valid nodes
    if root.value > high:
        return range_sum(root.left, low, high)

    # Current value too small — only right subtree can have valid nodes
    if root.value < low:
        return range_sum(root.right, low, high)

    # Current value in range — add it and search both subtrees
    return root.value + range_sum(root.left, low, high) + range_sum(root.right, low, high)


# Test cases
# Test 1: [10,5,15,3,7,null,18], low=7, high=15 → 32
root1 = TreeNode(10)
root1.left = TreeNode(5)
root1.right = TreeNode(15)
root1.left.left = TreeNode(3)
root1.left.right = TreeNode(7)
root1.right.right = TreeNode(18)
print('Test 1:', range_sum(root1, 7, 15))  # 32

# Test 2: [10,5,15,3,7,13,18,1,null,6], low=6, high=10 → 23
root2 = TreeNode(10)
root2.left = TreeNode(5)
root2.right = TreeNode(15)
root2.left.left = TreeNode(3)
root2.left.right = TreeNode(7)
root2.right.left = TreeNode(13)
root2.right.right = TreeNode(18)
root2.left.left.left = TreeNode(1)
root2.left.right.left = TreeNode(6)
print('Test 2:', range_sum(root2, 6, 10))  # 23

# Test 3: Single node within range
root3 = TreeNode(5)
print('Test 3:', range_sum(root3, 1, 10))  # 5

# Test 4: Single node outside range
root4 = TreeNode(5)
print('Test 4:', range_sum(root4, 6, 10))  # 0

# Test 5: All nodes within range
root5 = TreeNode(10, TreeNode(5), TreeNode(15))
print('Test 5:', range_sum(root5, 1, 20))  # 30

# BST to Greater Sum Tree
# Replace each node's value with the sum of all values >= it in the BST.
# TC: O(n), SC: O(h)

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def convert_bst_to_greater_sum_tree(root: TreeNode) -> TreeNode:
    total = 0

    def dfs(node: TreeNode) -> None:
        nonlocal total
        if node is None:
            return

        dfs(node.right)       # visit larger values first

        total += node.value
        node.value = total

        dfs(node.left)        # visit smaller values last

    dfs(root)
    return root


def inorder(node: TreeNode) -> list[int]:
    if node is None:
        return []
    return inorder(node.left) + [node.value] + inorder(node.right)


# Test cases
# Test 1: [4,1,6,0,2,5,7] → inorder GST: [25,25,24,22,18,13,7]
root1 = TreeNode(4, TreeNode(1, TreeNode(0), TreeNode(2)), TreeNode(6, TreeNode(5), TreeNode(7)))
convert_bst_to_greater_sum_tree(root1)
print('Test 1:', inorder(root1))  # [25, 25, 24, 22, 18, 13, 7]

# Test 2: [2,1,3] → [6,5,3]
root2 = TreeNode(2, TreeNode(1), TreeNode(3))
convert_bst_to_greater_sum_tree(root2)
print('Test 2:', inorder(root2))  # [6, 5, 3]

# Test 3: single node [5] → [5]
root3 = TreeNode(5)
convert_bst_to_greater_sum_tree(root3)
print('Test 3:', inorder(root3))  # [5]

# Test 4: [3,2,4,1] → [10,9,7,4]
root4 = TreeNode(3, TreeNode(2, TreeNode(1), None), TreeNode(4))
convert_bst_to_greater_sum_tree(root4)
print('Test 4:', inorder(root4))  # [10, 9, 7, 4]

# Test 5: right-skewed [1,null,2,null,3] → [6,5,3]
root5 = TreeNode(1)
root5.right = TreeNode(2)
root5.right.right = TreeNode(3)
convert_bst_to_greater_sum_tree(root5)
print('Test 5:', inorder(root5))  # [6, 5, 3]

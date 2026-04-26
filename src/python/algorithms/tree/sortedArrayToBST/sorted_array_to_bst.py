class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def sortedArrayToBST(nums):
    def build(left, right):
        if left > right:
            return None
        mid = (left + right) // 2
        root = TreeNode(nums[mid])
        root.left = build(left, mid - 1)
        root.right = build(mid + 1, right)
        return root
    return build(0, len(nums) - 1)

def preorder(root):
    if not root:
        return []
    return [root.val] + preorder(root.left) + preorder(root.right)

if __name__ == "__main__":
    test_cases = [
        [],
        [0],
        [1, 2],
        [-10, -3, 0, 5, 9],
        [1, 2, 3, 4, 5, 6, 7]
    ]
    for i, arr in enumerate(test_cases, 1):
        print(f"Test case {i}: Input: {arr}")
        bst = sortedArrayToBST(arr)
        print("Preorder Output:", preorder(bst))

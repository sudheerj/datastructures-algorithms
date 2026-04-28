class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def generate_trees(n):
    if n == 0:
        return []
    def generate(left, right, memo):
        if left > right:
            return [None]
        if (left, right) in memo:
            return memo[(left, right)]
        result = []
        for root in range(left, right + 1):
            for left_tree in generate(left, root - 1, memo):
                for right_tree in generate(root + 1, right, memo):
                    node = TreeNode(root, left_tree, right_tree)
                    result.append(node)
        memo[(left, right)] = result
        return result
    return generate(1, n, {})

def preorder(root):
    if not root:
        return ['null']
    return [str(root.val)] + preorder(root.left) + preorder(root.right)

if __name__ == "__main__":
    test_cases = [0, 1, 2, 3]
    for i, n in enumerate(test_cases, 1):
        print(f"Test case {i}: n = {n}")
        trees = generate_trees(n)
        print("Total unique BSTs:", len(trees))
        for idx, root in enumerate(trees, 1):
            print(f"Tree {idx}: {' '.join(preorder(root))}")

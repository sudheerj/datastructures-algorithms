# Recover BST (LC 99)
# Inorder traversal  TC: O(n)  SC: O(h)

from typing import Optional


class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def recover_tree(root: Optional[TreeNode]) -> None:
    state = {"prev": None, "first": None, "second": None}

    def inorder(node):
        if not node:
            return
        inorder(node.left)
        if state["prev"] and state["prev"].value > node.value:
            if not state["first"]:
                state["first"] = state["prev"]
            state["second"] = node
        state["prev"] = node
        inorder(node.right)

    inorder(root)
    state["first"].value, state["second"].value = (
        state["second"].value, state["first"].value
    )


def inorder_list(root: Optional[TreeNode]) -> list:
    result = []
    def helper(node):
        if not node: return
        helper(node.left)
        result.append(node.value)
        helper(node.right)
    helper(root)
    return result


if __name__ == "__main__":
    test_cases = [
        # (root, expected_inorder)
        (TreeNode(1, TreeNode(3, None, TreeNode(2)), None), [1, 2, 3]),
        (TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2), None)), [1, 2, 3, 4]),
        (TreeNode(2, TreeNode(3), TreeNode(1)), [1, 2, 3]),
        (TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(5)),
                     TreeNode(6, TreeNode(3), TreeNode(7))), [1, 2, 3, 4, 5, 6, 7]),
    ]

    for root, expected in test_cases:
        recover_tree(root)
        result = inorder_list(root)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")

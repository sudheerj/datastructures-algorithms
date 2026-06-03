class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class ConvertBSTToDLL:
    def __init__(self):
        self.head = None
        self.prev = None

    def convert_tree_to_dll(self, root):
        if root is None:
            return None
        self._dfs(root)
        return self.head

    def _dfs(self, node):
        if node is None:
            return
        self._dfs(node.left)
        if self.prev is None:
            self.head = node
        else:
            self.prev.right = node
            node.left = self.prev
        self.prev = node
        self._dfs(node.right)


def build_bst(vals):
    def insert(root, val):
        if root is None:
            return Node(val)
        if val < root.data:
            root.left = insert(root.left, val)
        else:
            root.right = insert(root.right, val)
        return root

    root = None
    for v in vals:
        root = insert(root, v)
    return root


def dll_to_list(head):
    result = []
    cur = head
    while cur:
        result.append(cur.data)
        cur = cur.right
    return result


if __name__ == "__main__":
    tests = [
        ([4],             [4]),
        ([4,2,6,1,3,5,7], [1,2,3,4,5,6,7]),
        ([3,2,1],         [1,2,3]),
        ([1,2,3],         [1,2,3]),
        ([5,3,7,2,4],     [2,3,4,5,7]),
    ]

    for i, (vals, expected) in enumerate(tests, 1):
        root = build_bst(vals)
        sol = ConvertBSTToDLL()
        result_node = sol.convert_tree_to_dll(root)
        result = dll_to_list(result_node)
        status = "PASS" if result == expected else "FAIL"
        print(f"{status} test {i}: result={result} expected={expected}")

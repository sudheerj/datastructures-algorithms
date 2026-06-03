// Recover BST (LC 99)
// Inorder traversal  TC: O(n)  SC: O(h)

class TreeNode {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

function recoverTree(root) {
    let prev = null, first = null, second = null;

    function inorder(node) {
        if (!node) return;
        inorder(node.left);
        if (prev && prev.value > node.value) {
            if (!first) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }

    inorder(root);
    [first.value, second.value] = [second.value, first.value];
}

function inorderList(root) {
    const result = [];
    function helper(node) {
        if (!node) return;
        helper(node.left);
        result.push(node.value);
        helper(node.right);
    }
    helper(root);
    return result;
}

function runTests() {
    const tests = [
        {
            root: new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null),
            expected: [1, 2, 3],
        },
        {
            root: new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null)),
            expected: [1, 2, 3, 4],
        },
        {
            root: new TreeNode(2, new TreeNode(3), new TreeNode(1)),
            expected: [1, 2, 3],
        },
        {
            root: new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(5)),
                                  new TreeNode(6, new TreeNode(3), new TreeNode(7))),
            expected: [1, 2, 3, 4, 5, 6, 7],
        },
    ];

    for (const { root, expected } of tests) {
        recoverTree(root);
        const result = inorderList(root);
        const pass = JSON.stringify(result) === JSON.stringify(expected);
        console.log(`[${pass ? "PASS" : "FAIL"}] result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

runTests();

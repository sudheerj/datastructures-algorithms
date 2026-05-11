/**
 * Binary Tree Vertical Order Traversal
 *
 * Given the root of a binary tree, return the vertical order traversal
 * of its nodes' values (top to bottom, column by column).
 *
 * Approach: BFS + Column Map
 * TC: O(n)  SC: O(n)
 */

class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function binaryTreeVerticalOrderTraversal(root) {
    if (!root) return [];

    const colMap = new Map();
    const queue = [[root, 0]]; // [node, col]
    let minCol = 0, maxCol = 0;

    while (queue.length > 0) {
        const [node, col] = queue.shift();

        if (!colMap.has(col)) colMap.set(col, []);
        colMap.get(col).push(node.val);

        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        if (node.left)  queue.push([node.left,  col - 1]);
        if (node.right) queue.push([node.right, col + 1]);
    }

    const result = [];
    for (let c = minCol; c <= maxCol; c++) {
        result.push(colMap.get(c));
    }
    return result;
}

function build(vals) {
    if (!vals || vals.length === 0 || vals[0] === null) return null;
    const root = new TreeNode(vals[0]);
    const queue = [root];
    let i = 1;
    while (queue.length > 0 && i < vals.length) {
        const node = queue.shift();
        if (i < vals.length && vals[i] !== null) {
            node.left = new TreeNode(vals[i]);
            queue.push(node.left);
        }
        i++;
        if (i < vals.length && vals[i] !== null) {
            node.right = new TreeNode(vals[i]);
            queue.push(node.right);
        }
        i++;
    }
    return root;
}

const testCases = [
    { vals: [3, 9, 20, null, null, 15, 7], expected: [[9],[3,15],[20],[7]],    label: "[3,9,20,null,null,15,7]" },
    { vals: [3, 9, 8, 4, 0, 1, 7],         expected: [[4],[9],[3,0,1],[8],[7]], label: "[3,9,8,4,0,1,7]" },
    { vals: [1],                            expected: [[1]],                    label: "single node" },
    { vals: null,                           expected: [],                       label: "null" },
    { vals: [1, 2, 3],                      expected: [[2],[1],[3]],           label: "[1,2,3]" },
];

testCases.forEach(({ vals, expected, label }) => {
    const root = vals ? build(vals) : null;
    const result = binaryTreeVerticalOrderTraversal(root);
    const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${JSON.stringify(result)} (expected ${JSON.stringify(expected)})`);
});

/**
 * Vertical Order Traversal of a Binary Tree (LeetCode 987)
 *
 * For each node at (row, col): root=(0,0), left=(row+1,col-1), right=(row+1,col+1).
 * Group by column; within same column sort by (row, value).
 *
 * Approach: BFS + Map sorted by column
 * TC: O(n log n)  SC: O(n)
 */

class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function verticalBinaryTreeTraversal(root) {
    if (!root) return [];

    const colMap = new Map(); // col -> [[row, val], ...]
    const queue = [[root, 0, 0]]; // [node, row, col]

    while (queue.length > 0) {
        const [node, row, col] = queue.shift();

        if (!colMap.has(col)) colMap.set(col, []);
        colMap.get(col).push([row, node.val]);

        if (node.left)  queue.push([node.left,  row + 1, col - 1]);
        if (node.right) queue.push([node.right, row + 1, col + 1]);
    }

    const sortedCols = [...colMap.keys()].sort((a, b) => a - b);
    return sortedCols.map(col => {
        const entries = colMap.get(col).sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]);
        return entries.map(([, val]) => val);
    });
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
    { vals: [3, 9, 20, null, null, 15, 7], expected: [[9],[3,15],[20],[7]],       label: "[3,9,20,null,null,15,7]" },
    { vals: [1, 2, 3, 4, 5, 6, 7],         expected: [[4],[2],[1,5,6],[3],[7]],   label: "[1,2,3,4,5,6,7]" },
    { vals: [1, 2, 3, 4, 6, 5, 7],         expected: [[4],[2],[1,5,6],[3],[7]],   label: "[1,2,3,4,6,5,7] (tie-break by val)" },
    { vals: [1],                            expected: [[1]],                       label: "single node" },
    { vals: null,                           expected: [],                          label: "null" },
];

testCases.forEach(({ vals, expected, label }) => {
    const root = vals ? build(vals) : null;
    const result = verticalBinaryTreeTraversal(root);
    const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${JSON.stringify(result)} (expected ${JSON.stringify(expected)})`);
});

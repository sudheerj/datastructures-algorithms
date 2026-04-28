class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function generateTrees(n) {
    if (n === 0) return [];
    const memo = {};
    function generate(left, right) {
        if (left > right) return [null];
        const key = `${left},${right}`;
        if (memo[key]) return memo[key];
        const result = [];
        for (let root = left; root <= right; root++) {
            for (const leftTree of generate(left, root - 1)) {
                for (const rightTree of generate(root + 1, right)) {
                    result.push(new TreeNode(root, leftTree, rightTree));
                }
            }
        }
        memo[key] = result;
        return result;
    }
    return generate(1, n);
}

function preorder(root) {
    if (!root) return ['null'];
    return [root.val.toString()].concat(preorder(root.left), preorder(root.right));
}

// Test cases
const testCases = [0, 1, 2, 3];
testCases.forEach((n, i) => {
    console.log(`Test case ${i + 1}: n = ${n}`);
    const trees = generateTrees(n);
    console.log('Total unique BSTs:', trees.length);
    trees.forEach((root, idx) => {
        console.log(`Tree ${idx + 1}: ${preorder(root).join(' ')}`);
    });
});

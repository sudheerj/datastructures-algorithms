class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function sortedArrayToBST(nums) {
    function build(left, right) {
        if (left > right) return null;
        const mid = Math.floor((left + right) / 2);
        const root = new TreeNode(nums[mid]);
        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);
        return root;
    }
    return build(0, nums.length - 1);
}

function preorder(root) {
    if (!root) return [];
    return [root.val].concat(preorder(root.left), preorder(root.right));
}

// Test cases
const testCases = [
    [],
    [0],
    [1, 2],
    [-10, -3, 0, 5, 9],
    [1, 2, 3, 4, 5, 6, 7]
];

testCases.forEach((arr, i) => {
    console.log(`Test case ${i + 1}: Input: [${arr}]`);
    const bst = sortedArrayToBST(arr);
    console.log('Preorder Output:', preorder(bst));
});

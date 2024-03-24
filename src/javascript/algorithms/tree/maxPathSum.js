//DFS: TC: O(n) SC: O(n)
let maxSum = Number.NEGATIVE_INFINITY;

function maxPathSum(root) {
    dfs(root);
    return maxSum;
}

function dfs(node) {
    if(node === null) return 0;

    let leftMax = Math.max(0, dfs(node.left));
    let rightMax = Math.max(0, dfs(node.right));

    //Max path sum with split
    maxSum = Math.max(maxSum, node.value + leftMax + rightMax);
    //Max path sum without split
    return node.value + Math.max(leftMax, rightMax);
}

class TreeNode {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

let root = new TreeNode(-10);
root.left = new TreeNode(9);
root.right = new TreeNode(20);
root.right.left = new TreeNode(15);
root.right.right = new TreeNode(7);

console.log(maxPathSum(root));
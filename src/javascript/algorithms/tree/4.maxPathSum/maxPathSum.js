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

let root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);

let root2 = new TreeNode(-20);
root2.left = new TreeNode(10);
root2.right = new TreeNode(20);
root2.right.left = new TreeNode(15);
root2.right.right = new TreeNode(10);
root2.right.left.left = new TreeNode(-10);

console.log(maxPathSum(root1));
console.log(maxPathSum(root2));
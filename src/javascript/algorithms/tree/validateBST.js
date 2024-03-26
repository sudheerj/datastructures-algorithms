// DFS: TC:O(n) SC: O(n)

function isValidBST(root) {
    return dfs(root, Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY);
}

function dfs(node, min, max) {
    if(node === null) return true;

    if(!(min < node.value && node.value < max)) return false;

    return dfs(node.left, min, node.value) && dfs(node.right, node.value, max);
}

class TreeNode {
    constructor(value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
}

let root = new TreeNode(5);
root.left = new TreeNode(1);
root.right = new TreeNode(8);
root.left.left = new TreeNode(0);
root.left.right = new TreeNode(2);
root.right.left = new TreeNode(7);
root.right.right = new TreeNode(9);

console.log(isValidBST(root));
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

let root1 = new TreeNode(2);
root1.left = new TreeNode(1);
root1.right = new TreeNode(3);

let root2 = new TreeNode(4);
root2.left = new TreeNode(2);
root2.right = new TreeNode(5);
root2.right.left = new TreeNode(3);
root2.right.right = new TreeNode(6);

console.log(isValidBST(root1));
console.log(isValidBST(root2));
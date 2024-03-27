// TC: O(h) SC: O(1)

function lowestCommonAncestor(root, p, q) {
    let curr = root;

    while(curr !== null) {
        if(curr.value > q.value) {
            curr = curr.left;
        } else if(curr.value < p.value) {
            curr = curr.right;
        } else {
            return curr;
        }
    }
    return null;
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

console.log(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(2)).value);
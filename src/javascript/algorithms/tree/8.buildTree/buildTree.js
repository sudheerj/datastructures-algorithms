//TC: O(n) SC: O(n)

function buildTree(preorder, inorder) {
    if(preorder.length === 0 || inorder.length === 0) return null;

    let root = new TreeNode(preorder[0]);
    let mid = inorder.indexOf(preorder[0]);

    root.left = buildTree(preorder.slice(1, mid+1), inorder.slice(0, mid));
    root.right = buildTree(preorder.slice(mid+1, preorder.length), inorder.slice(mid+1, inorder.length));

    return root;
}

class TreeNode {
    constructor(value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
}

let preorder = [1,2,4,5,3,6,7], inorder = [4,2,5,1,6,3,7];
console.log(buildTree(preorder, inorder));
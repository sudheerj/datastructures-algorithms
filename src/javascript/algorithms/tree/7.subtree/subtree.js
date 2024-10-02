//DFS: TC:O(m * n) SC: O(m)

function isSubtree(root, subRoot) {
    if(!subRoot) return true;
    if(!root) return false;

    return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
}

function isSametree(root1, root2) {
    if(!root1 && !root2) return true;

    if(root1 && root2 && root1.value === root2.value) {
        return isSametree(root1.left, root2.left) && isSametree(root1.right, root2.right);
    }

    return false;
}

class TreeNode {
    constructor(value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
}

let root1 = new TreeNode(0);
root1.left = new TreeNode(1);
root1.right = new TreeNode(2);
root1.left.left = new TreeNode(3);
root1.left.right = new TreeNode(4);
root1.right.left = new TreeNode(5);
root1.right.right = new TreeNode(6);
root1.right.right.left = new TreeNode(7);

let root2 = new TreeNode(1);
root2.left = new TreeNode(3);
root2.right = new TreeNode(4);

let root3 = new TreeNode(2);
root3.left = new TreeNode(5);
root3.right = new TreeNode(6);

console.log(isSubtree(root1, root2));
console.log(isSubtree(root1, root3));


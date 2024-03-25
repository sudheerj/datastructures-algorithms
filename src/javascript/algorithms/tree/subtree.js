//DFS: TC:O(m * n) SC: O(m)

function isSubtree(root1, root2) {
    if(root1 === null) return false;
    if(root2 === null) return true;

    if(root1.value === root2.value && isSametree(root1, root2)) return true;
    return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
}

function isSametree(root1, root2) {
    if(root1 === null && root2 === null) return true;
    if(root1 === null || root2 === null) return false;
    if(root1.value !== root2.value) return false;

    return isSametree(root1.left, root2.left) && isSametree(root2.right, root2.right);
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

let root2 = new TreeNode(1);
root2.left = new TreeNode(3);
root2.right = new TreeNode(4);

console.log(isSubtree(root1, root2));


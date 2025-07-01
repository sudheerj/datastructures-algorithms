// DFS: TC: O(n) SC: O(n)
function isSameTree(a, b) {
  if (a == null && b == null) return true;
  if (a == null || b == null || a.value != b.value) return false;

  return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
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

let root2 = new TreeNode(0);
root2.left = new TreeNode(1);
root2.right = new TreeNode(2);
root2.left.left = new TreeNode(3);
root2.left.right = new TreeNode(4);
root2.right.left = new TreeNode(5);
root2.right.right = new TreeNode(6);

let root3 = new TreeNode(1);
root3.left = new TreeNode(2);
root3.right = new TreeNode(3);

let root4 = new TreeNode(1);
root4.left = new TreeNode(3);
root4.right = new TreeNode(2);

console.log(isSameTree(root1, root2));
console.log(isSameTree(root3, root4));
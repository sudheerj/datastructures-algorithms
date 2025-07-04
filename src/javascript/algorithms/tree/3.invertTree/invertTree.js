//TC: O(n) SC: O(n)

// Recursive solution
function invertTree(root) {
  if (root == null) return null;
  let temp = root.left;
  root.left = root.right;
  root.right = temp;
  invertTree(root.left);
  invertTree(root.right);
  return root;
}

// Iterative solution using queue (BFS)
function invertTreeIterative(root) {
  if (root == null) return null;
  let queue = [root];
  while (queue.length) {
    let node = queue.shift();
    // Swap children
    let temp = node.left;
    node.left = node.right;
    node.right = temp;
    if (node.left) queue.push(node.left);
    if (node.right) queue.push(node.right);
  }
  return root;
}

function printTree(root) {
  if (root === null) return;
  console.log(root.value + " ");
  printTree(root.left);
  printTree(root.right);
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

let root = new TreeNode(0);
root.left = new TreeNode(1);
root.right = new TreeNode(2);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(4);
root.right.left = new TreeNode(5);
root.right.right = new TreeNode(6);

let root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);

console.log("Print tree:");
printTree(root);
console.log("Inverted tree (recursive):");
printTree(invertTree(root));

console.log("Print tree:");
printTree(root1);
console.log("Inverted tree (iterative):");
printTree(invertTreeIterative(root1));

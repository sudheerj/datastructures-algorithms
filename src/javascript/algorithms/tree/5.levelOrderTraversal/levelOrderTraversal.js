// BFS: TC: O(n) SC: O(n)
function levelOrder(root) {
  if (!root) return [];
  let traversal = [];
  let queue = [root];
  while (queue.length) {
    let len = queue.length;
    let currLevel = [];
    for (let i = 0; i < len; i++) {
      let node = queue.shift();
      currLevel.push(node.value);
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }
    traversal.push(currLevel);
  }
  return traversal;
}

// Recursive solution
function levelOrderRecursive(root) {
  let result = [];
  function traverse(node, level) {
    if (!node) return;
    if (result.length === level) result.push([]);
    result[level].push(node.value);
    traverse(node.left, level + 1);
    traverse(node.right, level + 1);
  }
  traverse(root, 0);
  return result;
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

//       1
//      / \
//     2   3
//    / \ / \
//   4  5 6  7
let root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);
root1.left.left = new TreeNode(4);
root1.left.right = new TreeNode(5);
root1.right.left = new TreeNode(6);
root1.right.right = new TreeNode(7);

let root2 = new TreeNode(3);

// BFS tests
console.log("BFS Test 1:", levelOrder(root1)); // [[1], [2, 3], [4, 5, 6, 7]]
console.log("BFS Test 2:", levelOrder(root2)); // [[3]]
console.log("BFS Test 3:", levelOrder(null)); // []

// Recursive tests
console.log("DFS Test 1:", levelOrderRecursive(root1)); // [[1], [2, 3], [4, 5, 6, 7]]
console.log("DFS Test 2:", levelOrderRecursive(root2)); // [[3]]
console.log("DFS Test 3:", levelOrderRecursive(null)); // []

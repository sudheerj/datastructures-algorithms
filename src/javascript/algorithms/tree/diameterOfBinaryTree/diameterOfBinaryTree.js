// Diameter of Binary Tree
// Return the length (in edges) of the longest path between any two nodes.
// TC: O(n), SC: O(h)

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function diameterOfBinaryTree(root) {
  let diameter = 0;

  function dfs(node) {
    if (node === null) return 0;

    const leftHeight = dfs(node.left);
    const rightHeight = dfs(node.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return 1 + Math.max(leftHeight, rightHeight);
  }

  dfs(root);
  return diameter;
}

// Test cases
// Test 1: [1,2,3,4,5] → 3
const root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);
root1.left.left = new TreeNode(4);
root1.left.right = new TreeNode(5);
console.log('Test 1:', diameterOfBinaryTree(root1)); // 3

// Test 2: [1,2] → 1
const root2 = new TreeNode(1);
root2.left = new TreeNode(2);
console.log('Test 2:', diameterOfBinaryTree(root2)); // 1

// Test 3: single node → 0
const root3 = new TreeNode(1);
console.log('Test 3:', diameterOfBinaryTree(root3)); // 0

// Test 4: right-skewed [1,null,2,null,3,null,4] → 3
const root4 = new TreeNode(1);
root4.right = new TreeNode(2);
root4.right.right = new TreeNode(3);
root4.right.right.right = new TreeNode(4);
console.log('Test 4:', diameterOfBinaryTree(root4)); // 3

// Test 5: diameter NOT through root → 4
const root5 = new TreeNode(1);
root5.left = new TreeNode(2);
root5.left.left = new TreeNode(3);
root5.left.right = new TreeNode(4);
root5.left.left.left = new TreeNode(5);
root5.left.right.right = new TreeNode(6);
console.log('Test 5:', diameterOfBinaryTree(root5)); // 4

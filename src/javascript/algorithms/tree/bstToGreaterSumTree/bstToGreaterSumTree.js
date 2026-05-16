// BST to Greater Sum Tree
// Replace each node's value with the sum of all values >= it in the BST.
// TC: O(n), SC: O(h)

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function convertBSTToGreaterSumTree(root) {
  let sum = 0;

  function dfs(node) {
    if (node === null) return;

    dfs(node.right); // visit larger values first

    sum += node.value;
    node.value = sum;

    dfs(node.left); // visit smaller values last
  }

  dfs(root);
  return root;
}

function inorder(node) {
  if (node === null) return [];
  return [...inorder(node.left), node.value, ...inorder(node.right)];
}

// Test cases
// Test 1: [4,1,6,0,2,5,7] → inorder GST: [25,25,24,22,18,13,7]
const root1 = new TreeNode(4);
root1.left = new TreeNode(1);
root1.right = new TreeNode(6);
root1.left.left = new TreeNode(0);
root1.left.right = new TreeNode(2);
root1.right.left = new TreeNode(5);
root1.right.right = new TreeNode(7);
convertBSTToGreaterSumTree(root1);
console.log("Test 1:", inorder(root1).join(" ")); // 25 25 24 22 18 13 7

// Test 2: [2,1,3] → [6,5,3]
const root2 = new TreeNode(2);
root2.left = new TreeNode(1);
root2.right = new TreeNode(3);
convertBSTToGreaterSumTree(root2);
console.log("Test 2:", inorder(root2).join(" ")); // 6 5 3

// Test 3: single node [5] → [5]
const root3 = new TreeNode(5);
convertBSTToGreaterSumTree(root3);
console.log("Test 3:", inorder(root3).join(" ")); // 5

// Test 4: [3,2,4,1] → [10,9,7,4]
const root4 = new TreeNode(3);
root4.left = new TreeNode(2);
root4.right = new TreeNode(4);
root4.left.left = new TreeNode(1);
convertBSTToGreaterSumTree(root4);
console.log("Test 4:", inorder(root4).join(" ")); // 10 9 7 4

// Test 5: right-skewed [1,null,2,null,3] → [6,5,3]
const root5 = new TreeNode(1);
root5.right = new TreeNode(2);
root5.right.right = new TreeNode(3);
convertBSTToGreaterSumTree(root5);
console.log("Test 5:", inorder(root5).join(" ")); // 6 5 3

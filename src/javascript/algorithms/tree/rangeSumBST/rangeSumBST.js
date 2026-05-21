// Range Sum of BST
// Return the sum of all node values within the inclusive range [low, high].
// TC: O(n), SC: O(n)

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function rangeSum(root, low, high) {
  if (root === null) return 0;

  // Current value too large — only left subtree can have valid nodes
  if (root.value > high) return rangeSum(root.left, low, high);

  // Current value too small — only right subtree can have valid nodes
  if (root.value < low) return rangeSum(root.right, low, high);

  // Current value in range — add it and search both subtrees
  return root.value + rangeSum(root.left, low, high) + rangeSum(root.right, low, high);
}

// Test cases
// Test 1: [10,5,15,3,7,null,18], low=7, high=15 → 32
const root1 = new TreeNode(10);
root1.left = new TreeNode(5);
root1.right = new TreeNode(15);
root1.left.left = new TreeNode(3);
root1.left.right = new TreeNode(7);
root1.right.right = new TreeNode(18);
console.log('Test 1:', rangeSum(root1, 7, 15)); // 32

// Test 2: [10,5,15,3,7,13,18,1,null,6], low=6, high=10 → 23
const root2 = new TreeNode(10);
root2.left = new TreeNode(5);
root2.right = new TreeNode(15);
root2.left.left = new TreeNode(3);
root2.left.right = new TreeNode(7);
root2.right.left = new TreeNode(13);
root2.right.right = new TreeNode(18);
root2.left.left.left = new TreeNode(1);
root2.left.right.left = new TreeNode(6);
console.log('Test 2:', rangeSum(root2, 6, 10)); // 23

// Test 3: Single node within range
const root3 = new TreeNode(5);
console.log('Test 3:', rangeSum(root3, 1, 10)); // 5

// Test 4: Single node outside range
const root4 = new TreeNode(5);
console.log('Test 4:', rangeSum(root4, 6, 10)); // 0

// Test 5: All nodes within range
const root5 = new TreeNode(10);
root5.left = new TreeNode(5);
root5.right = new TreeNode(15);
console.log('Test 5:', rangeSum(root5, 1, 20)); // 30

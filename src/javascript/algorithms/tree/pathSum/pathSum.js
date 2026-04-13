// DFS: TC: O(n) SC: O(n)
function hasPathSum(root, targetSum) {
  function dfs(node, currSum) {
    if (node === null) return false;

    currSum += node.value;

    if (node.left === null && node.right === null) {
      return currSum === targetSum;
    }

    return dfs(node.left, currSum) || dfs(node.right, currSum);
  }

  return dfs(root, 0);
}

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// Test 1: Normal tree with valid path sum (5->4->11->2 = 22)
let root1 = new TreeNode(5);
root1.left = new TreeNode(4);
root1.right = new TreeNode(8);
root1.left.left = new TreeNode(11);
root1.right.left = new TreeNode(13);
root1.right.right = new TreeNode(4);
root1.left.left.left = new TreeNode(7);
root1.left.left.right = new TreeNode(2);
root1.right.right.right = new TreeNode(1);
console.log("Test 1 (targetSum=22):", hasPathSum(root1, 22)); // true

// Test 2: Simple tree with no valid path
let root2 = new TreeNode(1);
root2.left = new TreeNode(2);
root2.right = new TreeNode(3);
console.log("Test 2 (targetSum=5):", hasPathSum(root2, 5)); // false

// Test 3: Single node matching target
let root3 = new TreeNode(1);
console.log("Test 3 (targetSum=1):", hasPathSum(root3, 1)); // true

// Test 4: Single node not matching target
console.log("Test 4 (targetSum=2):", hasPathSum(root3, 2)); // false

// Test 5: Null tree
console.log("Test 5 (null tree, targetSum=0):", hasPathSum(null, 0)); // false

// Test 6: Tree with negative values (-2 -> -3 = -5)
let root6 = new TreeNode(-2);
root6.right = new TreeNode(-3);
console.log("Test 6 (targetSum=-5):", hasPathSum(root6, -5)); // true

// Test 7: Path sum equals 0 (1 -> -1 = 0)
let root7 = new TreeNode(1);
root7.left = new TreeNode(-1);
console.log("Test 7 (targetSum=0):", hasPathSum(root7, 0)); // true

// Test 8: Left path valid (1->2 = 3)
console.log("Test 8 (targetSum=3):", hasPathSum(root2, 3)); // true

// Test 9: Right path valid (1->3 = 4)
console.log("Test 9 (targetSum=4):", hasPathSum(root2, 4)); // true

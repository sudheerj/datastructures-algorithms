// DFS + Backtracking: TC: O(n^2) SC: O(n)
function pathSum(root, targetSum) {
  const result = [];

  function dfs(node, currentSum, currPath) {
    if (node === null) return;

    currPath.push(node.value);
    currentSum += node.value;

    if (node.left === null && node.right === null && currentSum === targetSum) {
      result.push([...currPath]);
    }

    dfs(node.left, currentSum, currPath);
    dfs(node.right, currentSum, currPath);

    currPath.pop(); // backtrack
  }

  dfs(root, 0, []);
  return result;
}

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

// Test 1: Normal tree with multiple valid paths
//         5
//        / \
//       4   8
//      /   / \
//     11  13   4
//    / \      / \
//   7   2    5   1
let root1 = new TreeNode(5);
root1.left = new TreeNode(4);
root1.right = new TreeNode(8);
root1.left.left = new TreeNode(11);
root1.right.left = new TreeNode(13);
root1.right.right = new TreeNode(4);
root1.left.left.left = new TreeNode(7);
root1.left.left.right = new TreeNode(2);
root1.right.right.left = new TreeNode(5);
root1.right.right.right = new TreeNode(1);
console.log("Test 1 (targetSum=22):", JSON.stringify(pathSum(root1, 22))); // [[5,4,11,2],[5,8,4,5]]

// Test 2: Simple tree with no valid path
let root2 = new TreeNode(1);
root2.left = new TreeNode(2);
root2.right = new TreeNode(3);
console.log("Test 2 (targetSum=5):", JSON.stringify(pathSum(root2, 5))); // []

// Test 3: Single node matching target
let root3 = new TreeNode(1);
console.log("Test 3 (targetSum=1):", JSON.stringify(pathSum(root3, 1))); // [[1]]

// Test 4: Single node not matching target
console.log("Test 4 (targetSum=2):", JSON.stringify(pathSum(root3, 2))); // []

// Test 5: Null tree
console.log("Test 5 (null tree, targetSum=0):", JSON.stringify(pathSum(null, 0))); // []

// Test 6: Tree with negative values (-2 -> -3 = -5)
let root6 = new TreeNode(-2);
root6.right = new TreeNode(-3);
console.log("Test 6 (targetSum=-5):", JSON.stringify(pathSum(root6, -5))); // [[-2,-3]]

// Test 7: Multiple leaves, only one path valid (1->2 = 3)
console.log("Test 7 (targetSum=3):", JSON.stringify(pathSum(root2, 3))); // [[1,2]]

// Test 8: All root-to-leaf paths valid
let root8 = new TreeNode(1);
root8.left = new TreeNode(2);
root8.right = new TreeNode(2);
console.log("Test 8 (targetSum=3):", JSON.stringify(pathSum(root8, 3))); // [[1,2],[1,2]]

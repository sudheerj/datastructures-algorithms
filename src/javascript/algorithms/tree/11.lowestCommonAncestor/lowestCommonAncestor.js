// TC: O(h) SC: O(1)

function lowestCommonAncestor(root, p, q) {
  if (!root || !p || !q) return null;
  let currNode = root;

  while (currNode !== null) {
    if (currNode.value > p.value && currNode.value > q.value) {
      currNode = currNode.left;
    } else if (currNode.value < p.value && currNode.value < q.value) {
      currNode = currNode.right;
    } else {
      return currNode;
    }
  }
  return null;
}

// Recursive solution
function lowestCommonAncestorRecursive(root, p, q) {
  if (!root || !p || !q) return null;
  if (root.value > p.value && root.value > q.value) {
    return lowestCommonAncestorRecursive(root.left, p, q);
  } else if (root.value < p.value && root.value < q.value) {
    return lowestCommonAncestorRecursive(root.right, p, q);
  } else {
    return root;
  }
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

//       5
//      / \
//     1   8
//    / \ / \
//   0  2 7  9
let root1 = new TreeNode(5);
root1.left = new TreeNode(1);
root1.right = new TreeNode(8);
root1.left.left = new TreeNode(0);
root1.left.right = new TreeNode(2);
root1.right.left = new TreeNode(7);
root1.right.right = new TreeNode(9);

// --- Iterative tests ---
// Test 1: Nodes in left subtree
console.log("Test 1 (Iterative): LCA of 0 and 2 =", lowestCommonAncestor(root1, root1.left.left, root1.left.right).value); // 1

// Test 2: Nodes on opposite sides
console.log("Test 2 (Iterative): LCA of 1 and 8 =", lowestCommonAncestor(root1, root1.left, root1.right).value); // 5

// Test 3: One node is ancestor
console.log("Test 3 (Iterative): LCA of 8 and 9 =", lowestCommonAncestor(root1, root1.right, root1.right.right).value); // 8

// Test 4: Nodes in right subtree
console.log("Test 4 (Iterative): LCA of 7 and 9 =", lowestCommonAncestor(root1, root1.right.left, root1.right.right).value); // 8

// Test 5: Root is the LCA
console.log("Test 5 (Iterative): LCA of 0 and 9 =", lowestCommonAncestor(root1, root1.left.left, root1.right.right).value); // 5

// --- Recursive tests ---
// Test 6: Nodes in left subtree
console.log("Test 6 (Recursive): LCA of 0 and 2 =", lowestCommonAncestorRecursive(root1, root1.left.left, root1.left.right).value); // 1

// Test 7: Nodes on opposite sides
console.log("Test 7 (Recursive): LCA of 1 and 8 =", lowestCommonAncestorRecursive(root1, root1.left, root1.right).value); // 5

// Test 8: One node is ancestor
console.log("Test 8 (Recursive): LCA of 8 and 9 =", lowestCommonAncestorRecursive(root1, root1.right, root1.right.right).value); // 8

// Test 9: Node with itself
console.log("Test 9 (Recursive): LCA of 1 and 1 =", lowestCommonAncestorRecursive(root1, root1.left, root1.left).value); // 1

// Binary Tree Zigzag Level Order Traversal
// Return level-order traversal alternating left→right and right→left each level.
// TC: O(n), SC: O(n)

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function zigzagLevelOrder(root) {
  const result = [];
  if (root === null) return result;

  const queue = [root];

  while (queue.length > 0) {
    const size = queue.length;
    const level = new Array(size);

    for (let i = 0; i < size; i++) {
      const node = queue.shift();
      const index = result.length % 2 === 0 ? i : size - i - 1;
      level[index] = node.value;

      if (node.left !== null) queue.push(node.left);
      if (node.right !== null) queue.push(node.right);
    }

    result.push(level);
  }

  return result;
}

// Test cases
// Test 1: Full 3-level tree → [[1],[3,2],[4,5,6,7]]
const root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);
root1.left.left = new TreeNode(4);
root1.left.right = new TreeNode(5);
root1.right.left = new TreeNode(6);
root1.right.right = new TreeNode(7);
console.log('Test 1:', JSON.stringify(zigzagLevelOrder(root1))); // [[1],[3,2],[4,5,6,7]]

// Test 2: Single node → [[3]]
const root2 = new TreeNode(3);
console.log('Test 2:', JSON.stringify(zigzagLevelOrder(root2))); // [[3]]

// Test 3: null root → []
console.log('Test 3:', JSON.stringify(zigzagLevelOrder(null))); // []

// Test 4: Left-skewed with right child [1,2,null,null,3] → [[1],[2],[3]]
const root4 = new TreeNode(1);
root4.left = new TreeNode(2);
root4.left.right = new TreeNode(3);
console.log('Test 4:', JSON.stringify(zigzagLevelOrder(root4))); // [[1],[2],[3]]

// Test 5: 4-level tree → [[1],[3,2],[4,5],[7,6]]
const root5 = new TreeNode(1);
root5.left = new TreeNode(2);
root5.right = new TreeNode(3);
root5.left.left = new TreeNode(4);
root5.right.right = new TreeNode(5);
root5.left.left.left = new TreeNode(6);
root5.left.left.right = new TreeNode(7);
console.log('Test 5:', JSON.stringify(zigzagLevelOrder(root5))); // [[1],[3,2],[4,5],[7,6]]

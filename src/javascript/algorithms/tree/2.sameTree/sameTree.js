// Recursive DFS: TC: O(n) SC: O(h)
function isSameTree(a, b) {
  if (a == null && b == null) return true;
  if (a == null || b == null || a.value != b.value) return false;

  return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
}

// Iterative DFS: TC: O(n) SC: O(h)
function isSameTree1(p, q) {
  const stack = [[p, q]];
  while (stack.length > 0) {
    const [node1, node2] = stack.pop();
    if (node1 == null && node2 == null) continue;
    if (node1 == null || node2 == null || node1.value !== node2.value) return false;
    stack.push([node1.left, node2.left]);
    stack.push([node1.right, node2.right]);
  }
  return true;
}

// BFS: TC: O(n) SC: O(w)
function isSameTree2(p, q) {
  const queue = [[p, q]];
  while (queue.length > 0) {
    const [node1, node2] = queue.shift();
    if (node1 == null && node2 == null) continue;
    if (node1 == null || node2 == null || node1.value !== node2.value) return false;
    queue.push([node1.left, node2.left]);
    queue.push([node1.right, node2.right]);
  }
  return true;
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

// Test 1: Identical trees [0,1,2,3,4,5,6]
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

// Test 2: Different values [1,2,3] vs [1,3,2]
let root3 = new TreeNode(1);
root3.left = new TreeNode(2);
root3.right = new TreeNode(3);

let root4 = new TreeNode(1);
root4.left = new TreeNode(3);
root4.right = new TreeNode(2);

// Test 3: Different structure [1,2] vs [1,null,2]
let root5 = new TreeNode(1);
root5.left = new TreeNode(2);

let root6 = new TreeNode(1);
root6.right = new TreeNode(2);

// Test 4: Single node — same value
let root7 = new TreeNode(5);
let root8 = new TreeNode(5);

// Test 5: Single node — different values
let root9 = new TreeNode(1);
let root10 = new TreeNode(2);

console.log("=== isSameTree (Recursive DFS) ===");
console.log(isSameTree(root1, root2));   // true
console.log(isSameTree(root3, root4));   // false
console.log(isSameTree(root5, root6));   // false
console.log(isSameTree(null, null));      // true
console.log(isSameTree(root1, null));     // false
console.log(isSameTree(root7, root8));   // true
console.log(isSameTree(root9, root10));  // false

console.log("\n=== isSameTree1 (Iterative DFS) ===");
console.log(isSameTree1(root1, root2));   // true
console.log(isSameTree1(root3, root4));   // false
console.log(isSameTree1(root5, root6));   // false
console.log(isSameTree1(null, null));      // true
console.log(isSameTree1(root1, null));     // false
console.log(isSameTree1(root7, root8));   // true
console.log(isSameTree1(root9, root10));  // false

console.log("\n=== isSameTree2 (BFS) ===");
console.log(isSameTree2(root1, root2));   // true
console.log(isSameTree2(root3, root4));   // false
console.log(isSameTree2(root5, root6));   // false
console.log(isSameTree2(null, null));      // true
console.log(isSameTree2(root1, null));     // false
console.log(isSameTree2(root7, root8));   // true
console.log(isSameTree2(root9, root10));  // false
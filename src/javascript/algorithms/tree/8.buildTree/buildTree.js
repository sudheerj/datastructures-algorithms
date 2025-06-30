//TC: O(n) SC: O(n)

function buildTree(preorder, inorder) {
  if (!preorder || !inorder || preorder.length !== inorder.length) return null;
  let inorderMap = new Map();
  for (let i = 0; i < inorder.length; i++) {
    inorderMap.set(inorder[i], i);
  }
  function helper(preStart, preEnd, inStart, inEnd) {
    if (preStart > preEnd || inStart > inEnd) return null;
    let rootVal = preorder[preStart];
    let root = new TreeNode(rootVal);
    let inRootIdx = inorderMap.get(rootVal);
    let leftSize = inRootIdx - inStart;
    root.left = helper(
      preStart + 1,
      preStart + leftSize,
      inStart,
      inRootIdx - 1
    );
    root.right = helper(preStart + leftSize + 1, preEnd, inRootIdx + 1, inEnd);
    return root;
  }
  return helper(0, preorder.length - 1, 0, inorder.length - 1);
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

let preorder = [1, 2, 4, 5, 3, 6, 7],
  inorder = [4, 2, 5, 1, 6, 3, 7];
console.log(buildTree(preorder, inorder));

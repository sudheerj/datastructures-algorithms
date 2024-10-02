//Iterative Inorder BST: TC: O(n) SC: O(n)
function kthSmallestBST1(root, k) {
    let stack = [];
    let currNode = root;
    while(currNode || stack.length >0) {
        while(currNode) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        currNode = stack.pop();
        k--;
        if(k === 0) return currNode.value;
        currNode = currNode.right;
    }

    return 0;
}

//Recursive Inorder BST: TC: O(n) SC: O(n)
function kthSmallestBST2(root, k) {
    let list = [];
    inorderTraversal(root, list);
    return list[k-1];
}

function inorderTraversal(node, list){
    if(node === null) return;
    inorderTraversal(node.left, list);
    list.push(node.value);
    inorderTraversal(node.right, list);
}

class TreeNode {
    constructor(value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
}


let root1 = new TreeNode(5);
root1.left = new TreeNode(1);
root1.right = new TreeNode(8);
root1.left.left = new TreeNode(0);
root1.left.right = new TreeNode(2);
root1.right.left = new TreeNode(7);
root1.right.right = new TreeNode(9);

let root2 = new TreeNode(2);
root2.left = new TreeNode(1);
root2.right = new TreeNode(3);

console.log(kthSmallestBST1(root1, 3));
console.log(kthSmallestBST2(root1, 3));

console.log(kthSmallestBST1(root2, 2));
console.log(kthSmallestBST2(root2, 2));
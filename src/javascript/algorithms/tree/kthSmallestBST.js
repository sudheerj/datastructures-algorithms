//Iterative Inorder BST: TC: O(n) SC: O(n)
function kthSmallest1(root, k) {
    let st = [];
    while(true) {
        while(root !== null) {
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        k--;
        if(k === 0) return root.value;
        root = root.right;
    }
}

//Recursive Inorder BST: TC: O(n) SC: O(n)
function kthSmallest2(root, k) {
    let list = [];
    inorderTraversal(root, list);
    return list[k-1];
}

function inorderTraversal(root, list){
    if(root === null) return;
    inorderTraversal(root.left, list);
    list.push(root.value);
    inorderTraversal(root.right, list);
}

class TreeNode {
    constructor(value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
}


let root = new TreeNode(5);
root.left = new TreeNode(1);
root.right = new TreeNode(8);
root.left.left = new TreeNode(0);
root.left.right = new TreeNode(2);
root.right.left = new TreeNode(7);
root.right.right = new TreeNode(9);

console.log(kthSmallest1(root, 3));
console.log(kthSmallest2(root, 3));
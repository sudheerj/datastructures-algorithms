//BFS: TC: O(n) SC: O(n)

function levelOrder(root) {
    let traversal = [];
    let queue = [];
    queue.push(root);

    while(queue.length) {
        let len = queue.length;
        let currLevel = [];

        while(len >0){
            let node = queue.shift();
            currLevel.push(node.value);
            if(node.left !== null) queue.push(node.left);
            if(node.right !== null) queue.push(node.right);
            len--;
        }
        traversal.push(currLevel);
    }
    return traversal;
}

class TreeNode {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

let root = new TreeNode(-10);
root.left = new TreeNode(9);
root.right = new TreeNode(20);
root.right.left = new TreeNode(15);
root.right.right = new TreeNode(7);

console.log(levelOrder(root));
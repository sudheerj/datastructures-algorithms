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
            if(node != null) {
                currLevel.push(node.value);
                if(node.left !== null) queue.push(node.left);
                if(node.right !== null) queue.push(node.right);
            }
            len--;
        }
        if(currLevel.length >0) {
            traversal.push(currLevel);
        }   
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

let root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);
root1.left.left = new TreeNode(4);
root1.left.right = new TreeNode(5);
root1.right.left = new TreeNode(6);
root1.right.right = new TreeNode(7);

let root2 = new TreeNode(3);

console.log(levelOrder(root1));
console.log(levelOrder(root2));
console.log(levelOrder(null));
// Recursive DFS(InOrder traversal):- TC: O(n) SC: O(n)
function maxDepth1(root) {
    if(root == null) return 0;

    return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
}

// Iterative DFS using stack(PreOrder traversal):- TC: O(n) SC: O(n)
function maxDepth2(root) {
    if(root == null) return 0;

    let stack = [[root, 1]];
    let maxDepth = 0;

    while(stack.length) {
        let [node, depth] = stack.pop();

        if(node != null) {
            maxDepth = Math.max(maxDepth, depth);

            if(node.left) {
                stack.push([node.left, depth+1]);
            }
    
            if(node.right) {
                stack.push([node.right, depth+1]);
            }
        }
    }
    return maxDepth;
}

// BFS:- TC: O(n) SC: O(n)
function maxDepth3(head) {
    if(root == null) return 0;

    let queue = [root];
    let maxDepth = 0;

    while(queue.length) {

        for(let i=0; i< queue.length; i++) {
            let node = queue.shift();

            if(node.left) queue.push(node.left);
            if(node.right) queue.push(node.right);
        }

        maxDepth++;
    }

    return maxDepth;
}

class TreeNode {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

let root = new TreeNode(0);
root.left = new TreeNode(1);
root.right = new TreeNode(3);
root.right.left = new TreeNode(2);
root.right.right = new TreeNode(4);

console.log(maxDepth1(root));
console.log(maxDepth2(root));
console.log(maxDepth3(root));
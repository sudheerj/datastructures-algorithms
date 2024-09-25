class Node {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null
    }

    insert(value) {
        const newNode = new Node(value);
        if(this.root === null) {
            this.root = newNode;
            return this;
        } 
            let currentNode = this.root;
            while(true) {
                if(value < currentNode.value) {
                    // Left
                    if(currentNode.left ===  null) {
                        currentNode.left = newNode;
                        return this;
                    }
                    currentNode = currentNode.left
                } else if (value > currentNode.value){
                    // Right
                    if(currentNode.right === null) {
                        currentNode.right = newNode;
                        return this;
                    }
                    currentNode = currentNode.right;
                }  else {
                    return this;
                }
            }
    }

    lookup(value) {
        if(this.root === null) {
            return false;
        }
        let currentNode = this.root;
        while(currentNode) {
            if(value < currentNode.value) {
                currentNode = currentNode.left;
            } else if(value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }
    
    minValueNode(currentNode) {
        while(true) {
            if(!currentNode.left) return currentNode;
            currentNode = currentNode.left;
        }
    }

    maxValueNode(currentNode) {
        while(true) {
            if(!currentNode.right) return currentNode;
            currentNode = currentNode.right;
        }
    }

    bfs() {
        let currentNode = this.root;
        let queue = [];
        let output = [];
        queue.push(currentNode);

        while(queue.length) {
            currentNode = queue.shift();
            output.push(currentNode.value);
            if(currentNode.left) queue.push(currentNode.left);
            if(currentNode.right) queue.push(currentNode.right);
        }
        return output;
    }

    dfsPreOrder() {
        let output = [];
        function traverse(currentNode) {
            output.push(currentNode.value);
            if(currentNode.left) traverse(currentNode.left);
            if(currentNode.right) traverse(currentNode.right);
        }
        traverse(this.root);
        return output;
    }

    dfsPostOrder() {
        let output = [];
        function traverse(currentNode) {
            if(currentNode.left) traverse(currentNode.left);
            if(currentNode.right) traverse(currentNode.right);
            output.push(currentNode.value);
        }
        traverse(this.root);
        return output;
    }

    dfsInOrder() {
        let output = [];
        function traverse(currentNode) {
            if(currentNode.left) traverse(currentNode.left);
            output.push(currentNode.value);
            if(currentNode.right) traverse(currentNode.right);
        }
        traverse(this.root);
        return output;
    }
}

const tree = new BinarySearchTree();
tree.insert(20);
tree.insert(15);
tree.insert(25);
tree.insert(12);
tree.insert(16);
tree.insert(22);
tree.insert(30);
tree.insert(10);
tree.insert(14);
tree.insert(28);
tree.insert(35);
console.dir(tree, {depth: null});

console.log(tree.lookup(25));
console.log(tree.lookup(7));
console.log(tree.lookup(10));
console.log(tree.lookup(12));
console.log(tree.minValueNode(tree.root.left));
console.log(tree.maxValueNode(tree.root.right));

console.log(tree.bfs());
console.log(tree.dfsPreOrder());
console.log(tree.dfsPostOrder());
console.log(tree.dfsInOrder());
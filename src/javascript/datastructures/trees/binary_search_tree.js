class Node {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    insert(value) {
        const newNode = new Node(value);
        if (!this.root) {
            this.root = newNode;
            return;
        }
        let currentNode = this.root;
        while (true) {
            if (value < currentNode.value) {
                // Left
                if (!currentNode.left) {
                    currentNode.left = newNode;
                    break;
                }
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                // Right
                if (!currentNode.right) {
                    currentNode.right = newNode;
                    break;
                }
                currentNode = currentNode.right;
            } else {
                break; // Duplicate value, do nothing
            }
        }
    }

    lookup(value) {
        let currentNode = this.root;
        while (currentNode) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;
    }

    minValueNode(currentNode) {
        while (currentNode && currentNode.left) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    maxValueNode(currentNode) {
        while (currentNode && currentNode.right) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    bfs() {
        if (!this.root) return [];
        let queue = [this.root];
        let output = [];
        while (queue.length) {
            let currentNode = queue.shift();
            output.push(currentNode.value);
            if (currentNode.left) queue.push(currentNode.left);
            if (currentNode.right) queue.push(currentNode.right);
        }
        return output;
    }

    dfsPreOrder() {
        let output = [];
        function traverse(node) {
            if (!node) return;
            output.push(node.value);
            traverse(node.left);
            traverse(node.right);
        }
        traverse(this.root);
        return output;
    }

    dfsPostOrder() {
        let output = [];
        function traverse(node) {
            if (!node) return;
            traverse(node.left);
            traverse(node.right);
            output.push(node.value);
        }
        traverse(this.root);
        return output;
    }

    dfsInOrder() {
        let output = [];
        function traverse(node) {
            if (!node) return;
            traverse(node.left);
            output.push(node.value);
            traverse(node.right);
        }
        traverse(this.root);
        return output;
    }

    delete(value) {
        this.root = this._deleteNode(this.root, value);
    }

    _deleteNode(node, value) {
        if (!node) return null;

        if (value < node.value) {
            node.left = this._deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = this._deleteNode(node.right, value);
        } else {
            if (!node.left) return node.right;
            if (!node.right) return node.left;

            // Two children: replace with in-order successor (min of right subtree)
            const successor = this.minValueNode(node.right);
            node.value = successor.value;
            node.right = this._deleteNode(node.right, successor.value);
        }
        return node;
    }
}

// Usage example
const tree = new BinarySearchTree();
[20, 15, 25, 12, 16, 22, 30, 10, 14, 28, 35].forEach(v => tree.insert(v));

console.dir(tree, { depth: null });

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

// Delete leaf node (no children): remove 10
tree.delete(10);
console.log('After deleting leaf 10:', tree.dfsInOrder()); // [12, 14, 15, 16, 20, 22, 25, 28, 30, 35]

// Delete node with one child: remove 12 (only has right child 14)
tree.delete(12);
console.log('After deleting 12 (one child):', tree.dfsInOrder()); // [14, 15, 16, 20, 22, 25, 28, 30, 35]

// Delete node with two children: remove 25 (in-order successor 28 replaces it)
tree.delete(25);
console.log('After deleting 25 (two children):', tree.dfsInOrder()); // [14, 15, 16, 20, 22, 28, 30, 35]

// Delete root node: remove 20
tree.delete(20);
console.log('After deleting root 20:', tree.dfsInOrder()); // [14, 15, 16, 22, 28, 30, 35]

// Delete non-existent value: no change
tree.delete(99);
console.log('After deleting non-existent 99:', tree.dfsInOrder()); // [14, 15, 16, 22, 28, 30, 35]
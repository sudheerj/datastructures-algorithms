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
        } else {
            const currentNode = this.root;
            while(true) {
                if(value < currentNode.value) {
                    // Left
                    if(!currentNode.left) {
                        currentNode.left = newNode;
                        return this;
                    }
                    currentNode = currentNode.left
                } else if (value > currentNode.right){
                    // Right
                    if(!currentNode.right) {
                        currentNode.right = newNode;
                        return this;
                    }
                    currentNode = currentNode.right;
                }  else {
                    return this;
                }
            }
        }
        return this;
    }
    lookup(value) {
        if(this.root === null) {
            return false;
        }
        const currentNode = this.root;
        while(true) {
            if(value < currentNode.left) {
                currentNode = currentNode.left;
            } else if(value > currentNode.right) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;
    }
}

const tree = new BinarySearchTree();
tree.insert(80);
tree.insert(100);
tree.insert(50);
tree.lookup(50);
tree.insert(90);
tree.lookup(88);
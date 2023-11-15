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
            const currentNode = this.root;
            while(true) {
                if(value < currentNode.value) {
                    // Left
                    if(currentNode.left ===  null) {
                        currentNode.left = newNode;
                        return this;
                    }
                    currentNode = currentNode.left
                } else if (value > currentNode.right){
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

    contains(value) {
        if (this.root === null) return false;
        let temp = this.root;
        while (temp) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
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
}

const tree = new BinarySearchTree();
tree.insert(80);
tree.insert(100);
tree.insert(50);
console.log(tree.lookup(50));
tree.insert(90);
console.log(tree.lookup(88));
console.log(tree.contains(100));
console.log(tree.contains(9));
console.log(tree.minValueNode(tree.root.left));
console.log(tree.maxValueNode(tree.root.right));
// Preorder traversal DFS: TC:O(n) SC: O(n)
function serialize(root) {
  let list = [];
  function serializeDFS(node) {
    if (node == null) {
      list.push("N");
      return;
    }
    list.push(node.value);
    serializeDFS(node.left);
    serializeDFS(node.right);
  }
  serializeDFS(root);
  return list.join(",");
}

// DFS: TC:O(n) SC: O(n)
function deserialize(data) {
  let tokens = data.split(",");
  let index = 0;
  function deserializeDFS() {
    if (tokens[index] === "N") {
      index++;
      return null;
    }
    let node = new TreeNode(tokens[index++]);
    node.left = deserializeDFS();
    node.right = deserializeDFS();
    return node;
  }
  return deserializeDFS();
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

function printTree(root) {
  if (root === null) return;
  console.log(root.value + " ");
  printTree(root.left);
  printTree(root.right);
}

let root = new TreeNode(0);
root.left = new TreeNode(1);
root.right = new TreeNode(2);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(4);
root.right.left = new TreeNode(5);
root.right.right = new TreeNode(6);

let serializeStr = serialize(root);
console.log(serializeStr);
printTree(deserialize(serializeStr));

let serializeStr1 = serialize(null);
console.log(serializeStr1);
console.log(deserialize(serializeStr1));

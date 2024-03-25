// Preorder traversal DFS: TC:O(n) SC: O(n)
let i = 0;
function serialize(root) {
  let list = [];
  serializeDFS(root, list);
  return list.join(",");
}

function serializeDFS(node, list) {
  if (node == null) {
    list.push("N");
    return;
  }
  list.push(node.value);
  serializeDFS(node.left, list);
  serializeDFS(node.right, list);
}

// DFS: TC:O(n) SC: O(n)
function deserialize(data) {
  let tokens = data.split(",");
  return deserializeDFS(tokens);
}

function deserializeDFS(tokens) {
  let token = tokens[i];
  if (token === "N") {
    i++;
    return null;
  }
  let node = new TreeNode(token);
  i++;
  node.left = deserializeDFS(tokens);
  node.right = deserializeDFS(tokens);

  return node;
}

class TreeNode {
  constructor(value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}


function printTree(root) {
    if(root === null) return;
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

// TC:O(n) SC:O(n)

class Node {
    constructor(val, neighbours) {
        this.val = val || 0;
        this.neighbours = neighbours || [];
    }
}

function cloneGraph1(node) { 
    if(!node.val) return null;

    const visitedObj = {};
    return dfs(node, visitedObj);

}

function dfs(node, visitedObj) {
    if(visitedObj[node.val]) return visitedObj[node.val];

    const clonedNode = new Node(node.val);
    visitedObj[node.val] = clonedNode;

    for(let neighbour of node.neighbours) {
        clonedNode.neighbours.push(dfs(neighbour, visitedObj));
    }
    return clonedNode;
}

//function cloneGraph2() {
//}


let node1 = new Node(1);
let node2 = new Node(2);
let node3 = new Node(3);
let node4 = new Node(4);

node1.neighbours.push(node2);
node1.neighbours.push(node3);

node2.neighbours.push(node1);
node2.neighbours.push(node4);

node4.neighbours.push(node2);
node4.neighbours.push(node3);

node3.neighbours.push(node4);
node3.neighbours.push(node1);

console.log(cloneGraph1(node1));
//console.log(cloneGraph2(node1));
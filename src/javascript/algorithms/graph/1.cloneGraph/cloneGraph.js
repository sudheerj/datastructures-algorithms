// TC:O(n) SC:O(n)

class Node {
    constructor(val, neighbours) {
        this.val = val || 0;
        this.neighbours = neighbours || [];
    }
}

function cloneGraph(node) { 
    if(!node) return null;

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


let node1 = new Node(1);
let node2 = new Node(2);
let node3 = new Node(3);
let node4 = new Node(4);
let node5 = new Node(1);
let node6 = null;

node1.neighbours.push(node2);

node2.neighbours.push(node1);
node2.neighbours.push(node3);

node3.neighbours.push(node2);
node3.neighbours.push(node4);

node4.neighbours.push(node3);

console.dir(cloneGraph(node1),{depth:null});
console.dir(cloneGraph(node5),{depth:null});
console.log(cloneGraph(node6));

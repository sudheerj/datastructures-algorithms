class Graph {
    constructor() {
        this.numberOfNodes = 0;
        this.adjacentList = {}
    }

    addVertex(node) {
        this.adjacentList[node] = [];
        this.numberOfNodes++;
    }

    addEdge(firstNode, secondNode) {
        this.adjacentList[firstNode].push(secondNode);
        this.adjacentList[secondNode].push(firstNode);
    }

    showConnections() {
        const allNodes = Object.keys(this.adjacentList);
        for (let node of allNodes) {
            const nodeConnections = this.adjacentList[node];
            let connections = '';
            for (let vertex of nodeConnections) {
                connections += vertex + ' ';
            }
            console.log(node +' --> ', connections);
        }
        
    }
}

const myGraph = new Graph();
myGraph.addVertex('1');
myGraph.addVertex('2');
myGraph.addVertex('3');
myGraph.addVertex('4');
myGraph.addVertex('5');
myGraph.addVertex('6');
myGraph.addEdge('1', '2');
myGraph.addEdge('1', '3');
myGraph.addEdge('2', '3');
myGraph.addEdge('2', '4');
myGraph.addEdge('3', '5');
myGraph.showConnections();



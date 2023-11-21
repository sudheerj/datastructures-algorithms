class Graph {
    constructor() {
        this.numberOfVertices = 0;
        this.adjacentList = {}
    }

    addVertex(vertex) {
        if(!this.adjacentList[vertex]) {
            this.adjacentList[vertex] = [];
            this.numberOfVertices++;
            return true;
        }
        return false;
    }

    addEdge(firstVertex, secondVertex) {
        if(this.adjacentList[firstVertex] && this.adjacentList[secondVertex]) {
            this.adjacentList[firstVertex].push(secondVertex);
            this.adjacentList[secondVertex].push(firstVertex);
            return true;
        }
        return false;
    }

    removeEdge(firstVertex, secondVertex) {
        if(this.adjacentList[firstVertex] && this.adjacentList[secondVertex]) {
            this.adjacentList[firstVertex] = this.adjacentList[firstVertex].filter((v) => v - secondVertex);
            this.adjacentList[secondVertex] = this.adjacentList[secondVertex].filter((v) => v - firstVertex);
            return true;
        }
        return false;
    }

    removeVertex(vertex) {
        if(!this.adjacentList[vertex]) return undefined;
        while(this.adjacentList[vertex].length) {
            let temp = this.adjacentList[vertex].pop();
            this.removeEdge(vertex, temp);
        }
        delete this.adjacentList[vertex];
        this.numberOfVertices--;
        return this;
    }

    showConnections() {
        const allVertices = Object.keys(this.adjacentList);
        for (let vertex of allVertices) {
            const vertexConnections = this.adjacentList[vertex];
            let connections = '';
            for (let vertex of vertexConnections) {
                connections += vertex + ' ';
            }
            console.log(vertex +' --> ', connections);
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
myGraph.removeEdge('3', '5');
myGraph.removeEdge('2', '4');
myGraph.removeVertex('5');
myGraph.removeVertex('4');
myGraph.showConnections();



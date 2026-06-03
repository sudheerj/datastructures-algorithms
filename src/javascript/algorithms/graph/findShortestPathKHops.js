/**
 * Find Shortest Path with K Hops
 * 
 * Given a directed weighted graph, find the minimum cost path from source to 
 * destination using at most k edges (hops). Return -1 if no such path exists.
 * 
 * TC: O((V + E) * k * log(V * k))
 * SC: O(V * k)
 */

/**
 * Edge class representing a directed weighted edge
 */
class Edge {
    constructor(to, weight) {
        this.to = to;
        this.weight = weight;
    }
}

/**
 * State class for priority queue
 */
class State {
    constructor(cost, node, hops) {
        this.cost = cost;
        this.node = node;
        this.hops = hops;
    }
}

/**
 * Min-heap implementation for priority queue
 */
class MinHeap {
    constructor() {
        this.heap = [];
    }

    push(state) {
        this.heap.push(state);
        this._bubbleUp(this.heap.length - 1);
    }

    pop() {
        if (this.isEmpty()) return null;
        if (this.heap.length === 1) return this.heap.pop();

        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this._bubbleDown(0);
        return min;
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    _bubbleUp(index) {
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[index].cost >= this.heap[parentIndex].cost) break;
            [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
            index = parentIndex;
        }
    }

    _bubbleDown(index) {
        while (true) {
            let minIndex = index;
            const leftChild = 2 * index + 1;
            const rightChild = 2 * index + 2;

            if (leftChild < this.heap.length && this.heap[leftChild].cost < this.heap[minIndex].cost) {
                minIndex = leftChild;
            }
            if (rightChild < this.heap.length && this.heap[rightChild].cost < this.heap[minIndex].cost) {
                minIndex = rightChild;
            }
            if (minIndex === index) break;

            [this.heap[index], this.heap[minIndex]] = [this.heap[minIndex], this.heap[index]];
            index = minIndex;
        }
    }
}

/**
 * Find shortest path from src to dst with at most k hops
 * 
 * @param {Edge[][]} graph - Adjacency list where graph[i] is array of Edge objects
 * @param {number} src - Source node
 * @param {number} dst - Destination node
 * @param {number} k - Maximum number of hops allowed
 * @return {number} Minimum cost to reach dst from src with at most k hops, or -1
 */
function shortestPathWithKHops(graph, src, dst, k) {
    const n = graph.length;

    // best[node][hops] = minimum cost to reach node using exactly hops edges
    const best = Array.from({ length: n }, () => Array(k + 1).fill(Infinity));

    // Priority queue: ordered by cost
    const pq = new MinHeap();
    pq.push(new State(0, src, 0));
    best[src][0] = 0;

    while (!pq.isEmpty()) {
        const { cost, node, hops } = pq.pop();

        // If we reached destination, return the cost
        if (node === dst) {
            return cost;
        }

        // Cannot exceed k hops
        if (hops > k) {
            continue;
        }

        // Explore all edges from current node
        for (const edge of graph[node]) {
            const newCost = cost + edge.weight;
            const newHops = hops + 1;

            if (newCost < best[edge.to][newHops]) {
                best[edge.to][newHops] = newCost;
                pq.push(new State(newCost, edge.to, newHops));
            }
        }
    }

    return -1; // Not reachable
}

// Test cases
console.log("Test case 1:");
const graph1 = [
    [new Edge(1, 100), new Edge(2, 500)],  // Node 0
    [new Edge(2, 100)],                     // Node 1
    [new Edge(3, 100)],                     // Node 2
    []                                      // Node 3
];
const result1 = shortestPathWithKHops(graph1, 0, 3, 1);
console.log("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
console.log("Source: 0, Destination: 3, K: 1");
console.log(`Output: ${result1}`);
console.log("Expected: -1 (need at least 2 hops)");
console.log();

console.log("Test case 2:");
const graph2 = [
    [new Edge(1, 100), new Edge(2, 500)],  // Node 0
    [new Edge(2, 100)],                     // Node 1
    [new Edge(3, 100)],                     // Node 2
    []                                      // Node 3
];
const result2 = shortestPathWithKHops(graph2, 0, 3, 2);
console.log("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
console.log("Source: 0, Destination: 3, K: 2");
console.log(`Output: ${result2}`);
console.log("Expected: 600 (0->2->3 with cost 500+100=600)");
console.log();

console.log("Test case 3:");
const graph3 = [
    [new Edge(1, 100), new Edge(2, 500)],  // Node 0
    [new Edge(2, 100)],                     // Node 1
    [new Edge(3, 100)],                     // Node 2
    []                                      // Node 3
];
const result3 = shortestPathWithKHops(graph3, 0, 3, 3);
console.log("Graph: 0->(1:100, 2:500), 1->(2:100), 2->(3:100)");
console.log("Source: 0, Destination: 3, K: 3");
console.log(`Output: ${result3}`);
console.log("Expected: 300 (0->1->2->3 with cost 100+100+100=300)");
console.log();

console.log("Test case 4:");
const graph4 = [
    [new Edge(1, 100)],                          // Node 0
    [new Edge(2, 100), new Edge(0, 100)],       // Node 1
    [new Edge(0, 100)]                           // Node 2
];
const result4 = shortestPathWithKHops(graph4, 0, 2, 1);
console.log("Graph: 0->(1:100), 1->(2:100, 0:100), 2->(0:100)");
console.log("Source: 0, Destination: 2, K: 1");
console.log(`Output: ${result4}`);
console.log("Expected: 200 (0->1->2 with cost 100+100=200)");
console.log();

console.log("Test case 5:");
const graph5 = [
    [new Edge(1, 100)],  // Node 0
    [new Edge(2, 100)],  // Node 1
    [],                  // Node 2
    []                   // Node 3
];
const result5 = shortestPathWithKHops(graph5, 0, 3, 5);
console.log("Graph: 0->(1:100), 1->(2:100), 2->(), 3->()");
console.log("Source: 0, Destination: 3, K: 5");
console.log(`Output: ${result5}`);
console.log("Expected: -1 (no path from 0 to 3)");

module.exports = { shortestPathWithKHops, Edge };

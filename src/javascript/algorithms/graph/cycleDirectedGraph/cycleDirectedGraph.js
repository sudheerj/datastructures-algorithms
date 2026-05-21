// Recursive DFS + visited & pathVisited arrays => TC: O(V+E) SC: O(V)
function isCycle(V, adj) {
    const visited = new Array(V).fill(false);
    const pathVisited = new Array(V).fill(false);

    for (let i = 0; i < V; i++) {
        if (!visited[i]) {
            if (dfs(i, adj, visited, pathVisited)) return true;
        }
    }
    return false;
}

function dfs(node, adj, visited, pathVisited) {
    visited[node] = true;
    pathVisited[node] = true;

    for (const neighbour of adj[node]) {
        if (!visited[neighbour]) {
            if (dfs(neighbour, adj, visited, pathVisited)) return true;
        }
        if (pathVisited[neighbour]) return true;
    }

    pathVisited[node] = false;
    return false;
}

const testCases = [
    { V: 3, adj: [[1], [2], [0]], expected: true },          // simple cycle 0->1->2->0
    { V: 4, adj: [[1], [2], [3], []], expected: false },     // DAG, no cycle
    { V: 2, adj: [[1], [1]], expected: true },               // self-loop
    { V: 4, adj: [[], [2], [3], [1]], expected: true },      // disconnected, cycle in 1-2-3
    { V: 1, adj: [[]], expected: false },                    // single node
];

testCases.forEach(({ V, adj, expected }, i) => {
    const result = isCycle(V, adj);
    console.log(`Test ${i + 1}: Result=${result}, Expected=${expected}`);
});

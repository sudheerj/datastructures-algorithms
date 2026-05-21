/**
 * Max Path Quality of a Graph
 * DFS + Backtracking  TC: O(2^V)  SC: O(V + E)
 * @param {number[]} values
 * @param {number[][]} edges
 * @param {number} maxTime
 * @return {number}
 */
function maxPathQuality(values, edges, maxTime) {
    const n = values.length;

    // Build undirected weighted adjacency list
    const graph = Array.from({ length: n }, () => []);
    for (const [u, v, t] of edges) {
        graph[u].push([v, t]);
        graph[v].push([u, t]);
    }

    let maxScore = 0;
    const visitedCount = new Array(n).fill(0);

    function dfs(node, time, score) {
        // Add value only on first visit
        if (visitedCount[node] === 0) {
            score += values[node];
        }
        visitedCount[node]++;

        // Update maxScore whenever we return to node 0
        if (node === 0) {
            maxScore = Math.max(maxScore, score);
        }

        for (const [nei, cost] of graph[node]) {
            if (time + cost <= maxTime) {
                dfs(nei, time + cost, score);
            }
        }

        // Backtrack
        visitedCount[node]--;
    }

    dfs(0, 0, 0);
    return maxScore;
}

// Test 1: Classic example — best path is 0->3->0->1->0
console.log(maxPathQuality(
    [0, 32, 10, 43],
    [[0,1,10],[1,2,15],[0,3,10]],
    49)); // Expected: 75

// Test 2: Star graph — visit two best-value leaves within maxTime
console.log(maxPathQuality(
    [1, 2, 3, 4],
    [[0,1,5],[0,2,5],[0,3,5]],
    20)); // Expected: 8 (node0+node2+node3 = 1+3+4)

// Test 3: Single node, no edges
console.log(maxPathQuality(
    [5],
    [],
    10)); // Expected: 5

// Test 4: Can't travel to any node and return within maxTime
console.log(maxPathQuality(
    [1, 100],
    [[0,1,20]],
    10)); // Expected: 1

// Test 5: Linear path — traverse full chain and return
console.log(maxPathQuality(
    [10, 20, 30],
    [[0,1,5],[1,2,5]],
    20)); // Expected: 60 (0->1->2->1->0, time=20)

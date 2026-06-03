// Reconstruct Itinerary (LC 332)
// DFS + Hierholzer's algorithm  TC: O(E log E)  SC: O(E)

/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
function reconstructItinerary(tickets) {
    const graph = {};
    for (const [src, dst] of tickets) {
        if (!graph[src]) graph[src] = [];
        graph[src].push(dst);
    }
    for (const src in graph) {
        graph[src].sort().reverse(); // descending so pop() yields smallest
    }

    const result = [];

    function dfs(airport) {
        while (graph[airport] && graph[airport].length > 0) {
            dfs(graph[airport].pop());
        }
        result.push(airport);
    }

    dfs("JFK");
    return result.reverse();
}

function runTests() {
    const tests = [
        {
            tickets: [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]],
            expected: ["JFK","MUC","LHR","SFO","SJC"],
        },
        {
            tickets: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]],
            expected: ["JFK","ATL","JFK","SFO","ATL","SFO"],
        },
        {
            tickets: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]],
            expected: ["JFK","NRT","JFK","KUL"],
        },
        {
            tickets: [["JFK","A"],["A","JFK"]],
            expected: ["JFK","A","JFK"],
        },
    ];

    for (const { tickets, expected } of tests) {
        const result = reconstructItinerary(tickets);
        const pass = JSON.stringify(result) === JSON.stringify(expected);
        console.log(`[${pass ? "PASS" : "FAIL"}] result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

runTests();

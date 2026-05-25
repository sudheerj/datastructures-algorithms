/**
 * Course Schedule II (LeetCode 210)
 *
 * Return the ordering of courses to finish all numCourses, or [] if impossible.
 *
 * Approach 1: BFS Topological Sort (Kahn's Algorithm)  TC: O(V+E)  SC: O(V+E)
 * Approach 2: DFS Topological Sort                      TC: O(V+E)  SC: O(V+E)
 */

// --- Approach 1: BFS (Kahn's Algorithm) ---
function findOrderBFS(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);
    const indegrees = new Array(numCourses).fill(0);

    for (const [a, b] of prerequisites) {
        graph[b].push(a);
        indegrees[a]++;
    }

    const queue = [];
    for (let c = 0; c < numCourses; c++) {
        if (indegrees[c] === 0) queue.push(c);
    }

    const coursesOrder = [];

    while (queue.length > 0) {
        const curr = queue.shift();
        coursesOrder.push(curr);
        for (const neighbour of graph[curr]) {
            indegrees[neighbour]--;
            if (indegrees[neighbour] === 0) queue.push(neighbour);
        }
    }

    return coursesOrder.length === numCourses ? coursesOrder : [];
}

// --- Approach 2: DFS ---
function findOrderDFS(numCourses, prerequisites) {
    const prereqMap = Array.from({ length: numCourses }, () => []);
    for (const [a, b] of prerequisites) {
        prereqMap[a].push(b);
    }

    const visitSet = new Set();
    const coursesOrder = [];

    function dfs(course) {
        if (visitSet.has(course)) return false;
        if (prereqMap[course] === null) return true;  // already fully processed
        visitSet.add(course);
        for (const neighbour of prereqMap[course]) {
            if (!dfs(neighbour)) return false;
        }
        visitSet.delete(course);
        prereqMap[course] = null;  // mark as processed
        coursesOrder.push(course);
        return true;
    }

    for (let i = 0; i < numCourses; i++) {
        if (!dfs(i)) return [];
    }

    return coursesOrder;
}

const testCases = [
    { num: 2, prereqs: [[1, 0]],                     hasOrder: true,  label: "linear chain (n=2)" },
    { num: 4, prereqs: [[1,0],[2,0],[3,1],[3,2]],    hasOrder: true,  label: "diamond graph (n=4)" },
    { num: 2, prereqs: [[0,1],[1,0]],                hasOrder: false, label: "cycle — impossible (n=2)" },
    { num: 3, prereqs: [],                           hasOrder: true,  label: "no prerequisites (n=3)" },
    { num: 1, prereqs: [],                           hasOrder: true,  label: "single course (n=1)" },
];

console.log("=== BFS ===");
testCases.forEach(({ num, prereqs, hasOrder, label }) => {
    const result = findOrderBFS(num, prereqs);
    const valid = (result.length === num) === hasOrder;
    console.log(`  [${valid ? "PASS" : "FAIL"}] ${label}: [${result}]`);
});

console.log("=== DFS ===");
testCases.forEach(({ num, prereqs, hasOrder, label }) => {
    const result = findOrderDFS(num, prereqs);
    const valid = (result.length === num) === hasOrder;
    console.log(`  [${valid ? "PASS" : "FAIL"}] ${label}: [${result}]`);
});

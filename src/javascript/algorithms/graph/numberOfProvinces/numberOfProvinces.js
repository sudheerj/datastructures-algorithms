// Number of Provinces (LC 547)
// Approach 1: Recursive DFS  TC: O(n^2)  SC: O(n)
// Approach 2: BFS             TC: O(n^2)  SC: O(n)
// Approach 3: Union-Find      TC: O(n^2)  SC: O(n)

function numberOfProvinces(isConnected) {
    const n = isConnected.length;
    const visited = new Array(n).fill(false);
    let provinces = 0;

    function dfs(city) {
        visited[city] = true;
        for (let neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[city][neighbor] === 1 && !visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) { dfs(i); provinces++; }
    }
    return provinces;
}

function numberOfProvinces2(isConnected) {
    const n = isConnected.length;
    const visited = new Array(n).fill(false);
    let provinces = 0;

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            const queue = [i];
            visited[i] = true;
            while (queue.length) {
                const city = queue.shift();
                for (let neighbor = 0; neighbor < n; neighbor++) {
                    if (isConnected[city][neighbor] === 1 && !visited[neighbor]) {
                        queue.push(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            provinces++;
        }
    }
    return provinces;
}

class UnionFind {
    constructor(n) {
        this.parent = Array.from({ length: n }, (_, i) => i);
        this.rank = new Array(n).fill(0);
        this.count = n;
    }
    find(x) {
        if (this.parent[x] !== x) this.parent[x] = this.find(this.parent[x]);
        return this.parent[x];
    }
    union(x, y) {
        const rx = this.find(x), ry = this.find(y);
        if (rx === ry) return;
        if (this.rank[rx] > this.rank[ry]) this.parent[ry] = rx;
        else if (this.rank[rx] < this.rank[ry]) this.parent[rx] = ry;
        else { this.parent[ry] = rx; this.rank[rx]++; }
        this.count--;
    }
}

function numberOfProvinces3(isConnected) {
    const n = isConnected.length;
    const uf = new UnionFind(n);
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (isConnected[i][j] === 1) uf.union(i, j);
        }
    }
    return uf.count;
}

function runTests() {
    const tests = [
        { isConnected: [[1,1,0],[1,1,0],[0,0,1]],                  expected: 2 },
        { isConnected: [[1,0,0],[0,1,0],[0,0,1]],                  expected: 3 },
        { isConnected: [[1,1,1],[1,1,1],[1,1,1]],                  expected: 1 },
        { isConnected: [[1,0,0,1],[0,1,1,0],[0,1,1,0],[1,0,0,1]], expected: 2 },
        { isConnected: [[1]],                                       expected: 1 },
    ];

    for (const [label, fn] of [
        ["Approach 1: Recursive DFS", numberOfProvinces],
        ["Approach 2: BFS",           numberOfProvinces2],
        ["Approach 3: Union-Find",    numberOfProvinces3],
    ]) {
        console.log(`--- ${label} ---`);
        for (const { isConnected, expected } of tests) {
            const result = fn(isConnected);
            console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
        }
    }
}

runTests();


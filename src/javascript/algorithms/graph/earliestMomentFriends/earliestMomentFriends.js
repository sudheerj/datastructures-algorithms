class UnionFind {
    constructor(n) {
        this.parent = Array.from({ length: n }, (_, i) => i);
        this.rank = new Array(n).fill(0);
        this.count = n;
    }

    find(x) {
        if (this.parent[x] !== x) {
            this.parent[x] = this.find(this.parent[x]);
        }
        return this.parent[x];
    }

    union(x, y) {
        const rootX = this.find(x);
        const rootY = this.find(y);
        if (rootX === rootY) return false;

        if (this.rank[rootX] > this.rank[rootY]) {
            this.parent[rootY] = rootX;
        } else if (this.rank[rootX] < this.rank[rootY]) {
            this.parent[rootX] = rootY;
        } else {
            this.parent[rootY] = rootX;
            this.rank[rootX]++;
        }
        this.count--;
        return true;
    }

    getCount() {
        return this.count;
    }
}

// TC: O(m log m) for sorting + O(m * α(n)) ≈ O(m log m),  SC: O(n)
function findTime(logs, n) {
    logs.sort((a, b) => a[0] - b[0]);
    const uf = new UnionFind(n);

    for (const [time, p1, p2] of logs) {
        if (uf.union(p1, p2)) {
            if (uf.getCount() === 1) return time;
        }
    }
    return -1;
}

const testCases = [
    { logs: [[20,0,1],[30,1,2],[10,0,3],[40,2,3]], n: 4, expected: 30 },
    { logs: [[9,3,0],[0,2,1],[8,0,1],[5,2,0]], n: 4, expected: 9 },
    { logs: [[10,0,1],[20,2,3]], n: 5, expected: -1 },
    { logs: [[5,0,1]], n: 2, expected: 5 },
    { logs: [[1,0,1],[2,1,2],[3,2,3],[4,3,4]], n: 5, expected: 4 },
];

testCases.forEach(({ logs, n, expected }, i) => {
    const result = findTime(logs, n);
    console.log(`Test ${i + 1}: Result=${result}, Expected=${expected}`);
});

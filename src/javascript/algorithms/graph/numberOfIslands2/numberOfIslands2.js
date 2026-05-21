class UnionFind {
    constructor(size) {
        this.parent = new Array(size).fill(-1);
        this.rank = new Array(size).fill(0);
    }

    addLand(x) {
        this.parent[x] = x;
    }

    isLand(x) {
        return this.parent[x] !== -1;
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
        return true;
    }
}

// TC: O(k * α(m*n)) ≈ O(k),  SC: O(m*n)
function numberOfIslands2(m, n, positions) {
    const result = [];
    const uf = new UnionFind(m * n);
    const directions = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    let islandsCount = 0;

    for (const [row, col] of positions) {
        const index = row * n + col;

        if (uf.isLand(index)) {
            result.push(islandsCount);
            continue;
        }

        uf.addLand(index);
        islandsCount++;

        for (const [dr, dc] of directions) {
            const nr = row + dr;
            const nc = col + dc;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            const neighbourIndex = nr * n + nc;
            if (uf.isLand(neighbourIndex)) {
                if (uf.union(index, neighbourIndex)) {
                    islandsCount--;
                }
            }
        }
        result.push(islandsCount);
    }
    return result;
}

const testCases = [
    { m: 3, n: 3, positions: [[0,0],[0,1],[1,2],[2,1]], expected: [1,1,2,3] },
    { m: 2, n: 2, positions: [[0,0],[0,1],[1,0],[1,1]], expected: [1,1,1,1] },
    { m: 1, n: 1, positions: [[0,0]], expected: [1] },
    { m: 3, n: 3, positions: [[0,0],[0,0],[0,1]], expected: [1,1,1] },
    { m: 3, n: 3, positions: [[0,0],[2,2],[1,1],[0,1],[1,0]], expected: [1,2,3,2,2] },
];

testCases.forEach(({ m, n, positions, expected }, i) => {
    const result = numberOfIslands2(m, n, positions);
    console.log(`Test ${i + 1}: Result=${JSON.stringify(result)}, Expected=${JSON.stringify(expected)}`);
});

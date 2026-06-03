function shortestBridge(grid) {
    const n = grid.length, m = grid[0].length;
    const directions = [[-1,0],[1,0],[0,-1],[0,1]];
    const queue = [];
    let found = false;
    function dfs(r, c) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] !== 1) return;
        grid[r][c] = -1;
        queue.push([r, c]);
        for (const [dr, dc] of directions) {
            dfs(r+dr, c+dc);
        }
    }
    for (let i = 0; i < n && !found; i++) {
        for (let j = 0; j < m && !found; j++) {
            if (grid[i][j] === 1) {
                dfs(i, j);
                found = true;
            }
        }
    }
    let steps = 0;
    while (queue.length) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            const [r, c] = queue.shift();
            for (const [dr, dc] of directions) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (grid[nr][nc] === 1) return steps;
                    if (grid[nr][nc] === 0) {
                        grid[nr][nc] = -1;
                        queue.push([nr, nc]);
                    }
                }
            }
        }
        steps++;
    }
    return -1;
}

function deepCopy(arr) {
    return arr.map(row => row.slice());
}

function runTests() {
    const tests = [
        { grid: [[0,1],[1,0]], expected: 1 },
        { grid: [[0,1,0],[0,0,0],[0,0,1]], expected: 2 },
        { grid: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]], expected: 1 },
        { grid: [[0,1,1,0,0],[0,0,0,0,0],[0,0,0,0,1],[0,0,0,0,1]], expected: 2 },
        { grid: [[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,1]], expected: 4 },
    ];
    tests.forEach((test, i) => {
        const result = shortestBridge(deepCopy(test.grid));
        console.log(`Test ${i+1}: Output=${result}, Expected=${test.expected} [${result===test.expected?'PASS':'FAIL'}]`);
    });
}

runTests();

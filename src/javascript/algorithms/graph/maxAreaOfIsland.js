// Max Area of Island (LeetCode 695)
// DFS and BFS solutions
function maxAreaOfIslandDFS(grid) {
    const rows = grid.length, cols = grid[0].length;
    const copy = grid.map(row => row.slice());
    function dfs(r, c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || copy[r][c] === 0) return 0;
        copy[r][c] = 0;
        return 1 + dfs(r-1, c) + dfs(r, c+1) + dfs(r+1, c) + dfs(r, c-1);
    }
    let maxArea = 0;
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (copy[r][c] === 1) {
                maxArea = Math.max(maxArea, dfs(r, c));
            }
        }
    }
    return maxArea;
}

function maxAreaOfIslandBFS(grid) {
    const rows = grid.length, cols = grid[0].length;
    const copy = grid.map(row => row.slice());
    const directions = [[-1,0],[0,1],[1,0],[0,-1]];
    let maxArea = 0;
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (copy[r][c] === 1) {
                let area = 0;
                const queue = [[r, c]];
                copy[r][c] = 0;
                while (queue.length) {
                    const [row, col] = queue.shift();
                    area++;
                    for (const [dr, dc] of directions) {
                        const nr = row + dr, nc = col + dc;
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && copy[nr][nc] === 1) {
                            queue.push([nr, nc]);
                            copy[nr][nc] = 0;
                        }
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }
    }
    return maxArea;
}

// Test harness
const testGrids = [
    [
        [0,0,1,0,0,0,0,1,0,0,0,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,1,1,0,1,0,0,0,0,0,0,0,0],
        [0,1,0,0,1,1,0,0,1,0,1,0,0],
        [0,1,0,0,1,1,0,0,1,1,1,0,0],
        [0,0,0,0,0,0,0,0,0,0,1,0,0]
    ],
    [[0,0,0,0,0,0,0,0]],
    [[1,1,1],[1,0,1],[1,1,1]]
];
const expected = [6, 0, 8];

console.log("Testing Max Area of Island (DFS):");
for (let i = 0; i < testGrids.length; i++) {
    const res = maxAreaOfIslandDFS(testGrids[i]);
    console.log((res === expected[i] ? "PASS" : "FAIL") + ` Test ${i+1}: got ${res}, expected ${expected[i]}`);
}

console.log("\nTesting Max Area of Island (BFS):");
for (let i = 0; i < testGrids.length; i++) {
    const res = maxAreaOfIslandBFS(testGrids[i]);
    console.log((res === expected[i] ? "PASS" : "FAIL") + ` Test ${i+1}: got ${res}, expected ${expected[i]}`);
}

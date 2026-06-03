function orangesRotting(grid) {
    const rows = grid.length, cols = grid[0].length;
    const queue = [];
    let fresh = 0;
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] === 2) {
                queue.push([r, c]);
            } else if (grid[r][c] === 1) {
                fresh++;
            }
        }
    }
    let minutes = 0;
    const directions = [[-1,0],[0,1],[1,0],[0,-1]];
    while (queue.length && fresh > 0) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            const [row, col] = queue.shift();
            for (const [dr, dc] of directions) {
                const nr = row + dr, nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] === 1) {
                    grid[nr][nc] = 2;
                    queue.push([nr, nc]);
                    fresh--;
                }
            }
        }
        minutes++;
    }
    return fresh === 0 ? minutes : -1;
}

function deepCopy(grid) {
    return grid.map(row => row.slice());
}

function runTests() {
    const testCases = [
        // Example 1
        [
            [2,1,1],
            [1,1,0],
            [0,1,1]
        ],
        // Example 2
        [
            [2,1,1],
            [0,1,1],
            [1,0,1]
        ],
        // Example 3
        [
            [0,2]
        ],
        // All rotten
        [
            [2,2],
            [2,2]
        ],
        // No oranges
        [
            [0,0],
            [0,0]
        ]
    ];
    const expected = [4, -1, 0, 0, 0];
    testCases.forEach((grid, i) => {
        const result = orangesRotting(deepCopy(grid));
        const exp = expected[i];
        const status = result === exp ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${exp} | ${status}`);
    });
}

if (require.main === module) {
    runTests();
}

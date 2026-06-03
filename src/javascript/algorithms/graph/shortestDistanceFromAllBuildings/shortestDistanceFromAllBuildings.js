// BFS Shortest path TC: O(k * m * n) SC: O(m * n)
function shortestDistance(grid) {
    const rows = grid.length, cols = grid[0].length;
    const distance = Array.from({ length: rows }, () => new Array(cols).fill(0));
    let walk = 0;
    let answer = Infinity;
    const directions = [[-1, 0], [0, 1], [1, 0], [0, -1]];

    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            if (grid[row][col] === 1) {
                const queue = [[row, col]];
                let head = 0;
                let level = 0;

                while (head < queue.length) {
                    const size = queue.length - head;

                    for (let i = 0; i < size; i++) {
                        const [r, c] = queue[head++];
                        for (const [dr, dc] of directions) {
                            const nr = r + dr, nc = c + dc;
                            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] !== walk) {
                                continue;
                            }
                            grid[nr][nc]--;                              // mark visited
                            distance[nr][nc] += level + 1;               // accumulate distance
                            answer = Math.min(answer, distance[nr][nc]);  // update best answer
                            queue.push([nr, nc]);
                        }
                    }

                    level++;
                }

                walk--;
            }
        }
    }

    return answer === Infinity ? -1 : answer;
}

function deepCopy(grid) {
    return grid.map(row => [...row]);
}

function runTests() {
    const tests = [
        { grid: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]], expected: 7  },
        { grid: [[1,0]],                                expected: 1  },
        { grid: [[1]],                                  expected: -1 },
        { grid: [[0,1,0],[0,0,0],[0,1,0]],              expected: 2  },
        { grid: [[0,2,1]],                              expected: -1 },
    ];

    for (const { grid, expected } of tests) {
        const result = shortestDistance(deepCopy(grid));
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    }
}

runTests();

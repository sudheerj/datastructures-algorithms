function getPos(num, n) {
    const rowFromBottom = Math.floor((num-1)/n);
    const row = n-1-rowFromBottom;
    let col = (num-1)%n;
    if (rowFromBottom%2 === 1) {
        col = n-1-col;
    }
    return [row, col];
}

function snakesAndLadders(board) {
    const n = board.length;
    const visited = Array(n*n+1).fill(false);
    const queue = [1];
    visited[1] = true;
    let moves = 0;
    while (queue.length) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            const curr = queue.shift();
            if (curr === n*n) return moves;
            for (let dice = 1; dice <= 6; dice++) {
                let next = curr + dice;
                if (next > n*n) continue;
                const [r, c] = getPos(next, n);
                if (board[r][c] !== -1) {
                    next = board[r][c];
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.push(next);
                }
            }
        }
        moves++;
    }
    return -1;
}

function deepCopy(grid) {
    return grid.map(row => row.slice());
}

function runTests() {
    const testCases = [
        // Example 1
        [
            [-1,-1,-1,-1,-1,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,35,-1,-1,13,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,15,-1,-1,-1,-1]
        ],
        // Example 2 (no snakes/ladders)
        [
            [-1,-1,-1],
            [-1,-1,-1],
            [-1,-1,-1]
        ],
        // Example 3 (ladder at start)
        [
            [-1,-1,-1],
            [-1,9,8],
            [-1,8,9]
        ]
    ];
    const expected = [4, 2, 1];
    testCases.forEach((board, i) => {
        const result = snakesAndLadders(deepCopy(board));
        const exp = expected[i];
        const status = result === exp ? "PASS" : "FAIL";
        console.log(`Test ${i+1} | Output: ${result} | Expected: ${exp} | ${status}`);
    });
}

if (require.main === module) {
    runTests();
}

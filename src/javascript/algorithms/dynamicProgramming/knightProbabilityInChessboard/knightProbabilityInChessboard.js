/**
 * Knight Probability in Chessboard
 * 
 * Given an n x n chessboard and a knight starting at (row, column),
 * return the probability that the knight remains on the board after making exactly k moves.
 */

/**
 * Top-down memoization TC: O(n^2 * k) SC: O(n^2 * k)
 */
function knightProbabilityMemoization(n, k, row, column) {
    const DIRS = [[2, 1], [2, -1], [1, 2], [1, -2], [-2, 1], [-2, -1], [-1, 2], [-1, -2]];
    const memo = new Map();
    
    function dfs(r, c, moves) {
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0;
        }
        
        if (moves === 0) {
            return 1.0;
        }
        
        const key = `${r},${c},${moves}`;
        if (memo.has(key)) {
            return memo.get(key);
        }
        
        let prob = 0.0;
        for (const [dr, dc] of DIRS) {
            prob += dfs(r + dr, c + dc, moves - 1) / 8.0;
        }
        
        memo.set(key, prob);
        return prob;
    }
    
    return dfs(row, column, k);
}

/**
 * Bottom-up DP with space optimization TC: O(n^2 * k) SC: O(n^2)
 */
function knightProbabilityDP(n, k, row, column) {
    const DIRS = [[2, 1], [2, -1], [1, 2], [1, -2], [-2, 1], [-2, -1], [-1, 2], [-1, -2]];
    
    // Initialize board with probability 1.0 at starting position
    let dp = Array.from({ length: n }, () => Array(n).fill(0.0));
    dp[row][column] = 1.0;
    
    // For each move
    for (let move = 0; move < k; move++) {
        const nextDp = Array.from({ length: n }, () => Array(n).fill(0.0));
        
        for (let r = 0; r < n; r++) {
            for (let c = 0; c < n; c++) {
                if (dp[r][c] === 0) {
                    continue;
                }
                
                // Distribute probability to all 8 knight destinations
                for (const [dr, dc] of DIRS) {
                    const nr = r + dr;
                    const nc = c + dc;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        nextDp[nr][nc] += dp[r][c] / 8.0;
                    }
                }
            }
        }
        
        dp = nextDp;
    }
    
    // Sum all probabilities on the board
    return dp.reduce((sum, row) => sum + row.reduce((rowSum, prob) => rowSum + prob, 0), 0);
}

// Test harness
const tests = [
    [3, 2, 0, 0, 0.0625],
    [1, 0, 0, 0, 1.0],
    [8, 30, 6, 4, 0.00019],
    [3, 1, 1, 1, 0.0],
    [8, 0, 4, 4, 1.0],
    [8, 1, 0, 0, 0.25],
    [8, 2, 4, 4, 0.875],
    [5, 2, 2, 2, 0.375],
    [6, 3, 2, 2, 0.359375],
    [4, 3, 1, 1, 0.0703125]
];

console.log("Knight Probability in Chessboard - Test Results:");
console.log("=".repeat(100));

let passed = 0;
tests.forEach(([n, k, row, column, expected], index) => {
    // Test both approaches
    const result1 = knightProbabilityMemoization(n, k, row, column);
    const result2 = knightProbabilityDP(n, k, row, column);
    
    const pass = (Math.abs(result1 - expected) < 1e-5 && Math.abs(result2 - expected) < 1e-5);
    
    // Debug: print all results if test fails
    if (!pass) {
        console.log(`Test ${String(index + 1).padStart(2)} FAIL | n=${n}, k=${k}, pos=(${row},${column})`);
        console.log(`  Memoization: ${result1.toFixed(6)}, DP: ${result2.toFixed(6)} | Expected: ${expected.toFixed(6)}`);
    } else {
        console.log(`Test ${String(index + 1).padStart(2)} | n=${n}, k=${String(k).padStart(2)}, pos=(${row},${column}) | Output: ${result1.toFixed(6)} | Expected: ${expected.toFixed(6)} | PASS`);
        passed++;
    }
});

console.log("=".repeat(100));
console.log(`Tests Passed: ${passed}/${tests.length}`);

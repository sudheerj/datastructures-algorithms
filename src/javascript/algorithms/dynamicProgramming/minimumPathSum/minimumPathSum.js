/**
 * Minimum Path Sum (LeetCode 64)
 *
 * Find the path from top-left to bottom-right (only right/down moves)
 * with the minimum sum.
 *
 * Approach 1: Top-down Memoization  TC: O(m*n)  SC: O(m*n)
 * Approach 2: Bottom-up DP          TC: O(m*n)  SC: O(m*n)
 * Approach 3: Space-Optimized DP    TC: O(m*n)  SC: O(n)
 */

// Approach 1: Top-down Memoization
function minPathSum1(grid) {
    const rows = grid.length, cols = grid[0].length;
    const memo = new Map();

    function dfs(r, c) {
        if (r >= rows || c >= cols) return Infinity;
        if (r === rows - 1 && c === cols - 1) return grid[r][c];
        const key = `${r},${c}`;
        if (memo.has(key)) return memo.get(key);
        const val = grid[r][c] + Math.min(dfs(r + 1, c), dfs(r, c + 1));
        memo.set(key, val);
        return val;
    }

    return dfs(0, 0);
}

// Approach 2: Bottom-up DP
function minPathSum2(grid) {
    const rows = grid.length, cols = grid[0].length;
    const dp = Array.from({ length: rows + 1 }, () => new Array(cols + 1).fill(Infinity));
    dp[rows - 1][cols] = 0;

    for (let r = rows - 1; r >= 0; r--) {
        for (let c = cols - 1; c >= 0; c--) {
            dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
        }
    }

    return dp[0][0];
}

// Approach 3: Space-Optimized DP
function minPathSum3(grid) {
    const rows = grid.length, cols = grid[0].length;
    const dp = new Array(cols + 1).fill(Infinity);
    dp[cols - 1] = 0;

    for (let r = rows - 1; r >= 0; r--) {
        for (let c = cols - 1; c >= 0; c--) {
            dp[c] = grid[r][c] + Math.min(dp[c], dp[c + 1]);
        }
    }

    return dp[0];
}

const testCases = [
    { grid: [[1,3,1],[1,5,1],[4,2,1]], expected: 7,  label: "3x3 standard" },
    { grid: [[1,2,3],[4,5,6]],         expected: 12, label: "2x3 grid" },
    { grid: [[1]],                     expected: 1,  label: "single cell" },
    { grid: [[1,2],[1,1]],             expected: 3,  label: "2x2 grid" },
    { grid: [[5,1,2],[3,6,4],[1,8,1]], expected: 13, label: "3x3 off-diagonal min" },
];
const methods = [
    ["Top-down Memoization", minPathSum1],
    ["Bottom-up DP",         minPathSum2],
    ["Space-Optimized DP",   minPathSum3],
];

methods.forEach(([name, fn]) => {
    console.log(`=== ${name} ===`);
    testCases.forEach(({ grid, expected, label }) => {
        const result = fn(grid);
        console.log(`  [${result === expected ? "PASS" : "FAIL"}] ${label}: ${result}  (expected ${expected})`);
    });
});

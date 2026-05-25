/**
 * Minimum Falling Path Sum (LeetCode 931)
 *
 * Given an n x n matrix, find the minimum sum of a falling path.
 * From (r, c) you can move to (r+1, c-1), (r+1, c), or (r+1, c+1).
 *
 * Approach 1: Top-down Memoization  TC: O(n^2)  SC: O(n^2)
 * Approach 2: Bottom-up In-place    TC: O(n^2)  SC: O(1)
 */

// Approach 1: Top-down Memoization
function minFallingPathSum1(matrix) {
    const n = matrix.length;
    const memo = new Map();

    function dfs(r, c) {
        if (r === n) return 0;
        if (c < 0 || c >= n) return Infinity;
        const key = `${r},${c}`;
        if (memo.has(key)) return memo.get(key);
        const val = matrix[r][c] + Math.min(dfs(r + 1, c - 1), dfs(r + 1, c), dfs(r + 1, c + 1));
        memo.set(key, val);
        return val;
    }

    let min = Infinity;
    for (let c = 0; c < n; c++) min = Math.min(min, dfs(0, c));
    return min;
}

// Approach 2: Bottom-up In-place (operates on a copy)
function minFallingPathSum2(matrix) {
    const m = matrix.map(row => [...row]);
    const n = m.length;

    for (let r = 1; r < n; r++) {
        for (let c = 0; c < n; c++) {
            const left  = c > 0     ? m[r - 1][c - 1] : Infinity;
            const mid   = m[r - 1][c];
            const right = c < n - 1 ? m[r - 1][c + 1] : Infinity;
            m[r][c] += Math.min(left, mid, right);
        }
    }

    return Math.min(...m[n - 1]);
}

const testCases = [
    { matrix: [[2,1,3],[6,5,4],[7,8,9]],   expected: 13,  label: "3x3 standard" },
    { matrix: [[-19,57],[-40,-5]],          expected: -59, label: "2x2 negative" },
    { matrix: [[1]],                         expected: 1,   label: "single cell" },
    { matrix: [[1,2,3],[4,5,6],[7,8,9]],   expected: 12,  label: "3x3 ascending" },
    { matrix: [[-1,-2],[-3,-4]],            expected: -6,  label: "2x2 all negative" },
];

const methods = [
    ["Top-down Memoization", minFallingPathSum1],
    ["Bottom-up In-place",   minFallingPathSum2],
];

methods.forEach(([name, fn]) => {
    console.log(`=== ${name} ===`);
    testCases.forEach(({ matrix, expected, label }) => {
        const result = fn(matrix);
        console.log(`  [${result === expected ? "PASS" : "FAIL"}] ${label}: ${result}  (expected ${expected})`);
    });
});
